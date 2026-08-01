class Solution {
    public void solve(char[][] board) {
        //replace all border elements with other element suppose P

        //now start dfs with P if any element that is 0 comes in dfs chnange it it to P

        //at end we change all 0 to X && p to X 

        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<m;i++){
            if(board[0][i]=='O'){
               dfs(0, i, board);
            }  
            if(board[n-1][i]== 'O'){
                dfs(n-1, i, board);
            }
        }


        for(int j=0;j<n;j++){
            if(board[j][0]=='O'){
               dfs(j, 0, board);
            }  
            if(board[j][m-1]== 'O'){
               dfs(j, m-1, board);
            }
        }


        
       
        


        
        



        
        //done with dfs

        for(int k=0;k<n;k++){
            for(int h=0;h<m;h++){
                if(board[k][h]=='O'){
                    board[k][h]='X';
                }
                if(board[k][h]=='P'){
                    board[k][h]='O';
                }
            }
        }



        
    }
    public void dfs(int a, int b, char[][] board){

        int n = board.length;
        int m = board[0].length;

        if(a<0 || b<0 || a>=n || b>=m || board[a][b]!='O'){
           return;
        }

       

        board[a][b]='P';


           dfs(a+1, b, board);
            dfs(a, b+1, board);
            dfs(a-1, b, board);
            dfs(a, b-1, board);
        
      
    }
}
