/*
* https://www.hackerrank.com/challenges/common-child/problem*/

public class CommonChild {
    public static int maxCommonSubseq(String s1, String s2,int i , int j, int n,int m,int[][] dp ){
        if(i>=n || j>= m) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = 1 + maxCommonSubseq(s1, s2, i+1, j+1, n, m, dp);

        int one = maxCommonSubseq(s1, s2, i+1, j, n, m, dp);
        int two = maxCommonSubseq(s1, s2, i, j+1, n, m, dp);

        return dp[i][j] = Math.max(one,two);
    }

    public static int commonChild(String s1, String s2) {
        // Write your code here
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }

        return maxCommonSubseq(s1,s2,0,0,n,m,dp);
    }
}
