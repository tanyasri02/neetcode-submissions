class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder st = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch))
                st.append(Character.toLowerCase(ch));
        }

        String one = st.toString();
        String two = st.reverse().toString();

        return one.equals(two);
    }
}
