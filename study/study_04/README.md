### SpringBoot study_04：玩转JSP配置
	可以在创建项目的时候勾选 web 和jpa选项，注意最好不要使用默认的mysql，版本不匹配。
	jpa在配置之后会生成一个表 hibernate_sequence，不能删除，删除会报错的哟。
使用JPA的时候不用自己建表了，把表的结构设计好，启动项目，会自己在数据库的位置建立对应的表，@Table 中的name为表名，@Column 中的name为字段名称

### 接口调用（请保证数据库中至少有一条数据）
    查询所有用户信息：http://localhost:8080/dp/selectAllUsers     GET
	根据id查询用户信息：http://localhost:8080/dp/selectByUid/1	  GET
	添加用户信息：http://localhost:8080/dp/addUser?name=scott&age=25 POST
	修改用户信息：http://localhost:8080/dp/updateUser/2?name=scott&age=26 PUT
	删除用户信息：http://localhost:8080/dp/deleteUser/3           DELETE
	分页查询：http://localhost:8080/dp/pageUsers?pageOffset=0&pageSize=20 GET

	SQL语句版：
	修改用户名称：http://localhost:8080/dp/modifyUpdateUser/4?name=test   PUT
	根据id删除用户信息:http://localhost:8080/dp/deleteByUserId/34         DELETE
	根据姓名模糊查询:http://localhost:8080/dp/findByNameLike?name=%E5%A4%A9 GTE
	
注意：删除的时候强制SQL必须加入@Modifying 和事物注解 @Transactional   查询是需要 @Query就好了，修改 需要@Modifying


	jpa的写法在SQL层面还有很多，如果觉得不够用的话可以去百度下其他很多的数据写法以及安全验证，这里就不再阐述了
