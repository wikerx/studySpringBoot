### SpringBoot study_06：玩转MyBatis配置
	MyBatis之xml写法（使用最多的人）

### 功能模块
	注意逻辑秩序：
		mapper、mapper.xml、service、serviceImpl，配置文件，以及映射关系，namespace等等的细节都需要注意，否则很容易报错的。
	功能主要都是在IUserDao中的注解实现的代码服务层和控制层还是一样的，大家自行看一下，挺简单的

注意在 启动类中必须加入mapper的扫描  @MapperScan("com.scott.mapper")

### 接口调用
	查询所有用户信息：http://localhost:8080/dp/selectAllUser			GET
	根据id查询用户信息：http://localhost:8080/dp/selectUserById/1		GET
	根据姓名模糊查询：http://localhost:8080/dp/selectLikeName/天		GET
	添加用户信息：http://localhost:8080/dp/addUser?age=50&name=老李头	POST
	修改用户信息：http://localhost:8080/dp/updateUser/36?age=50&name=老杨头	PUT
	删除用户信息：http://localhost:8080/dp/deleteUser/36				DELETE

### MyBatis的调用逻辑：
	1.访问方法
	2.进入服务层 - > 找到mapper，映射xml（根据namespace）
	3.执行SQL - > 返回数据


### generatorConfig.xml 配置自动生成实体的配置文件
	configLocation：MyBatis配置的位置
	mapperLocations：mapper.xml的位置
	typeAliasesPackage：实体包扫描

### 主从数据源配置
	Demo地址：私有项目使用请先联系作者或者git好友
<a href="https://github.com/18772101110/pay_Summary">Mr.薛的博客</a>