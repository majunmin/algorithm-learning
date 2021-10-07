package com.majm.consistHash;

import org.apache.commons.collections.MapUtils;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 不带虚拟节点 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-04-02 17:52
 * @since
 */
public class ConsistenceHash1 {

    /**
     * key表示服务器的hash值，value表示服务器的名称
     */
    private static SortedMap<Integer, String> sortedMap =
            new TreeMap<>();

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
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    String getServer(int hash, List<String> serverList) {
        for (String serverHost : serverList) {
            int hashCode = hash(serverHost);
            sortedMap.put(hashCode, serverHost);
        }

        SortedMap<Integer, String> tailMap = sortedMap.tailMap(hash);
        if (MapUtils.isEmpty(tailMap)) {
            return sortedMap.get(sortedMap.firstKey());
        } else {
            return sortedMap.get(tailMap.firstKey());
        }
    }

}
