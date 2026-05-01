class Solution {
    public boolean hasDuplicate(int[] nums) {
       
       for(int j=0;j<nums.length;j++)
       {
        for(int i=j+1;i<nums.length;i++){
            if(nums[i] == nums[j]){
            return true;
         }
       
        }
       }
    return false;
    
    }

}