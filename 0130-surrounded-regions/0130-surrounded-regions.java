class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && !vis[i][0]){
                q.add(new int[]{i, 0});
                vis[i][0]=true;
            }
            if(board[i][m-1]=='O' && !vis[i][m-1]){
                q.add(new int[]{i,m-1});
                vis[i][m-1]=true;

            }

        }
        for(int j=0;j<m;j++){
            if(board[0][j]=='O' && !vis[0][j]){
                q.add(new int[]{0, j});
                vis[0][j]=true;
            }
            if(board[n-1][j]=='O' && !vis[n-1][j]){
                q.add(new int[]{n-1, j});
                vis[n-1][j]=true;
            }
        }
        int[] delRow={-1,0,1,0};
        int[] delCol={0,-1,0,1};
        while(!q.isEmpty()){
            int[] cell=q.poll();
            int row=cell[0];
            int col=cell[1];
            for(int k=0;k<4;k++){
                int newRow=row+delRow[k];
                int newCol=col+delCol[k];
                if (isValid(newRow, newCol, n, m) &&
                    board[newRow][newCol] == 'O' && !vis[newRow][newCol]) {
                    
                    vis[newRow][newCol] = true;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}