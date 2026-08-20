class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<int[]> helper = new ArrayList<>();

        for(int i=0;i<position.length;i++){
            helper.add(new int[]{position[i], speed[i]});
        }

        helper.sort((a,b) -> Integer.compare(b[0], a[0]));

        Stack<Double>st = new Stack<>();

        for(int [] help : helper){

            Double dis = (double) (target - help[0]) / help[1];
            st.push(dis);

            if(st.size() >= 2 && st.peek() <= st.get(st.size() - 2))
                st.pop();
        }

        return st.size();
    }
}
