class Solution {
    public boolean isPalindrome(String s){
        int n = s.length();
        int left = 0, right = n-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        //char[] st = s.toCharArray();
        if(s.length() == 1)
            return s;

        int count = 0;
        String ans = "";

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if (isPalindrome(s.substring(i, j+1))){
                    if(count <= j-i+1){
                        count = j-i+1;
                        ans = s.substring(i, j+1);
                    }
                }
            }
        }
        return ans;
    }
}
