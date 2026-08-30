class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //first ccreate a graph of this
        // [1,4][2,4][3,1][3,2]
        
        // [4,1]
        // [4,2]
        // [1,3]
        // [2,3]

        // ANS - 4    1   2   3
        // GRAPHS

        // 1 -> {3}
        // 2 -> {3}
        // 3 -> {}
        // 4 -> {1,2}

        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            int course = pre[0];
            int prereqCourse = pre[1];

            adj.get(prereqCourse).add(course);
          
        }

       //BFS
       // indegree array
       //queue which gets the elements when returning

       int[] inDegree = new int[numCourses]; 
       
        for(int i=0;i<numCourses;i++){
            List<Integer> neighbors = adj.get(i);
            for(int it: neighbors){
                inDegree[it]++;
             }
             System.out.println("indeg"+inDegree[i]);
        }

        //Queue 

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        //Q.pop()
        // 3

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int poppedEle = q.poll();
            ans.add(poppedEle);

            for(int it: adj.get(poppedEle)){
                inDegree[it]--; 

                if(inDegree[it] == 0){
                    q.add(it);
                
                }            
            }

        }

        if(ans.size() == numCourses){
            return true;
        }
        return false;
        

    }
}