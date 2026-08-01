class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
    
        int n= grid.length;
        int m= grid[0].length;
       
      
        Queue<Pair> q = new LinkedList<>();

        int min =0;
        int freshCount=0;

        //bfs
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }else if( grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        while(!q.isEmpty()){

            int size = q.size();
            boolean converted = false;

            for(int i =0;i<size;i++){
                Pair poppedElement = q.poll(); //2,2
                int r = poppedElement.first; //2 
                int c = poppedElement.second; //2
               
                
                int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

                for(int[] dir : dirs){
                    int nrow = r + dir[0]; //(1,2)
                    int crow = c + dir[1]; //(2,1)

                    if(nrow<n && crow<m && nrow>=0 && crow>=0 && grid[nrow][crow]==1){
                        q.add(new Pair(nrow, crow));
                        grid[nrow][crow] = 2;  //make it rotten
                        converted=true;
                        freshCount--; 
                    }
            
                }
            }

            if(converted == true){
                min++;
            }
        }

        if(freshCount!=0){
            return -1;
        }
        return min;
    }
    
}
