//A valid parentheses string is either empty (""), "(" + A + ")", or A + B, wher
//e A and B are valid parentheses strings, and + represents string concatenation. 
//For example, "", "()", "(())()", and "(()(()))" are all valid parentheses string
//s. 
//
// A valid parentheses string S is primitive if it is nonempty, and there does n
//ot exist a way to split it into S = A+B, with A and B nonempty valid parentheses
// strings. 
//
// Given a valid parentheses string S, consider its primitive decomposition: S =
// P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings. 
//
// Return S after removing the outermost parentheses of every primitive string i
//n the primitive decomposition of S. 
//
// 
//
// Example 1: 
//
// 
//Input: "(()())(())"
//Output: "()()()"
//Explanation: 
//The input string is "(()())(())", with primitive decomposition "(()())" + "(()
//)".
//After removing outer parentheses of each part, this is "()()" + "()" = "()()()
//".
// 
//
// 
// Example 2: 
//
// 
//Input: "(()())(())(()(()))"
//Output: "()()()()(())"
//Explanation: 
//The input string is "(()())(())(()(()))", with primitive decomposition "(()())
//" + "(())" + "(()(()))".
//After removing outer parentheses of each part, this is "()()" + "()" + "()(())
//" = "()()()()(())".
// 
//
// 
// Example 3: 
//
// 
//Input: "()()"
//Output: ""
//Explanation: 
//The input string is "()()", with primitive decomposition "()" + "()".
//After removing outer parentheses of each part, this is "" + "" = "".
// 
//
// 
// 
// 
//
// Note: 
//
// 
// S.length <= 10000 
// S[i] is "(" or ")" 
// S is a valid parentheses string 
// 
//
// 
// 
// 
// 
// Related Topics Stack


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeOuterParentheses(String S) {
        // 关键在于 S 就是一个有效括号，也就说不用考虑不规范输入

        StringBuilder newstring = new StringBuilder();
        int level = 0;
        char[] stringAarr = S.toCharArray();
        for (char c: stringAarr) {
            // 解法的精妙之处在于这个count，‘( 代表 +1  ) 代表-1， 我们要去掉外层的括号，也就是 当count等于0 （最外层的())
            if (c == ')') level--; // -- 一定要在前面，因为）要减过后才为0，而且 ) 不能append 如果在后面 最外层的）就append 上了
            if(level >= 1) newstring.append(c);
            if (c == '(') level++;

        }
        return newstring.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
