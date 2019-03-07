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

### Transactional之事物介绍
	我们的项目在 study_04 的时候有使用到事物，但是没有细讲，这里我们将次仔细的讲解一下
	1.事物常见的写法分为两种一种是功能模块上面加入（一般是在Controller），第二种是服务层，单独针对每一个小功能（一般是在ServiceImpl）。
		功能模块的好处是：模块作为一个整体，一个步骤执行异常，撤销所有对数据库的操作，简单明了
		服务层模块的好处是：每一个小功能异常都可以自主撤销，避免因功能冗杂造成数据紊乱
		推荐使用第二种方式
	2.调用接口:http://localhost:8080/dp/sumValueNo  可以看到数据库中 id 为 33 的用户姓名改为 scott2
	还原数据再次调用下面的接口
	调用接口:http://localhost:8080/dp/sumValueYes 可以看到数据库中 id 为 33 的用户姓名未改变
3.<b style="color:red;">MySQL数据库的数据库引擎必须为InnoDB，否则无效，因为事物需要开启</b>
	Navicat的修改方式，表-设计表-选项-引擎-InnoDB


	Spring Transactional一直是RD的事务神器，但是如果用不好，反会伤了自己。下面总结@Transactional经常遇到的几个场景:
	
	@Transactional 加于private方法, 无效
	@Transactional 加于未加入接口的public方法, 再通过普通接口方法调用, 无效
	@Transactional 加于接口方法, 无论下面调用的是private或public方法, 都有效
	@Transactional 加于接口方法后, 被本类普通接口方法直接调用, 无效
	@Transactional 加于接口方法后, 被本类普通接口方法通过接口调用, 有效
	@Transactional 加于接口方法后, 被它类的接口方法调用, 有效
	@Transactional 加于接口方法后, 被它类的私有方法调用后, 有效
	Transactional是否生效, 仅取决于是否加载于接口方法, 并且是否通过接口方法调用(而不是本类调用)。