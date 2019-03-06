### SpringBoot study_05：玩转MyBatis配置
	Mybatis常用的就是mapper的xml文件和直接嵌入式的SQL（注解版），这里我们两种方式都分别写一下，
	xml方式代码量略大，但是现在的可以根据generator生成这些东西，比较灵活，
	另外一种就是嵌入式SQL的写法，非常简洁，但是我还是推荐注解版的写法，
	但是如果用MyBtis用多了，写xml的也不错，大家根据自身的情况自主选择
xml的写法命名为study_06,一样的功能，一样的数据访问

### 功能模块
	功能主要都是在IUserDao中的注解实现的代码
	服务层和控制层还是一样的，大家自行看一下，挺简单的

### 接口调用
	查询所有用户信息：http://localhost:8080/dp/selectAllUser			GET
	根据id查询用户信息：http://localhost:8080/dp/selectUserById/1		GET
	根据姓名模糊查询：http://localhost:8080/dp/selectLikeName/天		GET
	添加用户信息：http://localhost:8080/dp/addUser?age=50&name=老李头	POST
	修改用户信息：http://localhost:8080/dp/updateUser/35?age=50&name=老杨头	PUT
	删除用户信息：http://localhost:8080/dp/deleteUser/35				DELETE

### MyBatis的调用逻辑：
	1.访问方法
	2.进入服务层 - > 找到数据库连接层，接入数据 - > 返回数据