package 数组;

public class 礼物的最大价值 {
    public static int maxValue(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for (int i = 1; i <n ; i++) {
            grid[0][i]=grid[0][i]+grid[0][i-1];
        }
        for (int i = 1; i <m ; i++) {
            grid[i][0]=grid[i-1][0]+grid[i][0];
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                grid[i][j]+=Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] r={{1,3,1},{1,5,1},{4,2,1}};
        int v=maxValue(r);
        System.out.println(v);
    }

}
