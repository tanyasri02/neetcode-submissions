class Solution {
    private void dfs(int[][] heights, boolean[][] vis, int i, int j) {
        if(vis[i][j])
            return;

        vis[i][j] = true;


        if (i + 1 < heights.length && !vis[i + 1][j] && heights[i + 1][j] >= heights[i][j]) 
            dfs(heights, vis, i + 1, j);

        if (i - 1 >= 0 && !vis[i - 1][j] && heights[i - 1][j] >= heights[i][j])
            dfs(heights, vis, i - 1, j);

        if (j + 1 < heights[0].length && !vis[i][j + 1] && heights[i][j + 1] >= heights[i][j]) 
            dfs(heights, vis, i, j + 1);

        if (j - 1 >= 0 && !vis[i][j - 1] && heights[i][j - 1] >= heights[i][j]) 
            dfs(heights, vis, i, j - 1);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = heights.length, m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] altantic = new boolean[n][m];

        for(int i=0;i<n;i++)
            dfs(heights, pacific, i, 0);
        for(int i=0;i<m;i++)
            dfs(heights, pacific, 0, i);

        for(int i=0;i<n;i++)
            dfs(heights, altantic, i, m-1);
        for(int i=0;i<m;i++)
            dfs(heights, altantic, n-1, i);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && altantic[i][j])
                    ans.add(Arrays.asList(i, j));
            }
        }

        return ans;
    }
}
