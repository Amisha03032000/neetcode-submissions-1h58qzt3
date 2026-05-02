class Solution {
    public int maxProfit(int[] prices) {
    int left = 0;
    int right = 1;
    int profit =0;
    while(right < prices.length){
        profit = Math.max(profit, prices[right] - prices[left]);

        if(prices[right] < prices[left]){
            left = right;
            right++;
        }else{
            right++;
        }
    }
    return profit;
    
    }
    //     //brute force
    //     int profit = 0;
    //     for(int i=0;i<prices.length;i++){
    //         for(int j=i+1; j<prices.length; j++){
    //             profit = Math.max(profit, prices[j] - prices[i]);
    //         }   
    //     }
    // return profit;
    // }
}
