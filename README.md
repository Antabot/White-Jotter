白卷目前是一个前后端分离的图书管理系统，项目采用 SpringBoot+Vue 开发。  


# 前言 

这是一个简单的小项目，旨在熟悉 Java Web 项目开发流程，我会把开发的经验分享给大家，并尽量采用目前较为流行的技术。

随着时间的推移，项目会逐渐完善，最终变成什么亚子，我也不知道。

# 一、整体效果

## 1.登录页面

![登录页面](https://i.loli.net/2019/04/14/5cb2fd5b78ae7.png)

## 2.首页

作为展示页面，包括开发这个项目的主要参考资料、近期更新和 Slogan

![首页](https://img-blog.csdnimg.cn/20190403215932913.png)

## 3.图书馆

作为核心功能页面之一，提供图书信息展示、图书信息管理两大功能

![图书馆](https://i.loli.net/2019/04/13/5cb1e3d5acf1d.png)

图书上传界面

![图书上传](https://i.loli.net/2019/04/13/5cb1e3d562751.png)

功能实现情况

### 1.图书展示

功能描述 | 实现情况
---|---
基本信息 | 完成

### 2.图书管理

功能描述 | 实现情况
---|---
图书分类 | 基本完成
图书上传 | 基本完成
图书维护 | 基本完成

### 3.信息查询

功能描述 | 实现情况
---|---
图书检索 | 基本完成
图书排序 | 未完成

### 4.其它功能

功能描述 | 实现情况
---|---
阅读标注 | 未完成

## 4.笔记本

该页面尚未成型

# 二、技术栈

## 1.前端技术栈

1.Vue  
2.ElementUI  
3.axios   

## 2.后端技术栈

1.SpringBoot  
2.Java Persistence API  
3.MySQL  
  
在开发过程中还会不断用到一些细碎的技术，有必要的我会增添上去

# 三、部署方法

1.clone 项目到本地

`git clone https://github.com/Antabot/White-Jotter`

2.数据库脚本放在 `wj` 项目的根目录下，在MySQL中执行数据库脚本  

3.数据库配置在 `wj` 项目的 `src\main\resources` 目录下的`application.properties` 文件中，mysql 版本为 8.0.15   

4.在IntelliJ IDEA中运行 `wj` 项目，为了保证项目成功运行，可以右键点击 `pom.xml` 选择 maven -> reimport ，并重启项目

至此，服务端就启动成功了，同时，运行 `wj-vue` 项目，访问 `http://localhost:8080` ，即可进入登录页面，默认账号是 `admin`，密码是 `123`

如果要做二次开发，请继续看第五、六步。

5.进入到 `wj-vue` 目录中，在命令行依次输入如下命令：  

```
# 安装依赖
npm install

# 在 localhost:8080 启动项目
npm run dev
```  

由于在 `wj-vue` 项目中已经配置了端口转发，将数据转发到SpringBoot上，因此项目启动之后，在浏览器中输入 `http://localhost:8080` 就可以访问我们的前端项目了，所有的请求通过端口转发将数据传到 SpringBoot 中（注意此时不要关闭 SpringBoot 项目）。

6.最后可以用 `WebStorm` 等工具打开 `wj-vue`项目，继续开发，开发完成后，当项目要上线时，依然进入到 `wj-vue` 目录，然后执行如下命令：  

```
npm run build
```  

该命令执行成功之后， `wj-vue` 目录下生成一个 `dist` 文件夹，可以将该文件夹中的两个文件 `static` 和 `index.html` 拷贝到 `wj` 项目中 `resources/static/` 目录下，然后直接运行 `wj` 项目，访问 `http://localhost:8443` ，实际上是把前端打包后作为静态文件，但不推荐使用这种方式。

# 教程

我在 CSDN 上分享了开发这个项目的教程，有兴趣的小伙伴可以点击下面的链接查看。  

1.[项目简介](https://blog.csdn.net/Neuf_Soleil/article/details/88925013)

2.[使用 CLI 搭建 Vue.js 项目](https://blog.csdn.net/Neuf_Soleil/article/details/88926242)

3.[前后端结合测试（登录页面开发）](https://blog.csdn.net/Neuf_Soleil/article/details/88955387)

4.[数据库的引入](https://blog.csdn.net/Neuf_Soleil/article/details/89294300)

5.[使用 Element 辅助前端开发](https://blog.csdn.net/Neuf_Soleil/article/details/89298717)

6.[前端路由与登录拦截器](https://learner.blog.csdn.net/article/details/89422585)

7.[导航栏与图书页面设计](https://learner.blog.csdn.net/article/details/89853305)

8.[数据库设计与增删改查](https://learner.blog.csdn.net/article/details/92413933)

9.[核心功能的前端实现](https://learner.blog.csdn.net/article/details/95310666)

10.[图片上传与项目的打包部署](https://learner.blog.csdn.net/article/details/97619312)

11.[用户角色权限管理模块设计](https://learner.blog.csdn.net/article/details/100849732)

(持续更新中)

# 近期更新

04-27 使用前端拦截器，数据库迁移至 mysql 8.0.15，后台管理页面初始化  
04-13 完成图片的上传功能  
04-11 完成图书分类功能  
04-08 完成图书分页功能  
04-06 完成图书查询功能  
04-05 完成图书修改功能  
04-04 完成图书删除功能  
04-03 完成图书新增功能

# 其他资料
