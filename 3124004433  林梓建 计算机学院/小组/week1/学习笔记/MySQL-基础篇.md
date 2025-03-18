# 一、SQL

## 1.SQL通用语法

![image-20250315191708933](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315191708933.png)

## 2.SQL分类

![image-20250315191748109](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315191748109.png)

## 3.DDL

### DDL-数据库操作

![image-20250315191956166](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315191956166.png)

### DDL-表操作

#### DDL-表操作-查询

![image-20250315192137524](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315192137524.png)

#### DDL-表操作-创建

![image-20250315192255385](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315192255385.png)

#### DDL-表操作-数据类型

1.**数值**类型

![image-20250315192735652](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315192735652.png)

 

2.**字符串**类型

![image-20250315192817215](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315192817215.png)

PS：定长用char,不定长用varchar



3.**日期**类型

![image-20250315192941674](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315192941674.png)



#### DDL-表操作-修改

1.**添加字段**

![image-20250315193103762](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315193103762.png)



2.**修改数据类型**

![image-20250315193153705](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315193153705.png)



3.**修改字符名和字符类型**

![image-20250315193239442](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315193239442.png)



4.**删除字段**

![image-20250315193330850](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315193330850.png)



5.**修改表名**

![image-20250315193410876](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315193410876.png)



6.**删除表**

![image-20250315193440794](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315193440794.png)



## 4.DML

### DML-添加数据

![image-20250315194429883](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315194429883.png)

### DML-修改数据

![image-20250315202802392](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315202802392.png)

### DML-删除数据

![image-20250315202920971](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315202920971.png)

## 5.DQL

### DQL-语法

![image-20250316115126682](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316115126682.png)

### DQL-基础查询

![image-20250315211515313](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315211515313.png)

PS：查询中起别名时as关键字可以省略

### DQL-条件查询

1.**语法**

![image-20250315211832307](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315211832307.png)

2.**条件**

![image-20250315212004507](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250315212004507.png)

**重点：**占位符的使用

eg.查询身份证号最后一位是X的用户->.......where idcard like '%X'

eg.查询姓名为两个字的用户->......where name like '__'

### DQL-聚合函数

![image-20250316115637335](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316115637335.png)

PS：表名后可加where增加筛选条件

### DQL-分组查询

![image-20250316121124039](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316121124039.png)

eg.![image-20250316121217789](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316121217789.png)

### DQL-排序查询

![image-20250316122135409](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316122135409.png)

### DQL-分页查询

![image-20250316123404464](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316123404464.png)

### DQL-执行顺序

![image-20250316130205319](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316130205319.png)

## 6.DCL

### DCL-管理用户

![image-20250316131320477](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316131320477.png)

### DCL-权限限制

![image-20250316131738588](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316131738588.png)

![image-20250316131813025](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316131813025.png)

# 二、函数

## 1.字符串函数

![image-20250316135044813](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316135044813.png)

eg.

![image-20250316140155612](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316140155612.png)

![image-20250316140244677](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316140244677.png)



## 2.数值函数

![image-20250316135714223](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316135714223.png)

eg.

![image-20250316140321626](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316140321626.png)

![image-20250316140418790](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316140418790.png)



## 3.日期函数

![image-20250316140115517](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316140115517.png)

eg.

![image-20250316140456351](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316140456351.png)

![image-20250316140626084](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316140626084.png)

## 4.流程函数

![image-20250316142950573](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316142950573.png)

eg.

![image-20250316143038348](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316143038348.png)

![image-20250316143135889](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316143135889.png)

# 三、约束

## 1.概述

![image-20250316144058871](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316144058871.png)

## 2.约束演示

![image-20250316150248649](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316150248649.png)

## 3.外键约束

### 1.增加/删除

![image-20250316155322480](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316155322480.png)

### 2.删除/更新

![image-20250316155403033](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316155403033.png)

**语法：**

`ALTER TABLE 表名 ADD CONSTRAINT 外键名称 FOREIGN KEY (外键字段) REFERENCES 主表名(主表字段名) ON UPDATE 行为 ON DELETE 行为;`

# 四、多表查询

## 1.多表关系

![image-20250316185052797](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316185052797.png)

**(1)一对多**

![image-20250316185352089](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316185352089.png)

**(2)多对多**

![image-20250316185447696](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316185447696.png)

**(3)一对一**

![image-20250316185535752](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316185535752.png)

eg.

![image-20250316185639056](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316185639056.png)

## 2.多表查询-概述

![image-20250316193721229](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316193721229.png)

eg.

![image-20250316193820580](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316193820580.png)



![image-20250316193841683](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316193841683.png)

## 3.内连接

![image-20250316194921446](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316194921446.png)

eg.

### ![image-20250316195003522](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316195003522.png)

## 4.外连接

![image-20250316200738705](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316200738705.png)

eg.

![image-20250316200855645](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316200855645.png)

PS：一般使用左外连接(调换前后顺序)

## 5.自连接

![image-20250316201626883](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316201626883.png)

eg.

![image-20250316201718682](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316201718682.png)

## 6.联合查询

![image-20250316202815498](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316202815498.png)

PS：相当于把两次查询的表(去重后)上下拼接起来

## 7.子查询

### 子查询-概念

![image-20250316203151313](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316203151313.png)

### 子查询-标量子查询![image-20250316203540958](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316203540958.png)

eg.

![image-20250316203622754](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316203622754.png)



![image-20250316203652604](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316203652604.png)

### 子查询-列子查询

![image-20250316204152413](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316204152413.png)

eg.

![image-20250316204225669](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316204225669.png)

![image-20250316204251042](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316204251042.png)

![image-20250316204334720](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316204334720.png)

### 子查询-行子查询

![image-20250316205054618](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316205054618.png)

eg.

![image-20250316205212915](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316205212915.png)

### 子查询-表子查询

![image-20250316205700568](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316205700568.png)

eg.

![image-20250316205736420](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316205736420.png)

![image-20250316205809643](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316205809643.png)

# 五、事务

## 1.事务简介

![image-20250316213212001](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316213212001.png)

## 2.事务操作

****

**方法一：手动提交**

![image-20250316220016448](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316220016448.png)

**方法二：**

![image-20250316220124238](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316220124238.png)

PS：commit之前执行SQL语句类似于Git中把修改后的文件提交到暂存区

## 3.事务四大特性-ACID

![image-20250316220523660](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316220523660.png)

## 4.并发事务问题

![image-20250316221143702](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316221143702.png)

![image-20250316221257361](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316221257361.png)

![image-20250316221317769](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250316221317769.png)

## 5.事务隔离级别

![image-20250317140741759](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250317140741759.png)