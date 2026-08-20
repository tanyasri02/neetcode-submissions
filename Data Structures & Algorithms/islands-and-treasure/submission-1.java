class Solution {

    void dfs(int[][] grid, int i, int j, int dist){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] < dist)
            return;

        grid[i][j] = dist;

        dfs(grid, i+1, j, dist+1);
        dfs(grid, i-1, j, dist+1);
        dfs(grid, i, j+1, dist+1);
        dfs(grid, i, j-1, dist+1);

    }

    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 0)
                    dfs(grid, i, j, 0);
            }
        }
    }
}
