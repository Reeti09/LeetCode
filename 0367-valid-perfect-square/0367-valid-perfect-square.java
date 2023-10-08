class Solution {
    public boolean isPerfectSquare(int num) {
        double n = Math.sqrt(num);
        int z = (int) n;
        int x = z*z;
        if(x==num)
        {
            return true;
        }
        return false;
        
    }
}