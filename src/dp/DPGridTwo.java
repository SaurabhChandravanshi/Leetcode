package dp;

import java.util.Arrays;

public class DPGridTwo {
    public static void main(String[] args) {
        int M = 3;
        int N = 3;
        int[][] dp = new int[M][N];
        for(int[] row:dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(ways(dp, M, N));
    }

    public static int ways(int[][] dp, int M, int N) {
        int sub  = 0;
        for (int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(dp[i][j] != -1) {
                    sub = dp[i][j];
                } else {
                    sub = ways(dp, M + 1, N) + ways(dp, M, N + 1);
                    dp[i][j] = sub;
                }
            }
        }
        return dp[M-1][N-1];
    }
}
