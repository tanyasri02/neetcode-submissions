class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        for(String word : words){
            for(char ch : word.toCharArray()){
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];

            int j = 0;

            while(j < word1.length() && j < word2.length() && word1.charAt(j) == word2.charAt(j))
                j++;

            if(j == word1.length() || j == word2.length()){
                if(word1.length() > word2.length())
                    return "";

                continue;
            }

            char from = word1.charAt(j);
            char to = word2.charAt(j);

            if(!graph.get(from).contains(to)){
                graph.get(from).add(to);
                indegree.put(to, indegree.get(to) + 1);
            }
        }

        Queue<Character> q = new LinkedList<>();

        for(char ch: indegree.keySet()){
            if(indegree.get(ch) == 0)
                q.add(ch);
        }

        StringBuilder ans = new StringBuilder();

        while(!q.isEmpty()){
            char curr = q.poll();
            ans.append(curr);

            for(char next : graph.get(curr)){
                indegree.put(next, indegree.get(next) - 1);

                if(indegree.get(next) == 0)
                    q.add(next);
            }
        }

        if(ans.length() != indegree.size())
            return "";

        return ans.toString();
    }
}
