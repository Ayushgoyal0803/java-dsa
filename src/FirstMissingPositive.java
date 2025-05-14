/*
https://leetcode.com/problems/first-missing-positive/description/
 */
public class FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            int i=0;

            while(i<n){

                if(nums[i] > 0 && nums[i] <= n && nums[nums[i] -1] != nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[temp-1];
                    nums[temp-1] = temp;
                }
                else{
                    i++;
                }
            }

            for(i=0;i<n;i++){
                if(nums[i] != i+1 ){
                    return i+1;
                }
            }

            return n+1;
        }
    }
}
