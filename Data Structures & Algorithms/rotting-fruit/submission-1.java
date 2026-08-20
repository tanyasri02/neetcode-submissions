class Solution {
    void dfs(int[][] grid, int i, int j, int dist){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return;

        if (grid[i][j] == 2 && dist > 2)
            return;

        if(grid[i][j] > 2 && grid[i][j] < dist)
            return;

        grid[i][j] = dist;

        dfs(grid, i+1, j, dist+1);
        dfs(grid, i-1, j, dist+1);
        dfs(grid, i, j+1, dist+1);
        dfs(grid, i, j-1, dist+1);

    }
    public int orangesRotting(int[][] grid) {
        int ans = 2;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2)
                    dfs(grid, i, j, 2);
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1)
                    return -1;

                ans = Math.max(ans, grid[i][j]);    
            }
        }


        return ans-2;

    }
}
