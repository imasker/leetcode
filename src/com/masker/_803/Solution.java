package com.masker._803;

import org.omg.PortableServer.POA;

import java.util.*;

/**
 * @author masker
 * @date 2019/8/15 11:39 AM
 */
public class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        Set<Point> nowRemain = new HashSet<>(); //存放当前状态不掉落的砖块信息
        int hitsSize = hits.length;
        int[] result = new int[hitsSize]; //存储结果
        int rowSize = grid.length, colSize = grid[0].length;
        //第一步：将所有即将敲击的位置进行减1操作，让它减一而不是变为零，是因为可能hit了多次，只有还原最开始的那一次hit之后才能将这个砖块恢复
        for (int i = 0; i < hitsSize; ++i) {
            --grid[hits[i][0]][hits[i][1]];
        }
        //第二步：将现在所有与顶层有直接、间接连接的砖块恢复（因为第一步去除了所有敲击的位置的砖块，所以当所有敲击完成后，这些与顶层有直接、间接连接的砖块仍然不会掉落
        for (int col = 0; col < colSize; ++col) {
            if(grid[0][col] == 1) {//顶层第col个位置
                findRemain(grid, 0, col, nowRemain);
            }
        }
        //第三步：从最后一次hit开始，逐步恢复砖块，并且找到因为hit当前砖块而掉落的砖块，将其加入remain中
        for (int k = hitsSize - 1; k >= 0; --k) {
            int row = hits[k][0];//获取敲击的位置
            int col = hits[k][1];
            grid[row][col] += 1;//在第一步的时候是减一，这里进行加1逆操作
            if(grid[row][col] == 1) {//grid[row][col] != 1,说明这个位置hit了多次，还没有到最开始的那个hit，所以不能恢复
                //注意我们是从后往前逆恢复，当前remain的大小是敲击了当前位置后剩余的大小
                int afterHitRemainSize = (int)nowRemain.size();//敲击当前砖块后的剩余砖块数（
                //我们现在需要判断grid[row][col]是否是能够不掉落（只有当grid[row][col]在顶层，或者上下左右存在不掉落的砖块，则grid[row][col]也能够不掉落
                //如果当前hit的砖块不能固定，说明在hit前它已经掉落了，那么就不应该搜索恢复它周围的砖块，因为它们不是因为hit它而掉落的
                if(row == 0 || (row > 0 && nowRemain.contains(new Point(row-1, col))) || (row < rowSize - 1 && nowRemain.contains(new Point(row+1, col)))
                        || (col > 0 && nowRemain.contains(new Point(row, col-1))) || (col < colSize - 1 && nowRemain.contains(new Point(row, col+1)))) {
                    findRemain(grid, row , col, nowRemain);//开始恢复grid[row][col]及其直接、间接相连的砖块
                    //现在remain的大小是敲击grid[row][col]之前剩余的砖块数，而afterHitRemainSize是敲击之后剩余的砖块数
                    result[k] = (int)nowRemain.size() - afterHitRemainSize - 1; //grid[row][col]这个砖块是敲击掉的，不算在掉落砖块数内
                }
            }

        }
        return result;
    }
    //在grid[row][col]不掉落的前提下，我们将它上下左右四个方向的砖进行恢复
    void findRemain(int[][] grid, int row, int col, Set<Point> nowRemain) {
        int rowSize = grid.length, colSize = grid[0].length;
        //如果这grid[row][col]不是砖块，则不是恢复的前提，h如果这个位置已经在remain中，说明这块砖已经恢复了
        if(grid[row][col] != 1 || nowRemain.contains(new Point(row, col))) {
            return;
        }
        nowRemain.add(new Point(row, col));//插入到nowRemain中（表示恢复
        //分别恢复它的上下左右四个方向
        if(row > 0) {
            findRemain(grid, row - 1, col, nowRemain);
        }
        if(row < rowSize - 1) {
            findRemain(grid, row + 1, col, nowRemain);
        }
        if(col > 0) {
            findRemain(grid, row, col - 1, nowRemain);
        }
        if(col < colSize - 1) {
            findRemain(grid, row, col + 1, nowRemain);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{1,0,1},{1,1,1}};
        int[][] hits = new int[][]{{0,0},{0,2},{1,1}};
        int[] ans = solution.hitBricks(grid, hits);
        System.out.println(Arrays.toString(ans));
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point point = (Point) obj;
            if (x == point.x && y == point.y) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int hashCode() {
        return x*200+y;
    }
}
