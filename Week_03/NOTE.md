# 学习笔记
## 知识点
### 递归

#### 递归与盗梦空间的联系
主角相当于函数参数（可以带着上一层层的信息，进入下一层）

每一层之间相互独立（也就是说不受其他层的影响）

递归有最底层
#### 递归为什么叫递归
递： 去。 一层一层的去最底层拿答案
归： 回来。 一层一层的从底层拿到答案回来

####  如何解递归的题 
1. 寻找相同子问题
2. 寻找递归终止条件

#### 如何检查递归的终止条件
从最小的值，带入递归公式，看能不能算出来

#### 代码模板 
```java
public void recursiop(int level, int[] args) {
    // recursion terminator
    if ( level > maxLevel) { return;}
    // process logic in current level
    process(level, data);
    // drill down 进入下一层
    recursion(level + 1, int[] new args);
    // clear some logic in current level
}
```




#### 解释一下为什么递归会发生栈溢出
对于每个程序的执行，每当执行一个函数会调用一个系统栈保存临时变量

系统栈的大小一般由JVM自动设定

当递归需要保存的临时变量大于系统设定的栈就会栈溢出
#### 递归的缺陷
栈溢出
重复计算
空间复杂度高
函数调用耗时多
#### 如何调试规模比较大，深度深的递归
打印日志， 结合条件断点进行调试

#### 什么是分治的思想
就是递归，有不止一个子问题。 本质就是找重复问题

与递归的区别，多一步：在drill down 过后要将子问题的结果合并

分治是一种解决问题的思路，递归是一种编程技巧

## 刷题
### 70. 爬楼梯
**思路1** ： 递归： 写出递归公式： 假设我在n层，要到我这层，有两条路，
 1. 从 f(n-1) 一步走过来， 
 2. 从 f(n-2) 两步走过来
 
 **为什么不考虑一种情况， n-2 走两个一步走过来?**
 
 注意题目要求，每次可以爬一个楼梯，或者两个楼梯， 爬两次一个楼梯是两次的情况。 所以
 严格的来讲写递归公式的时候是说， 假设我在n层， 通过一次来到n层有几条路，两条 f（n-1） 
 f(n-2) 

f(n) = f(n-1) + f(n-2) ; 最后走一步，或者走两步

写出递归终止条件

f(1) = 1, f(2) = 2. 
**递归的副作用** 时间耗费大， 最多 n = 40。
**改进**： 将递归改为循环：
自己写循环的时候思路： 
1。 从开始每层一步步往上推
2. 算第三阶，= 第一阶+第二阶， 知道第n 阶 = n - 1 阶 + n -2阶

### 22 括号生成
**思路1**： 1. 生成所有括号的情况
```java
class Solution {
    public List<String> generateParenthesis(int n) {
        /*
         流水"树"主管下达命令，我们要生产一串括号字符串.(用一个东西，装最终结果， 一个东西装过程结果)
         每个工人的任务：
             判断任务有没有完成（terminator）(需要两个最重要的条件（参数），知道自己是第几个，知道最多要几个）
             往主管给的模板里面添加一个) 或者 (, （process current logic)
              然后传给下一个工人 (drill in)(不同的情况，所以一般是多个工人）
         */
        List<String> res = new ArrayList<>();
        _generate (0, n,"", res); // n 用于判断任务有没有完成， res 用于装最终结果， s用于装过程结果
        return res;
    }

    private void _generate(int current_level, int max, String s, List<String> res) {
        // terminator 判断是否完成
        if (current_level > max) {
            res.add(s);
            return ;
        }

        // current logic 当前工人所有的做法， 加上一个左括号，或者一个右括号
        String s1 = s + '(';
        String s2 = s + ')';

        // drill in 将当前的工作传给下一个。
        _generate(current_level + 1, max, s1, res);
        _generate(current_level + 1, max, s2, res);

        // restore current status 存储当前操作

    }

}
```

然后 判断生成的括号是不是合法的 

1. 在结束后 判断s是不是合法string。循环整个string if '(' flag++ if ')' flag-- flag must >= 0 否则不合法。 时间复杂度太高 在递归上面还要乘以一个O(n)

2. 在生成的时候，如果不合法就不生成了。如果生成左括号，左括号数量必须小于n，如果生成右括号 左括号数量必须大于右括号，

实现2。 代码思考，我们要判断左右括号数量，所以左右括号数量必须作为递归参数传入。所以有
```java
class Solution {
    public List<String> generateParenthesis(int n) {
        /*
         流水"树"主管下达命令，我们要生产一串括号字符串.(用一个东西，装最终结果， 一个东西装过程结果)
         每个工人的任务：
             判断任务有没有完成（terminator）(需要两个最重要的条件（参数），知道自己是第几个，知道最多要几个）
             往主管给的模板里面添加一个) 或者 (, （process current logic)
              然后传给下一个工人 (drill in)(不同的情况，所以一般是多个工人）
         */
        List<String> res = new ArrayList<>();
        _generate (0,0, n,"", res); // n 用于判断任务有没有完成， res 用于装最终结果， s用于装过程结果
        return res;
    }

    private void _generate( int left, int right, int max, String s, List<String> res) {
        // terminator 判断是否完成
        if (left == max && right == max) {
            res.add(s);
            return ;
        }

        // current logic 当前工人所有的做法， 加上一个左括号，或者一个右括号 在判断语句中判断当前工人的做法是否该进行

        // drill in 将当前的工作传给下一个。
        if (left < max) {
//            left ++; 不能加在这里，因为left++ 应该是传给下一层的，这一层不改，
//            不然会影响right<left  这个判断
            String s1 = s + '(';
            _generate( left+1, right, max, s1, res); // 很奇怪的错误 如果把left + 1 改为left ++ 就会出现 Compile Error: Time Limit Ecceed
        }
        if (right < left) {
//            right ++;
            String s2 = s + ')';
            _generate( left, right+1, max, s2, res);
        }

        // restore current status 存储当前操作

    }

}
```
**总结** ：递归题目一般都是要生成一串东西，然后生成当前状态的东西受前面状态的影响。
### 验证有效二叉树
**注意** 二叉树中不能只验证left < root < right, 左子树中的所有值 < root < 右子树的所有值
### 415 字符串相加
**思路**
 
我的博客: https://www.infoq.cn/profile/1762765/publish


