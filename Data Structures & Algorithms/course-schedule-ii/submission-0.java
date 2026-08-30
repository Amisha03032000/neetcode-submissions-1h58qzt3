class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
       //BFS
       //queue => to keep track of the nodes
       //then we have indegree array -> which stores the incoming nodes value 

       //everytime we pop the element from the queue -> we add it to the topo list / ans list

        //first -> convert the pre to graph

        List<List<Integer>> graph = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];

            graph.get(preCourse).add(course);
        }

        //0 -> {2}
        //1 -> {2}
        //2 -> {3}
        //3 -> {0,1}
        
        //       1
        //       |
        //       
        //  0 -> 2 -> 3 

        //lets find out the degree of each node

        int[] inDegree = new int[numCourses];
        
        for( int i=0;i<numCourses; i++){
            for( int it: graph.get(i)){       //2
                inDegree[it]++;             // incresing the counter of 2 
            }
        }

        // 1 1 2 0
        // 0 1 2 3 

        // I add all the 0 degree nodes to the queue

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        // queue -> {3}
        //ans array

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int poppedEle = q.poll();
            ans.add(poppedEle);
            //check for neighbors
            for(int it : graph.get(poppedEle)){
                //reduce the inDegree
                inDegree[it]--;

                if(inDegree[it] == 0){
                    q.add(it);
                }
            }

        }

        int[] ansarr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansarr[i] = ans.get(i);
        }
        if(ans.size() == numCourses){
            return ansarr;
        }
        return new int[0];
    }
}