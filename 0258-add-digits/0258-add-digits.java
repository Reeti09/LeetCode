class Solution {
    public int addDigits(int num) {
        int sum=0,d;
        if(num<10)
        return num;
         while(num>9){
             sum=0;
             while(num!=0){
                  d=num%10;
                  sum=sum+d;
                  num=num/10;
                }
            num=sum;
            }
        
        return sum;
           
    }
}
