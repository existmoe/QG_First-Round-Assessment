# JDBC 

## JDBC 简介：

### JDBC概念

● **JDBC**就是使用**java**语言操作关系型数据库的**一套API**

● 全称：（Java DataBase Connectivity）Java 数据库连接

### JDBC本质

● 官方定义的一套操作所有关系型数据库的规则，即接口

● 各个数据库厂商去实现这套接口，提供数据库驱动jar包

● 我们可以使用这套接口（JDBC）编程，真正执行的代码是驱动jar包中的实现类

### JDBC好处：

● 各数据库厂商使用相同接口，Java代码不需要针对不同数据库分别开发

● 可随时替换底层数据库，访问数据库的Java代码基本不变

## JDBC快速入门

``

```
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/db1";
        String username = "root";
        String password = "52Lzj1314@";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义SQL
        String sql = "update account set money = 2000 where id = 1";

        //4.获取执行SQL的对象//Statement
        Statement stmt = conn.createStatement();

        //5.执行SQL
        int count = stmt.executeUpdate(sql);//受影响的行数

        //6.处理结果
        System.out.println(count);

        //7.释放资源
        stmt.close();
        conn.close();
    }
}
```

## JDBC-API详解

### ● DriverManager

1.注册驱动

`Class.forName("com.mysql.jdbc.Driver")`

**提示：**

● MySQL 5后的驱动包，可以**省略注册驱动的步骤**

● 自动加载jar包中META-INF/services/java.sql.Driver文件中的驱动类

2.获取连接

●  参数

​      (1) url:连接路径

``

```
语法：jdbc:mysql://ip地址(域名)：端口号/数据库名称
示例：jdbc:mysql://127.0.0.1:3306/db1
细节：
● 如果连接的是本机mysql服务器，并且mysql服务默认端口是3306，● 则url可以简写为：jdbc:mysql:///数据库名称
配置useSSL=false 参数，禁用安全连接方式，解决警告提示
```

​       (2) user:用户名

​       (3) password:密码

### ● Connection

1. 获取执行SQL的对象

   ◆ 普通执行SQL对象

   `Statement createStatement()`

​       ◆ 预编译SQL的执行SQL对象：防止SQL注入

​        `PreparedStatement PreparedStatement(sql) `

   2. 事务管理

      ◆ MySQL 事务管理

      ``

      ```
      开启事务：begin;/start transaction;
      提交事务:commit;
      回滚事务:rollback;
      
      MySQL默认自动提交事务
      ```

​       ◆ JDBC 事务管理:Connection接口定义了3个对应方法

​         ``

```
开启事务：setAutoCommit(boolean autoCommit):true为自动提交事务；false为手动提交事务，即开启事务
提交事务:commit();
回滚事务:rollback();
```

eg.

**★使用try{}catch{}代码块管理事务**

![image-20250317161038315](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250317161038315.png)

### ●Statement

![image-20250317161933082](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250317161933082.png)

### ●ResultSet

![image-20250317183101858](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250317183101858.png)

![image-20250317183235373](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250317183235373.png)

eg.

![image-20250317183315507](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250317183315507.png)

``

```
//创建集合用于存储查询结果
List<Account> list = new ArrayList<>();

//6.处理结果
while (rs.next()) {
    Account a1 = new Account();
    int id = rs.getInt("id");
    String name = rs.getString("name");
    int money = rs.getInt("money");

    a1.setId(id);
    a1.setName(name);
    a1.setMoney(money);
    //存入集合
    list.add(a1);
}

System.out.println(list);
```

### ●PreparedStatement

![image-20250317184825912](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250317184825912.png)

eg.SQL注入

`String sql = "select * from user where username = '"+name+"' and password = '"+pwd+"'"`

PS:拼接SQL语句

**阻止SQL注入**--把敏感字符进行转义

![image-20250317193807342](C:\Users\33742\AppData\Roaming\Typora\typora-user-images\image-20250317193807342.png)

eg.

``

```
//3.定义SQL
String sql = "select * from account1 where name = ? and password = ? ";

//4.获取执行SQL的对象//Statement
Statement stmt = conn.createStatement();

//获取pstmt对象
PreparedStatement pstmt = conn.prepareStatement(sql);


//设置？的值
pstmt.setString(1, name);
pstmt.setString(2, pwd);


//5.执行SQL
ResultSet rs = pstmt.executeQuery();
```