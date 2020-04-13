//Given n non-negative integers a1, a2, ..., an , where each represents a point 
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis for
//ms a container, such that the container contains the most water. 
//
// Note: You may not slant the container and n is at least 2. 
//
// 
//
// 
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In thi
//s case, the max area of water (blue section) the container can contain is 49. 
//
// 
//
// Example: 
//
// 
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49 Related Topics Array Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int max_Area = 0;
        int max_i = 0;
        int max_j = 0;
        for (int i=0; i<height.length; i++) {
            for (int j=i+1; j<height.length; j++) {
                int area = (j-i) * Min(height[i], height[j]);
                if (area > max_Area) {
                    max_Area = area;
                    max_i = i;
                    max_j = j;
                }
            }
        }
        return max_Area;
        
    }
    public int Min(int a, int b) {
        if (a > b) {
            return b;
        }
        else {
            return a;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
