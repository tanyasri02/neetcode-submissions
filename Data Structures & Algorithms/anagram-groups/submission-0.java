class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        Map<String, List<String>> mp = new HashMap<>();

        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);

            String sorted = new String(ch);

            mp.putIfAbsent(sorted, new ArrayList<>());
            mp.get(sorted).add(s);
        }

        return new ArrayList<>(mp.values());
    }
}
