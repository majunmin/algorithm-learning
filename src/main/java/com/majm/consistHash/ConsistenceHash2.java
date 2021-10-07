package com.majm.consistHash;

import org.apache.commons.collections.MapUtils;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 带虚拟节点 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-04-02 17:58
 * @since
 */
public class ConsistenceHash2 {

    /**
     * key表示服务器的hash值，value表示服务器的名称
     */
    private static SortedMap<Integer, String> sortedMap =
            new TreeMap<>();

    /**
     * 虚拟节点，key表示虚拟节点的hash值，value表示虚拟节点的名称
     */
    private static SortedMap<Integer, String> virtualNodes =
            new TreeMap<>();

    private static final int VIRTUAL_NODES = 5;

    private static int hash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        return hash < 0 ? -hash : hash;
    }

    String getServer(Integer hash, List<String> serverHosts) {

        for (String serverHost : serverHosts) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String VNNodeName = serverHost + "&&VN" + i;
                Integer hashCode = hash(VNNodeName);
                sortedMap.put(hashCode, VNNodeName);
            }
        }

        SortedMap<Integer, String> tailMap = sortedMap.tailMap(hash);
        String virtualNode;
        if (MapUtils.isEmpty(tailMap)) {
            virtualNode = sortedMap.get(sortedMap.firstKey());
        } else {
            virtualNode = sortedMap.get(tailMap.firstKey());
        }
        return virtualNode.substring(0, virtualNode.lastIndexOf("&&VN"));
    }


}
