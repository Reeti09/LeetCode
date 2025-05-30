class Solution 
{
    public int minDistance(String word1, String word2) 
    {
        final int m=word1.length();
        final int n=word2.length();
        int[][] costDP=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            costDP[i][0]=i;
        }
        for(int j=1;j<=n;j++){
            costDP[0][j]=j;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    costDP[i][j]=costDP[i-1][j-1];
                }
                else
                {
                    int topLeft=costDP[i-1][j-1];
                    int top=costDP[i-1][j];
                    int left=costDP[i][j-1];
                    costDP[i][j]=Math.min(topLeft, Math.min(top, left))+1;
                }
                
            }
        }
        return costDP[m][n];

    } 
    
}