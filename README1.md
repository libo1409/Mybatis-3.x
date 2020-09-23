## ExercisePrescription 
- ExercisePrescription是基于`springboot+shiro+jwt`的真正`restful API`资源无状态认证**运动处方项目的服务端**
- 区别于一般,提供页面可配置式的,动态的 `restful api` 安全管理支持    

## 使用和一些约定   
- 使用此项目在后端开发好```api```后,需要在前端页面 资源配置->API管理 新增基于```ant```匹配风格的```api```(约定没有配置的api没有保护)
- ```eg:``` 获取角色关联的对应用户列表 ```rest-url```为 ```/role/user/{roleId}/{currentPage}/{pageSize}```访问方式为```GET```, 您需要在页面新增```api:``` ```/role/user/*/*/*``` ```GET```方式
- 自定义```url```匹配链约定为 ```url=``` ```url+"=="+httpMethod```
- 页面添加了```api```后,您需要在 资源配置->角色管理 配置您想要授权角色的API,菜单,关联用户等资源(约定授权给```auth_anon```角色的```api```可以被所有人访问,注意没有授权给任何角色的api是可以被任何人访问的)  

## 前端ExercisePrescription-client  
基于`angular8 + typeScript + rxjs + bootstrap + adminLTE`

#### 持续集成  

流程长这样~：    

![image2](/image/image2.PNG)    

增加kubernetes支持:  
bootshiro.yaml

详细实现技术见另一篇:  [docker学习](https://segmentfault.com/a/1190000013088818)  

## 部署  
1.IDE启动调试  
- fork 项目到自己的仓库
- clone 项目到本地 git clone https://github.com/your Name/ExercisePrescription.git
- 用idea导入
- 更改开发环境mysql数据库和redis地址(前提安装数据库并导入exercise.sql创建数据库Exercise)
- 运行`ExercisePrescription-rest`模块
- ExercisePrescription就可以提供api了 http://localhost:8082
- 用户名：admin，密码：admin。（其它用户都可以登录，用户名同密码，如user/user）
- 可以使用swagger、postman等进行api调试

2.docker本地启动  
- fork 项目到自己的仓库  
- clone 项目到本地 git clone https://github.com/your Name/ExercisePrescription.git
- 更改生产环境mysql数据库和redis地址(前提安装数据库并导入exercise.sql创建数据库Exercise)
- 前提已经存在maven环境,docker环境([docker常用看这里](https://segmentfault.com/a/1190000013088818))
- mvn clean install -Dmaven.test.skip=true打出jar包
- 进入ExercisePrescription-rest模块 `docker build -t exercise-prescription:1.0 .` 
- `docker images`看是否生成镜像成功
- 运行 `docker run -d -p 8082:8082 --name exerciseServer exercise-prescription:1.0`
- `docker ps -a` 就可以看见exerciseServer了
- ExercisePrescription就可以提供api了 http://localhost:8082

3.jenkins+docker持续集成持续部署CICD  

- fork 项目到自己的仓库(欢迎star^.^)  
- clone 项目到本地 git clone https://gitee.com/yourName/bootshiro.git
- 更改生产和开发环境mysql数据库和redis地址(前提安装数据库并导入usthe.sql创建数据库usthe)
- 搭建CICD环境有点繁琐，[看这里最下面](https://segmentfault.com/a/1190000013088818)
- 参照搭建完成后,bootshiro对应的jenkins下运行shell:
````
#!/bin/bash

#build in jenkins sh

#docker docker hub仓库地址,之后把生成的镜像上传到  registry or docker hub
REGISTRY_URL=127.0.0.1:5000
#docker login --username tomsun28 --password xxxx

#根据时间生成版本号
TAG=$REGISTRY_URL/$JOB_NAME:`date +%y%m%d-%H-%M`

#使用maven 镜像进行编译 打包出 jar 文件
docker run --rm --name mvn -v /opt/dockerWorkspace/maven:/root/.m2 \
-v /opt/dockerWorkspace/jenkins_home/workspace/$JOB_NAME:/usr/src/mvn -w /usr/src/mvn/ \
tomsun28/maven:1.0 mvn clean install -Dmaven.test.skip=true

#使用放在项目下面的Dockerfile打包生成镜像
docker build -t $TAG $WORKSPACE/.

docker push $TAG
docker rmi $TAG

#判断之前运行的容器是否还在，在就删除
if docker ps -a | grep -i $JOB_NAME;then
docker rm -f $JOB_NAME
fi

#用最新版本的镜像运行容器

docker run -d -p 8085:8080 --name $JOB_NAME -v /opt/dockerWorkspace/tomcat/$JOB_NAME/logs:/opt/tomcat/logs $TAG


````


## 仓库 
 
gitee(main rep):  
 
 [bootshiro](https://gitee.com/tomsun28/bootshiro)  
 [usthe](https://gitee.com/tomsun28/usthe) 
 
github: 

[bootshiro](https://github.com/tomsun28/bootshiro)  
[usthe](https://github.com/tomsun28/usthe)  
         

。。。。。持续同步更新。。。。

======================================

欢迎一起完善哦^^  

<br>
<br>

### 效果展示  

![image4](/image/image4.PNG)   

![image5](/image/image5.PNG)   

![image6](/image/image6.PNG)   

![image7](/image/image7.PNG)   




thanks:  

[Howieair](http://iconfont.cn/user/detail?spm=a313x.7781069.0.d214f71f6&uid=187147)的小猪图标  
[zhangkaitao](http://jinnianshilongnian.iteye.com/blog/2018936)的跟我学shiro   
网络上前辈们的教程文章开源项目


<br>
<br>
<br>
