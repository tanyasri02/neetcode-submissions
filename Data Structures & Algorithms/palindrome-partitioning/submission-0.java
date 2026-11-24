class Solution {
    List<List<String>> ans = new ArrayList<>();
    public boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    public void helper(String s, int index, List<String> curr){
        if(s.length() == index){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s, index, i)) {
                curr.add(s.substring(index, i+1));
                helper(s, i+1, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        helper(s, 0, new ArrayList<>());
        return ans;
    }
}
