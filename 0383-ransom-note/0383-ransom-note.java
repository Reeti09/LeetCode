class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> freq=new HashMap<>();
        for(char c: magazine.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+1);

        }
        for(char c: ransomNote.toCharArray()){
            if(!freq.containsKey(c)||freq.get(c)==0){
                return false;
            }
            freq.put(c, freq.get(c)-1);
        }
        return true;

        
    }
}