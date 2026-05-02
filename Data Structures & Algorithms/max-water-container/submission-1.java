class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1 ;

        //to find max area we need to take min of two heights
        int area = 0;
        while(left < right){
            
            int minHeight = Math.min(heights[left], heights[right]);

            area = Math.max(area,minHeight * (right - left)); 
            
            if(heights[left] <= heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return area;
    }
}
