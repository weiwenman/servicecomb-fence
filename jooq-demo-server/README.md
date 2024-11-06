# Jooq适配GaussDB开源验证任务

- [[任务地址](https://developer.huaweicloud.com/programs/opensource/contributing/task-detail/e8a3f3db8350453e9bd66cabb978d238)]：https://developer.huaweicloud.com/programs/opensource/contributing/task-detail/e8a3f3db8350453e9bd66cabb978d238
- [[servicecomb源码地址](https://github.com/apache/servicecomb-fence)]：https://github.com/apache/servicecomb-fence
- 任务摘要：jOOQ是一个功能强大的Java对象关系映射框架，提供类型安全的SQL构建和执行，支持多种数据库并可自动生成代码。本任务的主要目的是让Jooq支持华为云，包括ECS、CCE、GaussDB，帮助拓展华为云的影响力，也方便Jooq的用户能够轻松上云。

## 一、开发过程
### 1、jOOQ基础
- [[jooq官方地址](https://www.jooq.org)]：https://www.jooq.org
- [[jooq源码地址](https://githup.com/jOOQ/jOOQ)]：https://githup.com/jOOQ/jOOQ
- [[jooq demo](https://github.com/jOOQ/demo)]: https://github.com/jOOQ/demo

#### 1.1、OOQ-codegen-maven插件主要用于生成代码，pom plugins配置如下：
```xml
<plugin>
    <groupId>org.jooq</groupId>
    <artifactId>jooq-codegen-maven</artifactId>
    <version>${jooq.version}</version>
    <configuration>
        <onUnused>SILENT</onUnused>
        <jdbc>
            <driver>org.postgresql.Driver</driver>
            <url>jdbc:postgresql://localhost:5432/postgres</url>
            <user>gaussdb</user>
            <password>Postgres@123</password>
        </jdbc>
        <generator>
            <generate>
                <pojosAsJavaRecordClasses>true</pojosAsJavaRecordClasses>
                <pojosEqualsAndHashCode>false</pojosEqualsAndHashCode>
                <pojos>true</pojos>
                <pojosToString>false</pojosToString>
                <daos>true</daos>
            </generate>
            <target>
                <directory>src/main/java</directory>
                <packageName>org.apache.servicecomb.fence.generate</packageName>
            </target>
        </generator>
                </configuration>

    <executions>
        <execution>
            <id>generate-code</id>
            <phase>generate-sources</phase>
            <goals>
                <goal>generate</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

#### 1.2、jOOQ-demo-oss用于演示java中如何使用jooq连接数据库
```xml
<dependencies>
            <dependency>
                <groupId>org.jooq</groupId>
                <artifactId>jooq</artifactId>
                <version>3.19.14</version>
            </dependency>
            <dependency>
                <groupId>org.postgresql</groupId>
                <artifactId>postgresql</artifactId>
                <version>42.7.2</version>
            </dependency>
 </dependencies>
```
#### 1.3、jooq核心DSLContext数据库操作对象初始化如下：
```java
DataSource jdbc = new SingleConnectionDataSource(DriverManager.getConnection(
            db.getJdbcUrl(),
            db.getUsername(),
            db.getPassword()
        ));
DSLContext ctx = using(configuration = new DefaultConfiguration()
            .set(jdbc)
            .set(SQLDialect.POSTGRES)
            .set(new Settings()
                .withRenderFormatted(true)
            )
       );
```
#### 1.4、DSLContext查询数据库操作如下：
```java
    Result<Record2<String, String>> r =
                ctx.select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                   .from(ACTOR)
                   .where(ACTOR.LAST_NAME.like("A%"))
                   .orderBy(ACTOR.FIRST_NAME.asc())
                   .fetch();
```
#### 1.5、DSLContext插入数据库操作如下
```java
    int result =
            ctx.insertInto(ACTOR)
            .columns(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
            .values(firstName, lastName)
            .execute();
```

### 2、jooq-demo-server创建
#### 2.1、基于servicecomb-fence创建maven模块jooq-demo-server,pom.xml配置如下：
```xml
<project>
        <properties>
            <jooq.version>3.19.14</jooq.version>
            <postgres.version>42.7.2</postgres.version>
        </properties>
        <dependencies>
            <!-- Database access -->
            <dependency>
                <groupId>org.postgresql</groupId>
                <artifactId>postgresql</artifactId>
                <version>${postgres.version}</version>
            </dependency>
            <dependency>
                <groupId>org.jooq</groupId>
                <artifactId>jooq</artifactId>
                <version>${jooq.version}</version>
            </dependency>
        </dependencies>
</project>
```
#### 2.2、application.yml GaussDB配置如下：
```yaml
    servicecomb:
      jooq:
        sql-dialect: postgres
        url: ${DB_URL:jdbc:postgresql://localhost:5432/postgres}
        username: ${DB_USERNAME:gaussdb}
        password: ${DB_PASSWORD:Postgres@123}
        driver-class-name: ${DB_DRIVER:org.postgresql.Driver}
```
#### 2.3、DSLContext Bean初始化如下
```java
    @Component
    @ConfigurationProperties(prefix = "servicecomb.jooq")
    public class DataSourceConfig {
        private DSLContext ctx;
        private Connection conn;
        private String url;
        private String username;
        private String password;
        private String driverClassName;
        @Bean
        public DSLContext dslContext() throws SQLException {
            if (conn == null || ctx == null) {
                conn = DriverManager.getConnection(url, username, password);
                DataSource jdbc = new SingleConnectionDataSource(conn);
                Configuration configuration = new DefaultConfiguration();
                configuration.set(jdbc).set(SQLDialect.POSTGRES)
                        .set(new Settings().withRenderFormatted(true));
                ctx = using(configuration);
            }
            return ctx;
        }
    }
```
#### 2.4、创建演示用的REST接口ActorEndpoint.java，演示增删改查等功能
1) 在apis模块下创建jooq-demo-api模块
2) 在jooq-demo-server模块中实现api
3) 在edge-server模块application.yml增加路由配置如下：
    ```yaml
      http:
        dispatcher:
          edge:
            ## 后端服务
            url:
              enabled: true
              pattern: "/api/(.*)"
              mappings:
                jooq-demo-server:
                  prefixSegmentCount: 2
                  path: "/api/jooq/.*"
    ```
4) 在admin-website中修改operation.html文件，增加操作入口

## 二、项目部署
本项目基于华为云CCE云容器和CodeArts持续集成平台搭建测试环境
### 1、创建dockerfile文件
基于openjdk:17-alpine构建镜像
```dockerfile
FROM openjdk:17-alpine
LABEL authors="wmwei"
RUN mkdir -p /opt
COPY target/jooq-demo-server-0.0.1-SNAPSHOT.jar /opt
WORKDIR /opt
RUN mv jooq-demo-server-0.0.1-SNAPSHOT.jar jooq-demo-server.jar
EXPOSE 9098
ENTRYPOINT ["java", "-jar","jooq-demo-server.jar"]
```
### 2、创建jooq demo kubernetes deployment文件
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: jooq-demo
  labels:
    app: jooq-demo-deploy
spec:
  replicas: 1
  selector:
    matchLabels:
      app: jooq-demo-pods
  template:
    metadata:
      name: jooq-demo
      labels:
        app: jooq-demo-pods
    spec:
      containers:
        - name: jooq-demo-container
          image: swr.cn-north-4.myhuaweicloud.com/wmwei/jooq-demo-server:0.0.1
          imagePullPolicy: IfNotPresent
          ports:
            - containerPort: 9092
              protocol: TCP
          resources:
            requests:
              memory: "256Mi"
              cpu: "250m"
            limits:
              memory: "256Mi"
              cpu: "250m"
      imagePullSecrets:
        - name: default-secret
      restartPolicy: Always
```
### 3、创建jooq demo kubernetes service文件
```yaml
apiVersion: v1
kind: Service
metadata:
  name: jooq-demo
spec:
  selector:
    app: jooq-demo-pods
  ports:
    - protocol: TCP
      port: 9098
      targetPort: 9098
  type: NodePort
```
### 4、CodeArts平台创建项目
1) 代码托管
   导入gitcode servicecomb-fence代码
2) 创建编译构建任务
   任务一、上传kubernetes yaml文件至华为云OBS对象存储服务
   任务二、上传镜像资源到SWR华为云容器镜像服务
3) 创建部署任务
   任务一、部署基础服务如：mysql、opengauss、zookeeper
   任务二、部署servicecomb-fence微服务和jooq-demo-server服务
4) 创建流水线
   流水线的主要作用是自动执行计划任务，可以定制执行顺序，由于服务之间有依赖关系，要先构建生成代码镜像，接着部署基础服务，最后部署微服务

## 四、关键验收交付件
- [[demo地址](https://github.com/weiwenman/servicecomb-fence)]：https://github.com/weiwenman/servicecomb-fence
- [博客地址](https://bbs.huaweicloud.com/blogs/438885)：https://bbs.huaweicloud.com/blogs/438885
- DEMO部署验证结果截图：
- DEMO运行环境和资源规格清单：

| 产品名称         | 产品类型 | 数据库引擎版本  | 内核引擎版本  | 实例类型 | 部署形态 | 备注 |
|--------------|------|----------|---------|------|------|----|
| 云数据库 GaussDB | 基础版  | V2.0-8.* | 505.1.* | 集中式  | 1主2备 |    |

| 产品名称      | 集群类型            | 集群版本  | 集群规模 | 备注 |
|-----------|-----------------|-------|------|----|
| 云容器引擎 CCE | CCE Standard 集群 | V1.29 | 50   |    |