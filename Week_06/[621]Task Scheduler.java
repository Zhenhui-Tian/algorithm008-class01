//Given a char array representing tasks CPU need to do. It contains capital lett
//ers A to Z where different letters represent different tasks. Tasks could be don
//e without original order. Each task could be done in one interval. For each inte
//rval, CPU could finish one task or just be idle. 
//
// However, there is a non-negative cooling interval n that means between two sa
//me tasks, there must be at least n intervals that CPU are doing different tasks 
//or just be idle. 
//
// You need to return the least number of intervals the CPU will take to finish 
//all the given tasks. 
//
// 
//
// Example: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
// 
//
// 
// Constraints: 
//
// 
// The number of tasks is in the range [1, 10000]. 
// The integer n is in the range [0, 100]. 
// 
// Related Topics Array Greedy Queue


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks) {
            map[c - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for(int f: map) {
            if(f > 0) {
                queue.add(f);
            }
        }

        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) { // a time slot
                if(!queue.isEmpty()){
                    if (queue.peek() > 1) {
                        temp.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0) {
                    break;
                }
                i++;
            }
            for (int l: temp) {
                queue.add(l);
            }
        }
        return time;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
