package com.masker._847;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathLength {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1<<n];
        Queue<Pair> qt = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 999);
            qt.offer(new Pair(i, 1<<i));
            dp[i][1<<i] = 0;
        }
        int endStatus = (1<<n) - 1;
        while (!qt.isEmpty()) {
            Pair pi = qt.poll();
            int head = pi.head;
            int d = dp[head][pi.status];
            if (pi.status == endStatus) return d;
            for (int i = 0; i < graph[head].length; i++) {
                int tmp = graph[head][i];
                int tmpStatus = pi.status | (1 << tmp);
                if (d+1 < dp[tmp][tmpStatus]) {
                    dp[tmp][tmpStatus] = d+1;
                    qt.offer(new Pair(tmp, tmpStatus));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ShortestPathLength object = new ShortestPathLength();
        int[][] graph = new int[][]{{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(object.shortestPathLength(graph));
    }
}

class Pair {
    public int head, status;

    public Pair(int head, int status) {
        this.head = head;
        this.status = status;
    }
}
