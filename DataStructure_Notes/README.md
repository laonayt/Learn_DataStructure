# Learn_DataStructure

## 基本数据结构（BasicStructure）
#### 1、Array
插入一个 O(n)

#### 2、Stack、Queue
stack：数组实现，先进后出
queue：先进先出，数组实现，循环队列

#### 3、LinkList
单向链表
双向链表
虚拟头链表
单向循环链表
双向循环链表
链表是否有环

#### 4、BinarySearchTree
平衡二叉树
前序遍历
中序遍历
后续遍历

#### 5、Set、Map


线性结构，天然具有遍历性，如数组，链表

非线性结构，天然具有递归性，

## 排序（Sort）

#### 递归
```
void recursion(int n) {
    if (n <= 0) return;
    recursion(--n);
    System.out.print(n);
}
 //先压栈后出栈
```