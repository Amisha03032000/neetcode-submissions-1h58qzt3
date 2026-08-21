class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        int res[] = new int[n];

        // arr = [1,2,3,4]
        //pre = [1,1,2,6]
        //suff = [24,12,4,1]

        //pre*suff = ans
        pre[0]=1;
        suff[n-1]=1;
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1] * nums[i-1];
        }

        for(int j=n-2;j>=0;j--){
            suff[j] = suff[j+1] * nums[j+1];
        }

        for(int a=0;a<n;a++){
            res[a] = pre[a]*suff[a];
        }

        return res;
    }
}  
