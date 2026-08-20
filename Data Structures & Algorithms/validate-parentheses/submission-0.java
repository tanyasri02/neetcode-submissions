class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>(); 

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else{
                if(st.isEmpty())
                    return false;

                char curr = st.pop();

                if(ch == '}' && curr != '{')
                    return false;

                if(ch == ')' && curr != '(')
                    return false;

                if(ch == ']' && curr != '[')
                    return false;
            }
        }

        return st.isEmpty();
    }
}
