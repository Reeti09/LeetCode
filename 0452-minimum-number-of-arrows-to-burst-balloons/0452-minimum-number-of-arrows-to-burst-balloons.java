class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        Arrays.sort(points, (a,b)-> Integer.compare(a[1], b[1]));
        int arrayCount=1;
        int arrowPos=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]> arrowPos){
                arrayCount++;
                arrowPos=points[i][1];
            }

        }
        return arrayCount;
        
    }
}