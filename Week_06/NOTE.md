# 学习笔记

## 动态规划

### 我们为什么要使用动态规划

当我们用递归解题时，也就是用回溯，分治等思想时，对于子问题，我们都有重复运算，于是我们进化出了一种，用数组记忆子问题的解决方案。

对于更高一级的解决办法，也就是优化我们记忆子问题的数组空间。通过，只记录上一层的状态，从而推出下一层，直到找到答案。



### 动态规划的关键点

找到状态转移公式

###  5 easy step to DP

1. define subproblem
2. guess (part of solution)
3. relate subproblem solutions
4. recurse & memorize OR build DP table bottom-up
5. solve original problem