class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int end = 0;
        int start = 0;

        int[] mp = new int[26];

        for(int i=0;i<s.length();i++){
            mp[s.charAt(i) - 'a'] = i;
        }

        for(int i=0;i<s.length();i++){
            end = Math.max(end, mp[s.charAt(i) - 'a']);

            if(i == end){
                ans.add(end-start+1);
                start = i+1;
            }
        }

        return ans;
    }
}
