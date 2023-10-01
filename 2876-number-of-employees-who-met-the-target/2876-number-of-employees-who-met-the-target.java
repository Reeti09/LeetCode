class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int l=hours.length;
        int c=0;
        for(int i=0;i<l;i++){
            if(hours[i]>=target){
                c++;
            }
        }
        return c;
    }
}