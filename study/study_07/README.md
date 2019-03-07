### SpringBoot study_07：玩转Redis配置
	Redis在这里只做单机版，暂时不做集群，这里以测试和数据库查询测试做个依托，看一下效果，其他的自行参考代码
### Redis安装及使用教程：<a href="http://www.runoob.com/redis/redis-install.html">http://www.runoob.com/redis/redis-install.html</a>
### 接口调用示例
	http://localhost:8080/dp/selectUser/33 GET
	第一次会主动查询数据库，之后在过期时间内（-1：永不过期）数据会一直存在，过期之后数据才会丢失
	SpringbootApplicationTest是测试启动，使用过后会根据不同的数据操作不同的redis db（key）
### restdoc的使用
	这里使用的是 - Swagger2
	页面接口页面：http://localhost:8080/dp/swagger-ui.html
	使用都有注释，请自行参考，详细信息请参考官网API

	Swagger注解
	swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
	
	@Api：修饰整个类，描述Controller的作用
	@ApiOperation：描述一个类的一个方法，或者说一个接口
	@ApiParam：单个参数描述
	@ApiModel：用对象来接收参数
	@ApiProperty：用对象接收参数时，描述对象的一个字段
	@ApiResponse：HTTP响应其中1个描述
	@ApiResponses：HTTP响应整体描述
	@ApiIgnore：使用该注解忽略这个API
	@ApiError ：发生错误返回的信息
	@ApiImplicitParam：一个请求参数
	@ApiImplicitParams：多个请求参数


### 注：注意新的注解的写法：@GetMapping 等同于@RequestMapping(method = RequestMethod.GET)   POST雷同
	