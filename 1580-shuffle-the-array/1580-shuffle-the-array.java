class Solution {
    public int[] shuffle(int[] nums, int n) {
        int j=0;
        int l=2*n;
        int ar[]=new int[l];
        for(int i=0;i<l;i=i+2){
            ar[i]=nums[j];
            ar[i+1]=nums[j+n];
            j++;
        }
        return ar;
    }
}