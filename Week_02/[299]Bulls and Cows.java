//You are playing the following Bulls and Cows game with your friend: You write 
//down a number and ask your friend to guess what the number is. Each time your fr
//iend makes a guess, you provide a hint that indicates how many digits in said gu
//ess match your secret number exactly in both digit and position (called "bulls")
// and how many digits match the secret number but locate in the wrong position (c
//alled "cows"). Your friend will use successive guesses and hints to eventually d
//erive the secret number. 
//
// Write a function to return a hint according to the secret number and friend's
// guess, use A to indicate the bulls and B to indicate the cows. 
//
// Please note that both secret number and friend's guess may contain duplicate 
//digits. 
//
// Example 1: 
//
// 
//Input: secret = "1807", guess = "7810"
//
//Output: "1A3B"
//
//Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7. 
//
// Example 2: 
//
// 
//Input: secret = "1123", guess = "0111"
//
//Output: "1A1B"
//
//Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
// 
//
// Note: You may assume that the secret number and your friend's guess only cont
//ain digits, and their lengths are always equal. Related Topics Hash Table


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {
        char[] secret_ch = secret.toCharArray();
        char[] guess_ch = guess.toCharArray();
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret_ch.length ; i++) {
            if(secret_ch[i] == guess_ch[i] ) {
                bull ++;
                secret_ch[i] = 'a';
                guess_ch[i] = 'b';
            }
        }
        for (int i = 0; i < secret_ch.length ; i++) {
            for (int j = 0; j < guess_ch.length ; j++) {
                if(secret_ch[j] == guess_ch[i] && i != j) {
                    cow ++;
                    secret_ch[j] = 'c';
                    break;
                }
            }
        }
        return "" + bull + 'A' + cow + 'B';
    }
}
//leetcode submit region end(Prohibit modification and deletion)