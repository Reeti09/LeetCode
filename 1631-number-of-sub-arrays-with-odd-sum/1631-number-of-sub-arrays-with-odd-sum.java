class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;  // ✅ Correct value
        int oddCount=0, evenCount=1;
        int prefixSum=0, ans=0;
        int n=arr.length;
        for(int num: arr){
            prefixSum+=num;
            if(prefixSum % 2==0){
                ans=(ans+oddCount)%mod;
                evenCount++;
            }
            else{
                ans=(ans+evenCount)%mod;
                oddCount++;
            }
        }
        return ans;
        
    }
}