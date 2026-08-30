class Solution {
    public int countComponents(int n, int[][] edges) {

        // to a graph
        int a = edges.length;
        int m = edges[0].length;

        int count =0;

        List<List<Integer>> adj = new ArrayList<>();

        //init all to the empty array
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //visited array to store all the visited nodes

        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            if(vis[i]!=true){
                dfs(i, vis, adj);
                count++;
            }
        }
        
    return count;
        

    }
    public void dfs(int i, boolean[] vis, List<List<Integer>> adj){
        vis[i] = true;
        
        //we need to find out adjencet and then go in depth
        for(int it: adj.get(i)){
            if(vis[it]!=true){
                dfs(it, vis, adj);
            }
        }

    }
}
