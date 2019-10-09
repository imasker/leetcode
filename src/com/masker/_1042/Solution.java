package com.masker._1042;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author masker
 * @date 2019/10/9 3:39 PM
 */
public class Solution {

    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] ans = new int[N];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] path : paths) {
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }
        for (int i = 1; i <= N; i++) {
            boolean[] colorsUsed = new boolean[5];
            for (int j : map.get(i)) {
                colorsUsed[ans[j-1]] = true;
            }
            for (int j = 1; j < colorsUsed.length; j++) {
                if (!colorsUsed[j]) {
                    ans[i-1] = j;
                    break;
                }
            }
        }
        return ans;
    }
}
