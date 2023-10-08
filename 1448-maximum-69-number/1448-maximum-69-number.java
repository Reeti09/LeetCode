class Solution {
    public int maximum69Number (int num) {
        String a=String.valueOf(num);
        a=a.replaceFirst("6","9");
        return Integer.parseInt(a);

    }
}