class Solution {
    public int maximum69Number(int num) {
        // Convert the integer num to a String
        String numberAsString = String.valueOf(num);

        // Replace the first occurrence of the character '6' with '9' in the string
        String modifiedNumber = numberAsString.replaceFirst("6", "9");

        // Convert the modified string back to an integer and return it
        return Integer.valueOf(modifiedNumber);
    }
}