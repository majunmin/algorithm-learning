package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 36. 有效的数独 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-31 09:30
 * @since
 */
public class LeetCode_0036 implements Solution {

    /**
     * 也可使用 hashMap 或者数组实现
     *
     * @param board
     * @return
     */
    @Override
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        List<Set<Character>> visitedCol = new ArrayList<>();
        List<Set<Character>> visitedRow = new ArrayList<>();
        List<Set<Character>> visitedCell = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            visitedRow.add(new HashSet<>());
            visitedCol.add(new HashSet<>());
            visitedCell.add(new HashSet<>());
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                char curChar = board[i][j];
                if (curChar == '.') {
                    continue;
                }
                if (visitedRow.get(i).contains(curChar)) {
                    return false;
                }
                if (visitedCol.get(j).contains(curChar)) {
                    return false;
                }
                int cellIdx = (i / 3) * 3 + (j / 3);
                if (visitedCell.get(cellIdx).contains(curChar)) {
                    return false;
                }

                // 记录 已经访问的
                visitedRow.get(i).add(curChar);
                visitedCol.get(j).add(curChar);
                visitedCell.get(cellIdx).add(curChar);
            }
        }
        return true;
    }

}
