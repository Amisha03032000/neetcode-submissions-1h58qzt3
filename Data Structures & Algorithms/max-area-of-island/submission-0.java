class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int n= grid.length;
        int m = grid[0].length;
       
        int maxCount =0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                 int count = dfs(i,j,grid);
                 maxCount=Math.max(count, maxCount);
                }
            }
        }
    return maxCount;
    }

    public int dfs(int i, int j, int[][] grid){

        int n= grid.length;
        int m = grid[0].length;

        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0){
           return 0;
        }

        grid[i][j] = 0; 
        
        int count = 1;
        count = count + dfs(i+1, j, grid);
        count = count + dfs(i, j+1, grid);
        count = count + dfs(i-1, j, grid);
        count = count + dfs(i, j-1, grid);


        return count;
    }
}
