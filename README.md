# show_work

## Vue＋Springboot project（优秀作品展示网站）

## 界面设计

### 1.登录

![image-20210309164015512](https://github.com/BigStrawberry0225/show_work/blob/main/README-images/image-1.png)

### 2.普通用户首页

![image-20210309164033632](https://github.com/BigStrawberry0225/show_work/blob/main/README-images/image-2.png)

### 3.上传优秀作品

![image-20210309164059502](https://github.com/BigStrawberry0225/show_work/blob/main/README-images/image-3.png)

### 4.个人信息展示

![image-20210309164126373](https://github.com/BigStrawberry0225/show_work/blob/main/README-images/image-4.png)

### 5.作品分类展示

![image-20210309164334147](https://github.com/BigStrawberry0225/show_work/blob/main/README-images/image-5.png)

### 6.优秀作品查看

![image-20210309164338773](https://github.com/BigStrawberry0225/show_work/blob/main/README-images/image-6.png)

![image-20210309164351433](https://github.com/BigStrawberry0225/show_work/blob/main/README-images/image-7.png)

### 7.优秀作品编辑

![image-20210309164356939](https://github.com/BigStrawberry0225/show_work/blob/main/README-images/image-8.png)

### 8.作品分页展示

![image-20210309164400865](https://github.com/BigStrawberry0225/show_work/blob/main/README-images/image-9.png)

### 9.管理员界面（用户管理

![image-20210309164406647](https://github.com/BigStrawberry0225/show_work/blob/main/README-images/image-10.png)

### 10.管理员界面（课程管理

![image-20210309164410343](https://github.com/BigStrawberry0225/show_work/blob/main/README-images/image-11.png)

### 11.管理员界面（项目管理

![image-20210309164415365](https://github.com/BigStrawberry0225/show_work/blob/main/README-images/image-12.png)

## 一、引言

### 1.1 背景

经过观察发现，现在同学们的分享的意愿很高。很多同学喜欢分享自己的优秀作品，也有很多同学喜欢在学习过程中记录所学知识，整理成知识点讲解文档以及优秀作品，方便自己随时阅读，也分享给有需要的朋友。

因为没有一个固定的分享平台，这些生活动态以及文档往往是以QQ为媒介，在私聊，群聊中分享。对于分享者来说，上传很是麻烦，自己又多个平台的社交帐号也很难管理，需要有一个类似于优秀作品展示网站的空间和平台去分享自己的优秀作品，也可以添加自己喜欢的小功能。而对于其他人来说，想要看到分享者的文档需要提前下载，查看时需要打开新的窗口，操作繁琐，而浏览分享者的优秀作品展示要方便快捷得多，得到的内容也更加丰富。

所以我们希望开发优秀作品展示网站系统，该系统采用B-S架构，整体设计为：通过优秀作品展示网站的统一域名，不同身份的人员可以使用自己的用户名和密码登录网站，进行不同的操作。由于同一登陆一个网站进行操作，这样的设计可以大大提高用户的操作的效率，同时提高管理的便捷性。

系统整体采用后端springboot框架，前端采用vue.cli3框架，并采用了Element-UI美化界面，在axios的基础上与后端进行信息交互，对数据库中已有数据进行查询、增添、删除或修改等操作，完成项目的主要功能。



### 1.2 开发语言

后端：JAVA，使用springboot框架开发

用Java做设计流程清晰、结构合理，而且逻辑清晰便于理解，而且减少耦合性，修改比较方便。并且之前有做过JAVA相关的项目，对JAVA语言比较熟悉。

前端：HTML，CSS，JS，采用VUE脚手架

使用VUE脚手架，方便项目整体搭建；各个模块分布清晰，便于管理；数据渲染比原生JS方便有效

数据库：MySQL-8.0.22

数据库工具：navicat for mysql



### 1.3 开发工具

IntelliJ IDEA + webstorm



## 二、需求分析

### 2.1 功能型需求

##### 一.      	首页模块

**a)**     首页模块：用户刚进入看到的界面，用于简单地展示作品分类和作品展示

b)     简单的个人信息展示

c)     简单的优秀作品展示

 

##### **二．**       **优秀作品模块**

a)     优秀作品筛选

根据优秀作品分类种类搜索优秀作品，符合要求的优秀作品放在优秀作品的展示列表，并且优秀作品能够按时间进行降序显示

b)     优秀作品列表展示

分页显示优秀作品，每页5条，每次只向后台请求符合要求的5条优秀作品数据；每篇优秀作品展示的基本信息包含优秀作品标题，发布时间，优秀作品概述，优秀作品分类；点击优秀作品可以跳转到优秀作品展示页面，展示优秀作品

c)     查看优秀作品

在主页的优秀作品板块和优秀作品模块，点击优秀作品，跳转到优秀作品展示界面；优秀作品展示界面展示优秀作品标题，优秀作品内容，点击返回按钮可以返回上一页面，并且可以对优秀作品进行修改。



##### **三．**       **个人展示模块**

a)     展示个人信息

在个人信息模块展示的个人信息包括头像，学号，姓名

b)     展示优秀作品

分页显示优秀作品，每页5条，每次只向后台请求符合要求的5条优秀作品数据；每篇优秀作品展示的基本信息包含优秀作品标题，发布时间，优秀作品概述，优秀作品分类；点击优秀作品可以跳转到优秀作品展示页面，展示优秀作品



##### **四．**       **登录模块**

a)     登录

通过用户名密码进行登录，对登录成功与否进行显示

 

##### **五．**       **后台管理——个人信息管理**

可供修改的信息：头像

 

##### **六．**       **后台管理——优秀作品管理**

a)     增加分类

添加优秀作品分类，只能添加新的分类

b)     删除分类

可以删除分类，但是有一个分类不能删除（其他分类）

c)     新建优秀作品

