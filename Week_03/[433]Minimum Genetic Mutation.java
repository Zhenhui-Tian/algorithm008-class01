//A gene string can be represented by an 8-character long string, with choices f
//rom "A", "C", "G", "T". 
//
// Suppose we need to investigate about a mutation (mutation from "start" to "en
//d"), where ONE mutation is defined as ONE single character changed in the gene s
//tring. 
//
// For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation. 
//
// Also, there is a given gene "bank", which records all the valid gene mutation
//s. A gene must be in the bank to make it a valid gene string. 
//
// Now, given 3 things - start, end, bank, your task is to determine what is the
// minimum number of mutations needed to mutate from "start" to "end". If there is
// no such a mutation, return -1. 
//
// Note: 
//
// 
// Starting point is assumed to be valid, so it might not be included in the ban
//k. 
// If multiple mutations are needed, all mutations during in the sequence must b
//e valid. 
// You may assume start and end string is not the same. 
// 
//
// 
//
// Example 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//return: 1
// 
//
// 
//
// Example 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//return: 2
// 
//
// 
//
// Example 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//return: 3
// 
//
// 
//


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();

        Set<String> hashSet = new HashSet<String>();

        for (int i = 0; i < bank.length ; i++) {
            hashSet.add(bank[i]);
        }

        if (s.length != e.length) return -1;

        int count = 0;
        StringBuilder template = new StringBuilder(start);
        for (int i = 0; i < s.length ; i++) {
            if(s[i] != e[i]) {
                System.out.println(s[i]);
                System.out.println(e[i]);
                template.setCharAt(i, e[i]);
                System.out.println(template.toString());
                if (!hashSet.contains(template.toString())) {
                    return -123;
                } else {
                    count++;
                }
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
