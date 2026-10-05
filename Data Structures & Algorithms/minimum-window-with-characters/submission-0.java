class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] freq = new int[128];

        for(char ch : t.toCharArray())
            freq[ch]++;

        int ws = 0;
        int cnt = 0;
        String ans = "";

        for(int we=0;we<n;we++){
            freq[s.charAt(we)]--;

            if(freq[s.charAt(we)] >= 0)
                cnt++;

            while(cnt == m){
                if(ans.length() == 0 || ans.length() > we-ws+1)
                    ans = s.substring(ws, we+1);

                // shrink
                freq[s.charAt(ws)]++;
                if(freq[s.charAt(ws)] > 0)
                    cnt--;

                ws++;
            }
        }

        return ans;
    }
}
