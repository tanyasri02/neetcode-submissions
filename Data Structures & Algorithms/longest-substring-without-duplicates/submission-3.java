class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int ans = 0;

        int left = 0;
        for(int right = 0;right<s.length(); right++){
            char c = s.charAt(right);
            freq[c]++;

            while(freq[c] > 1){
                char leftChar = s.charAt(left);
                freq[leftChar]--;
                left ++;
            }

            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
}

// 0(n) 
// 0(1)
