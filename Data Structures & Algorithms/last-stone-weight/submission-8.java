class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> b-a);
    
        for(int i=0;i<stones.length;i++){
            q.offer(stones[i]);
        }

        while(q.size()>1){

           
            int firstHeavy = q.poll();  //6
            int secondHeavy = q.poll();  //4
            int newweight = 0;

            if(firstHeavy >= secondHeavy){
                newweight = firstHeavy-secondHeavy;
                q.offer(newweight);
            }else{
                newweight = 0;
            }

            if(q.size()==1){
                return q.poll();
            }
        }
    return q.poll();
    }
}
