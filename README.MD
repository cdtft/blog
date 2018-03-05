# Blog 博客

----

### 关于项目

本工程基于JDK1.8进行开发,使用IDEA作为IDE,management-*使用tomcat8.0以上容器运行

### 关于lombok

本工程使用了编译时库`lombok`,通过`@Getter`,`@Setter`,`@Data`,`@Slf4j`等注解,在编译时生成对应的方法与字段.
为获得良好的开发体验,请自行寻找并下载`lombok`插件.

<b>为了项目简洁,请所有PO,RO,VO等POJO全部使用lombok来替代getter,setter</b>

### 代码规范

本工程遵循阿里编码规范参考手册 (Alibaba Java Coding Guidelines),请安装阿里近日发布的代码规范插件,并且保证自己提交的代码能通过插件检查. 
idea可以直接在插件库搜索到这个插件.

### 模块结构及包名约定

- 以cdut开头的模块为基础支持模块
- 以blog开头的模块为微服务模块，blog-manage为后台管理模块，blog-eureka-service为服务注册中心

### 配置文件约定

- 配置文件全部使用`yml`格式
- 所有自定义配置全部以`primus`开头
- 所有的自定义配置都使用`@ConfigurationProperties`做`spring-boot`原生集成
示例代码:`com.biz.primus.ms.base.config.JedisConfiguration.RedisProperties`
- ~~注意区分不可刷新配置和可刷新配置,在制定属性namespace时就考虑将两者分开~~
- 每个`spring-cloud`应用只能包含一个`bootstrap.yml`配置文件,该文件中只能写`config-server`和`application-name`相关配置
- ~~其他配置文件必须以`{applicationName}-{profile}.yml`的形式放在/config-repo目录下~~
- 本地环境的配置以`application-dev.yml`的命名放置在资源文件夹,该文件是被`.gitignore`忽略的,可以任意修改不必提交.
- 远程环境的配置以`{applicationName}-{profile}.yml`的形式放在/config-repo目录下



### PO设计原则

除非对象之间的关系是`组合关系`,否则不能使用强关联,
也就是`@OneToOne`,`@OneToMany`,`@ManyToOne`,`@ManyToMany`,`@ElementCollection`等注解.
所有强关联必须转换为相应的id引用.例如:
```java
//假设有这样的po
public class Order{
	@ManyToOne
	private User user;
	//其他属性
}
public class User{
	@OneToMany(mappedBy="user")
	private List<Order> orders;
	//其他属性
}
```
这样的代码必须修改为
```java
public class Order{
	private Long memberId;
	//其他属性
}
public class User{
	//其他属性
}
```






.