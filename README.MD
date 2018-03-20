# Blog 博客

----

### 关于项目

本工程基于JDK1.8进行开发,使用IDEA作为IDE,采用SpringCloud构架再起项目前先启动BlogEurekaService注册中心

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
- 以业务模块来区别包例如：com.cdut.blog.`manage`.vo为manage模块vo对象包, 
com.cdut.blog.`article`.vo文章模块vo对象包
### 配置文件约定

- 配置文件全部使用`yml`格式 


### PO设计原则

除非对象之间的关系是`组合关系`,否则不能使用强关联,
也就是`@OneToOne`,`@OneToMany`,`@ManyToOne`,`@ManyToMany`,`@ElementCollection`等注解.
所有强关联必须转换为相应的id引用.例如:
```java
//假设有这样的po
public class Article {
    
	@ManyToOne
	private User user;
	//其他属性
}
public class User{
    
	@OneToMany(mappedBy="user")
	private List<Article> articleList;
	//其他属性
}
```
这样的代码必须修改为
```java
public class Article {
	
    private Long userId;
	//其他属性
}
public class User {
    
    private Long id;
	//其他属性
}
```
### 模块设计概要
#### 1.article
##### 1.1表设计
 | 字段名称 | 数据类型 | 长度 | 描述 |
 | ---- | --- | --- | --- |
 | id | bigint | 8 | 主键 |
 



