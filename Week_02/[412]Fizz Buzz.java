//Write a program that outputs the string representation of numbers from 1 to n.
// 
//
// But for multiples of three it should output “Fizz” instead of the number and 
//for the multiples of five output “Buzz”. For numbers which are multiples of both
// three and five output “FizzBuzz”. 
//
// Example:
// 
//n = 15,
//
//Return:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz(int n) {
        // 优化空间 如果 有一大堆 3,5 什么的 怎么写更优雅，利用hashmap
        HashMap<Integer, String> storeKey = new HashMap<Integer, String>(){
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };
        List result = new ArrayList<String>();
        // insert key:index number value: each key conresponding string
        for (int i = 1; i <= n ; i++) {
            String str = "";
            for(int k: storeKey.keySet()) {
                if (i % k == 0) {
                    str += storeKey.get(k);
                }
            }
            if (str =="") {
                str += Integer.toString(i);
            }
            result.add(str);
        }
        return  result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
