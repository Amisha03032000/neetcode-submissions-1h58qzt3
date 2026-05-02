class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int[] ans= new int[k];

    
            PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
            for(int key: map.keySet()){
                q.add(key);
            }
    
        int i=0;
        while(i<k){
            ans[i]= q.poll();
            i++;
        }        
    return ans;
    }
    
    
}
