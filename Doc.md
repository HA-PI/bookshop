# 说明

## 文件说明

- project_name  
    项目名，与 tomcat 中 webapps 中对应文件夹名一致
- tomcat_home  
    tomcat 目录位置
- sources.txt  
    compile.sh 脚本产生的临时文件，内容为 Java 源码列表
- compile.sh  
    将 web 文件夹和编译的 Java 字节码打包为 release 文件夹
- deploy.sh  
    将 release 中生产代码拷贝至 Tomcat Webapps 中
- watcher.js  
    监控 Java 源码改动、web 文件改动，同步更新执行 deploy.sh
    需要 node.js 环境执行

如上，一般后台开发的话，配置好本地 tomcat_home 和 project_name 后，开启 tomcat 服务（若需要查看控制台 Log，请阻塞执行），后台执行 watcher.js，然后进行开发即可。

- frontend  
    前端源码在这书写，全局安装 gulp，并`npm install`后，在该目录下执行`gulp watch`，即可进行前端开发，将会同步更新 web/asset 文件夹下的前端代码。  
    `gulp` 指令，将编译产生前端资源至 web/asset 目录。