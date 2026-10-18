class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        if(!st.contains(endWord))
            return 0;
            
        Queue<String> pq = new LinkedList<>();

        pq.add(beginWord);
        int level = 1;

        while(!pq.isEmpty()){
            int n = pq.size();

            for(int i=0;i<n;i++){
                String curr = pq.poll();
                if(curr.equals(endWord))
                    return level;

                char[] currA = curr.toCharArray();

                for(int j=0;j<currA.length;j++){
                    char org = currA[j];

                    for(char c='a';c<='z';c++){
                        if(c == org)
                            continue;

                        currA[j] = c;
                        String nextWord = new String(currA);

                        if(st.contains(nextWord)){
                            pq.add(nextWord);
                            st.remove(nextWord);
                        }
                    }

                    currA[j] = org;
                }
            }
            level++;
        }

        return 0;
    }
}
