# 学习笔记
## 一维数据结构
### 基础一维数据结构
#### arrays定义以及相关特性
数组： 一块连续的内存，存储相同数据类型的元素 的线性数据结构

| operation | time complexity |
| --- | --- |
|insert | O(n) |
|search(with index）| O(1)|
|delete | O(n) |
| modify | O(1) |
注意： 这里的查是指带下标的查找，而不是查找某一个值。
#### 针对array的算法
##### 双指针
题目： sortedSquares

思路：关键点在于，正负数的平方再排序，所以一个指针指向开头（负数） 一个指针指向正数，哪个数的平方小就添加到数列。


#### Link 定义以及相关特性
链表： 在分散内存存储的，节点式的，线性数据结构

| operation | time complexity |
| --- | --- |
|insert | O(1) |
|search| O(n)|
|delete | O(1) |
| modify | O(1) |

#### skip list 定义以及相关特性
skipList 的出现是为了加速link list 的查询。因为链表除了查询速度是O(n) 其他操作速度都是 O(1)
那么跳表有事是如何做到查询加速的呢？ 升维的思想。链表的查询之所以慢就是要查所有的元素并且每次遍历都要一个一个的来
那么我们就可以将查询的步伐放大，也就是给一维链表添加索引，索引的步长由1 到 2 甚至到2的n次方。

### 高级一维数据结构
#### 栈定义以及特点
栈， 先进后出 增加删除都为O(1)
java 使用 Stack<Integer> stack = new Stack<>()
java 中常见栈的method

|method| function |
| --- | --- | 
|push | 推入栈| 
|pop | 弹出栈| 
|peek | 返回栈顶元素，并不对栈操作|
|empty | 返回boolean 查看栈是否为空| 
|search | 查找一个元素在栈中的位置| 

#### 栈 java 源码分析

#### 栈习题实战
 什么时候用栈呢： 最近相关原则。
 题目： 有效的括号问题
 
 思路： 将左边括号压入栈，如果出现右括号且右括号与栈顶元素匹配，就弹出，否则返回false
 
 题目：直方图中最小矩形面积问题
 
 思路：
#### 队列定义及特点
队列， 先进先出，增加删除都为O(1)
**method总结**
method分为两种 1. throw exception 2. return special value

function|throw exception | return special value |
| --- | --- | ---|
|插入 | add() | offer() |
|查询数据| remove()| poll() |
| 查询数据不改变queue | element()| peek()|

#### 队列的使用


#### 队列 java 源码分析
#### 双端队列
两端都可以进出的queue

#### 双端队列的使用

|HEAD |throw exception | return special value |
| --- | --- | ---| 
|插入 | addFirst() | offerFirst() |
|查询数据| removeFirst()| pollFirst() |
| 查询数据不改变queue | getFirst()| peekFist()|

add First 使用
``` java

Dequeue<String> deque = new LinkList<String>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);
String str = deque.getFirst();
System.out.println(str);
System.out.println(deque);

while(deque.size() > 0) {
    System.out.println(deque.removeFirst());
}
System.out.println(deque);
```

addLast 使用
``` java

Dequeue<String> deque = new LinkList<String>();
deque.addLast("a");
deque.addLast("b");
deque.addLast("c");
System.out.println(deque);
String str = deque.getLast();
System.out.println(str);
System.out.println(deque);

while(deque.size() > 0) {
    System.out.println(deque.removeLast());
}
System.out.println(deque);
```

#### 优先队列 定义及特点
优先队列和队列的不同在于取出数的时候，优先队列是按照优先级取出 复杂度为O(logn)

#### 优先队列 java 源码分析

## 如何查询接口信息以及如何使用
### 如何查询文档
google 关键字 data struct java version（stack java 12）
文档里面有method
### 如何查询源代码
google 关键字： source code java stack
如何下载java 源码