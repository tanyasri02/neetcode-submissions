class Solution {
    public int[] rightMin(int[] heights){
        int n = heights.length;
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = n;

        Stack<Integer> st = new Stack<>();

        st.push(0);

        for(int i=1;i< n;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int k = st.pop();
                arr[k] = i;
            }

            st.add(i);
        }

        return arr;
    }

    public int[] leftMin(int[] heights){
        int n = heights.length;
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = -1;

        Stack<Integer> st = new Stack<>();

        st.push(n-1);

        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int k = st.pop();
                arr[k] = i;
            }

            st.add(i);
        }

        return arr;
    }

    public int largestRectangleArea(int[] heights) {
        int[] rightMin = rightMin(heights);
        int[] leftMin = leftMin(heights);
        int ans = 0;

        for(int i=0;i<heights.length;i++){
            int width = rightMin[i] - leftMin[i] - 1;
            ans = Math.max(ans, heights[i]*width);
        }

        return ans;
    }
}
