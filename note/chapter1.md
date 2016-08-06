##1基础
###1.1基础编程模型
+ 在逻辑运算符中，!具有最高优先级，之后是&&，接下来是||
+ break 立即退出循环 continue 立即开始下一轮循环
+ 数值类型默认初始值是0 布尔类型默认值为false
+ double[] a = new double[N]; double[][] a = new double[M][N];
+ 递归：第一条语句总是包含return的条件语句；总是解决一个规模更小的问题；父问题和子问题不应该有交集
+ 将一个文件重定向为标准输出 %java Average < data.txt
+ 将标准输出重定向到一个文件 %java RandomSeq 1000 100.0 200.0 > data.txt
+ 将一个程序的输出通过管道作为另一个程序的输入 %java RandomSeq 1000 100.0 200.0 | java Average

###1.2数据抽象
+ 局部变量的作用域是当前代码中它的定义之后的所有语句
+ 实例变量作为类的对象保存了数据类型的值作用域是整个类
+ 静态变量再static声明的类中出现，所有方法都可以访问静态变量，但静态变量不和任何具体的对象相关联
+ 如果出现二义性，可以使用this前缀来区别实例变量
+ Java equals:自反、对称、传递、一致、非空

###1.3背包、队列和栈
+ 背包：一种不支持从中删除元素的集合数据类型，目的是收集元素并列带遍历元素
+ 数组：顺序存储 通过索引可以直接访问任意元素 在初始化时就需要知道元素的数量
+ 链表：链式存储 使用的空间大小和元素数量成正比 通过引用方式访问任意元素
+ 链表容易实现的：表头、表尾插入结点；表头删除结点（栈：表头插入删除，队列：表头插入、表尾删除）
+ 链表不容易实现的：删除指定的结点、在指定位置结点前插入新节点。