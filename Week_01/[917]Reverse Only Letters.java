//Given a string S, return the "reversed" string where all characters that are n
//ot a letter stay in the same place, and all letters reverse their positions. 
//
// 
//
// 
// 
// 
// 
// 
// 
// 
// 
//
// 
// Example 1: 
//
// 
//Input: "ab-cd"
//Output: "dc-ba"
// 
//
// 
// Example 2: 
//
// 
//Input: "a-bC-dEf-ghIj"
//Output: "j-Ih-gfE-dCba"
// 
//
// 
// Example 3: 
//
// 
//Input: "Test1ng-Leet=code-Q!"
//Output: "Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 
// Note: 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S doesn't contain \ or " 
// 
// 
// 
// 
// Related Topics String


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String S) {
        Stack<Character> st = new Stack();
        for(char c: S.toCharArray()) {
            if (Character.isLetter(c)) {
                st.push(c);
            }
        }
        StringBuilder newS = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c)) {
                newS.append(st.pop());
            } else {
                newS.append(c);
            }
        }
        return  newS.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
