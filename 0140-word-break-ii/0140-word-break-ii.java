class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> hm=new HashMap<>();
        HashSet<String> hs=new HashSet<>(wordDict);
        return wordBreak(s,0,hs,hm);


    }
    private List<String> wordBreak(String s, int start, HashSet<String> hs, HashMap<Integer, List<String>> hm){
        if(hm.containsKey(start)){
            return hm.get(start);
        }
        List<String> valis=new ArrayList<>();

        if(start==s.length()){
            valis.add("");
        }
        for(int end=start+1;end<=s.length();end++){
            String prefix=s.substring(start, end);
            if(hs.contains(prefix)){
                List<String> suffixes=wordBreak(s,end,hs, hm);
                for(String suffix: suffixes){
                    valis.add(prefix+(suffix.equals("")?"":" ")+suffix);
                }
            }
        }
        hm.put(start, valis);
        return valis;

    }
}