class Solution {
    public int numIslands(char[][] grid) {
        //depth first search algo
        // coz we need to connect all the 1s together and that can only be done by dfs

        int n = grid.length;
        int m= grid[0].length;

        boolean vis[][] = new boolean[n][m];
        //[ , , , ,]

        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && vis[i][j]!=true){
                    dfs(i,j, grid, vis); 
                    count++;
                }
            } 
        }

        return count;
       
    }

    public void dfs(int row, int col, char[][] grid, boolean[][] vis){

        int n = grid.length;
        int m= grid[0].length;
        if(row>=n || col>=m || row <0 || col<0 || grid[row][col] == '0' || vis[row][col]==true){
            return;
        }
       
        vis[row][col] = true;

        dfs(row+1, col, grid, vis);
        dfs(row, col+1, grid, vis);
        dfs(row-1, col, grid, vis);
        dfs(row, col-1, grid, vis);

    }

}
