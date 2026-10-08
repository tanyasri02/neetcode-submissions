class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[128];
        int[] freq2 = new int[128];

        int k = s1.length();

        for(char ch : s1.toCharArray())
            freq1[ch-'A']++;

        for(int i=0;i<s2.length();i++){
            freq2[s2.charAt(i)- 'A']++;

            if(i >= k)
                freq2[s2.charAt(i-k)- 'A']--;

            if(Arrays.compare(freq1, freq2) == 0)
                return true;
        } 

        return false;
    }
}
