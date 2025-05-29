class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length(), n=s2.length();
        if((m+n)!=s3.length()) return false;
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                int k = i + j - 1;
                if (i > 0) {
                    dp[j] &= s1.charAt(i - 1) == s3.charAt(k);
                }
                if (j > 0) {
                    dp[j] |= (dp[j - 1] & (s2.charAt(j - 1) == s3.charAt(k)));
                }
            }
        }
        return dp[n];
        
    }
}