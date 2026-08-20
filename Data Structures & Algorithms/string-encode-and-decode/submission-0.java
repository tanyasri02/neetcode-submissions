class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for(String str : strs){
            int length = str.length();
            encoded.append(str.length()).append("#").append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int i=0;
        while(str.length() > i){
            int j = i;

            while(str.charAt(j) != '#')
                j++;

            int length = Integer.parseInt(str.substring(i , j));
            String currAns = str.substring(j+1, j+length+1);

            ans.add(currAns);

            i = j+length+1;
        }

        return ans;
    }
}
