package com.masker._130;

import java.util.*;

public class Solution {

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int width = board[0].length;
        int height = board.length;
        boolean[][] visited = new boolean[height][width];
        Queue<Point> queue = new LinkedList<>();
        for (int j = 0; j < width; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new Point(0, j));
            }
            if (board[height-1][j] == 'O') {
                queue.offer(new Point(height-1, j));
            }
        }
        for (int i = 1; i < height-1; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new Point(i, 0));
            }
            if (board[i][width-1] == 'O') {
                queue.offer(new Point(i, width-1));
            }
        }
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (visited[point.x][point.y]) continue;
            visited[point.x][point.y] = true;
            int x = point.x;
            int y = point.y;
            if (x - 1 >= 0 && board[x-1][y] == 'O') {
                if (!visited[x-1][y]) {
                    queue.offer(new Point(x-1, y));
                }
            }
            if (x + 1 < height && board[x+1][y] == 'O') {
                if (!visited[x+1][y]) {
                    queue.offer(new Point(x+1, y));
                }
            }
            if (y - 1 >= 0 && board[x][y-1] == 'O') {
                if (!visited[x][y-1]) {
                    queue.offer(new Point(x, y-1));
                }
            }
            if (y + 1 < width && board[x][y+1] == 'O') {
                if (!visited[x][y+1]) {
                    queue.offer(new Point(x, y+1));
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
    }

}

class Point {
    public int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
