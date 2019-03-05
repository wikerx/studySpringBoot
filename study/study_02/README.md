### SpringBoot study_02：玩转基础配置
 - 1.基础配置properties与yml配置在本质上都是一样的，不一样的是语法规则而已，详情可以参考阿里对外文档的配置说明。
 - 2.动态绑定/读取配置文件中的元素，demo中提供两种读取方式@Value的方式和@PropertySource绑定对象方式分别在两个不同的controller中绑定
 - 3.不同模式的动态读取：
spring:
  profiles:
####  开发：dev     测试：sit     线上：online
    active: dev


### 后期会慢慢的加入数据库、redis，MyBatis、JDBCTemplate...敬请期待