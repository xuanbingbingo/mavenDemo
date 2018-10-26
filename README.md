# mavenDemo
## course是一个工具类包，被webapp项目使用
## webapp是一个使用了Maven本地仓库中course工具类的web项目，并热部署到了本地tomcat服务器上，其中含有简单的servlet和jsp页面
## myBatisDemo1是一个快速maven项目，依赖包有mybatis，mysql驱动，项目主要记录了使用mybatis管理本地mysql数据库的配置以及开发流程
## mybatispro是一个使用了maven项目，并使用mybatis进行数据库的管理，同时引入了log4j的一个后台用户管理的web项目，可发布上线（其中包含了mybatis的增删改查以及动态sql语句和多表关联查询的操作，是可以用来给之后使用mybatis的项目做常规参考的）
## spring_ioc是使用xml配置的方式进行bean的管理的一个详细配置的项目
## spring_ioc_annotation是使用注解的方式进行bean的管理的一个详细配置的项目，其中也包含了xml配置和注解的混合方式进行bean的管理
## spring_aop是使用xml配置的方式（非Aspectj的传统方式）进行目标类的代理（包含手动代理和自动代理，包含一般切面（只有通知的情况）和带有切入点的切面的代理）
## spring_aop_aspectj是使用注解和xml配置的方式进行Aspectj的开发（实际项目中会使用这种Aspectj的方式进行AOP开发）
## jdbc_template是spring框架自带的通过简化jdbc操作的一系列操作数据库的api的方法的详细描述，其中也包含了将数据封装为实体类数据
## spring_transaction是spring的事务管理（编程式事务管理（包含了手动编码和事务模版两种方式）和声名式事务管理（包含了tx拦截式和全注解两种方式））
## sm是Spring和Mybatis进行整合的一个web项目，用到了servlet和jsp进行页面显示的控制
## springMVCTest是spring mvc的入门案例
## springMVCdataBind是spring mvc中常用的几种数据绑定的方式（包含有返回实例对象的json格式的数据的方式，此方式需要引入jackson依赖）
## springMVCRestful是spring mvc中使用restful方式进行请求的解析和响应的案例
## springMVCIntercepter是spring mvc中使用拦截器来进行用户登陆拦截的配置和使用
## myspringboot是spring boot的开发流程配置
## oa是ssm整合开发的一个简易oa系统（主要有人员管理，报销单的审批等功能），是后面使用ssm架构开发项目可供参考的项目架构
