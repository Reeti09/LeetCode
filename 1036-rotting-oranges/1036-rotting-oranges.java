class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==2){
                    q.add(new int[]{r,c});
                }
                else if(grid[r][c]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int minutes=0;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty() && fresh>0){
            minutes++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] rotten=q.poll();
                int r=rotten[0];
                int c=rotten[1];
                for(int[] dir: directions){
                    int newR=r+dir[0];
                    int newC=c+dir[1];
                    if(newR>=0 && newR<rows && newC>=0 && newC<cols && grid[newR][newC]==1){
                        grid[newR][newC]=2;
                        fresh--;
                        q.add(new int[]{newR, newC});

                    }
                }
            }
        }
        return fresh==0?minutes: -1;
        
    }
}