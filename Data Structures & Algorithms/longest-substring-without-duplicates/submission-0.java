class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int ans = 0;

        int left = 0;
        for(int right = 0;right<s.length(); right++){
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            while(freq.get(c) > 1){
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                left ++;
            }

            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
}
