//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics Array Hash Table


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> newNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            newNums.put(nums[i], i);
        }
        int[] ans = new int[2];
        for (int i = 0; i < nums.length ; i++) {
            int toFind = target - nums[i];
            if (newNums.containsKey(toFind) && newNums.get(toFind) != i ) {
                ans[1] = i;
                ans[0] = newNums.get(toFind);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
