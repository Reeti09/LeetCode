class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(boolean[] row: dp){
            Arrays.fill(row, true);
        }
        int maxLength=1;
        int start=0;
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[i][j]=false;
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1];
                    if(dp[i][j] && maxLength < (j-i+1)){
                        maxLength=j-i+1;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start, maxLength+start);
        
    }
}