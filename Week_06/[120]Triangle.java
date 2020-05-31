//Given a triangle, find the minimum path sum from top to bottom. Each step you 
//may move to adjacent numbers on the row below. 
//
// For example, given the following triangle 
//
// 
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
//
// Note: 
//
// Bonus point if you are able to do this using only O(n) extra space, where n i
//s the total number of rows in the triangle. 
// Related Topics Array Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int row = triangle.size();
        int column = triangle.get(row - 1).size();

        int[][] dp = new int[row][column];

        dp[0][0] = triangle.get(0).get(0);

        int res = Integer.MAX_VALUE;

        for (int i = 1; i < row ; i++) {
            for (int j = 0; j <= i ; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if(j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j-1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        for (int i = 0; i < column; i++) {
            res = Math.min(res, dp[row - 1][i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
