class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;

        int sum = 0;
        int min = Integer.MAX_VALUE;

        while(j < nums.length){
            if(sum < target){
                sum += nums[j];
                j++;
            }
            else{
                min = Math.min(min, j-i);
                sum -= nums[i];
                i++;
            }
        }

        while(i < nums.length && sum >= target){
            min = Math.min(min, j-i);
            sum -= nums[i];
            i++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}