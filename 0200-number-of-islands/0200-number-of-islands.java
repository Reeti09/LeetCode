class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    c++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return c;
        
    }
    private void bfs(int i, int j, boolean[][] vis, char[][] grid) {
    vis[i][j] = true;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{i, j});
    int n = grid.length;
    int m = grid[0].length;

    // Only 4 directions: up, down, left, right
    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, -1, 0, 1};

    while (!q.isEmpty()) {
        int[] cell = q.poll();
        int row = cell[0];
        int col = cell[1];

        for (int k = 0; k < 4; k++) {
            int newRow = row + delRow[k];
            int newCol = col + delCol[k];

            if (isValid(newRow, newCol, n, m) && grid[newRow][newCol] == '1' && !vis[newRow][newCol]) {
                vis[newRow][newCol] = true;
                q.add(new int[]{newRow, newCol});
            }
        }
    }
}

    
    private boolean isValid(int i, int j, int n, int m){
        if(i<0 || i>=n) return false;
        if(j<0 || j>=m) return false;
        return true;
    }
}