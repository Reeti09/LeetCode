class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int size=n*n;
        int[] mp=new int[size+1];
        for(int[] row: grid){
            for(int num: row){
                mp[num]++;
            }
        }
        int repeated=-1, missing=-1;
        for(int i=1;i<=size;i++){
            if (mp[i] == 2) repeated = i;
            if (mp[i] == 0) missing = i;
        }
        return new int[]{repeated, missing};
    }
}