点击上传优秀作品按钮，可以跳转到优秀作品编辑界面新建优秀作品，对于优秀作品重要内容判断不能为空再向后台发送请求

d)     显示优秀作品基本信息

在优秀作品管理界面，优秀作品管理者需要对各个优秀作品的基本信息一目了然，并且不显示优秀作品内容以免页面过于拥挤。显示优秀作品的基本信息为日期，标题，分类，基本操作（删除）

e)     编辑优秀作品

优秀作品管理能够对已经发布的优秀作品进行编辑，编辑过后改变优秀作品发布的时间

f)     删除优秀作品



### 2.2 数据需求

个人优秀作品管理系统通过优秀作品的统一域名，不同身份的人员可以使用自己的用户名和密码登录网站，进行不同的操作。

其中需求数据为：

1、优秀作品主人信息记录：

用户名、密码、是否管理员

（1）学号，昵称，账号状态，头像。

2、优秀作品基本信息记录：

日期、标题、分类、概述、内容。

### 2.3角色需求

2.3.1普通用户

他是一个乐于展示自己的、热心的同学，具备优秀作品。他想有一个途径来分享自己的作品。A想通过写优秀作品展示介绍REAMME文件来实现这一想法，但是觉得普通文本编辑排版太繁琐又不好看，于是他希望通过markdown语言来编辑自己的展示内容，并将之转化为相应的html格式以获得更棒的展示效果。

他是一个平时喜欢或者需要查看其它同学优秀作品的同学，他想有一个可靠的查看同学院同学优秀作品的途径。B想通过看优秀作品展示网站来实现这一想法。他希望优秀同学不只是讲解，还能提供相关的资料，以便学习。他还希望资料以较为清晰的方式展示。

 

2.3.2管理员

他是本系统的管理员。他需要一个不同于普通用户的操作界面(以方便进行操作)，能添加课程分类，方便用户进行分类查看，能寻找不够规范的优秀作品，将其清理掉。并且可以对不符合要求的用户进行封号操作。



