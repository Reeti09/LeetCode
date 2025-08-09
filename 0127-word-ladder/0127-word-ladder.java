class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> mp=new HashMap<>();
        for(String word: wordList){
            for(int i=0;i<word.length();i++){
                String genericWord=word.substring(0,i)+"*"+word.substring(i+1);
                mp.computeIfAbsent(genericWord,k->new ArrayList<>()).add(word);
            }
        }
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);  
        int level=1;
        while(!q.isEmpty()){
            int levelSize=q.size();
            for(int i=0;i<levelSize;i++){
                String currentWord=q.poll();
                if(currentWord.equals(endWord)){
                    return level;
                }
                for(int j=0;j<currentWord.length();j++){
                    String genericWord=currentWord.substring(0,j)+"*"+currentWord.substring(j+1);
                    if(mp.containsKey(genericWord)){
                        for(String neighbor: mp.get(genericWord)){
                            if(!visited.contains(neighbor)){
                                visited.add(neighbor);
                                q.add(neighbor);
                            }
                        }
                    }
                }
            }
            level++;
        } 
        return 0;
    }
}