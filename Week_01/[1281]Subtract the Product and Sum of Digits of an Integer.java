//Given an integer number n, return the difference between the product of its di
//gits and the sum of its digits.
// 
// Example 1: 
//
// 
//Input: n = 234
//Output: 15 
//Explanation: 
//Product of digits = 2 * 3 * 4 = 24 
//Sum of digits = 2 + 3 + 4 = 9 
//Result = 24 - 9 = 15
// 
//
// Example 2: 
//
// 
//Input: n = 4421
//Output: 21
//Explanation: 
//Product of digits = 4 * 4 * 2 * 1 = 32 
//Sum of digits = 4 + 4 + 2 + 1 = 11 
//Result = 32 - 11 = 21
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10^5 
// 
// Related Topics Math


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subtractProductAndSum(int n) {
        int i = 1;
        int count = 0;
        int copyn = n;
        while(copyn>0) {
            copyn = copyn / 10;
            count ++;
        }
        int[] arr = new int[count];
        int j = 0;
        while(n>0) {
            arr[j] = n % 10;
            n = n / 10;
            j++;
        }
        int sum = 0;
        int mul = 1;
        for (int k=0; k<arr.length;k++) {
            sum += arr[k];
            mul *= arr[k];
        }
        return  mul-sum;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
