class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        
        for (int num = low; num <= high; num++) {
            String str = String.valueOf(num);
            int len = str.length();
            
            if (len % 2 == 0) { // Only even-length numbers
                int mid = len / 2;
                int sumLeft = 0, sumRight = 0;
                
                for (int i = 0; i < mid; i++) {
                    sumLeft += str.charAt(i) - '0';
                    sumRight += str.charAt(i + mid) - '0';
                }
                
                if (sumLeft == sumRight) {
                    count++;
                }
            }
        }
        return count;
    }
}
