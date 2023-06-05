# JAVA CLI DEMO
使用java实现cli命令工具
## USING

将项目进行编译打包，

```shell
mvn package
```

然后来到jar包所在目录

```shell
java -jar clidemo.jar <args>
```

例如：查询版本信息

```shell
java -jar clidemo.jar -version
```

也可以为了方便，自行编写windows环境下的bat脚本
