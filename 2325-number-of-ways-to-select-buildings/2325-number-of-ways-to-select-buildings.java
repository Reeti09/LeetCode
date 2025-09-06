class Solution {
    public long numberOfWays(String s) {
        int n=s.length();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                arr[i]=0;
            }
            else{
                arr[i]=1;
            }
        }
        long zero[]=new long[n];
        long one[]=new long[n];
        for(int i=0;i<n;i++){
            if(i==0){
                if(arr[i]==1){
                    one[i]++;
                }
                else{
                    zero[i]++;
                }
            }
            else{
                if(arr[i]==1){
                    one[i]=one[i-1]+1;
                    zero[i]=zero[i-1];
                }
                else{
                    one[i]=one[i-1];
                    zero[i]=zero[i-1]+1;
                }
            }
        }
        long zero_one[]=new long[n];
        long one_zero[]=new long[n];
        for(int i=1;i<n;i++){
            if(arr[i]==1){
                zero_one[i]=zero_one[i-1]+zero[i-1];
                one_zero[i]=one_zero[i-1];

            }
            else{
                zero_one[i]=zero_one[i-1];
                one_zero[i]=one_zero[i-1]+one[i-1];
            }
        }
        long zero_one_zero[]=new long[n];
        long one_zero_one[]=new long[n];
        for(int i=1;i<n;i++){
            if(arr[i]==1){
                one_zero_one[i]=one_zero_one[i-1]+one_zero[i-1];
                zero_one_zero[i]=zero_one_zero[i-1];

            }
            else{
                one_zero_one[i]=one_zero_one[i-1];
                zero_one_zero[i]=zero_one_zero[i-1]+zero_one[i-1];
            }
        }
        return zero_one_zero[n-1]+one_zero_one[n-1];

        
    }
}