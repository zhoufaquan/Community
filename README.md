# 讨论社区

# 错误
```
[1] error: failed to push some refs to 'git@github.com:zhoufaquan/Community.git'

hint: Updates were rejected because the remote contains work that you do

hint: not have locally. This is usually caused by another repository pushing

hint: to the same ref. You may want to first integrate the remote changes

hint: (e.g., 'git pull ...') before pushing again.

hint: See the 'Note about fast-forwards' in 'git push --help' for details.
```

   原因：由于某次我在GitHub的仓库直接修改了README.md,而本地仓库中的项目并为及时更新，然后我在本地仓库改了些东西，push 失败
   描述：首先，这个错误可能会让人有些不知所措，不要担心。
      简而言之，git不能在不丢失提交的情况下在远程上进行更改，因此它拒绝推送。通常，这是由另一个用户推送到同一分支引起的。
      您可以通过获取和合并远程分支，或使用pull一次执行两者来解决此问题。
      
      在其他情况下，此错误是由于使用诸如git commit --amend或命令在本地进行的破坏性更改的结果git rebase。
      尽管可以通过添加--forcepush命令来覆盖遥控器，但只有在绝对确定这是您要执行的操作时，才应该这样做。强制推送可能会给获取了远程分支的其他用户带来问题，
      被认为是不正确的做法。如有疑问，请不要强行按下。
      
    [2]解决方法  1.合并分支 git push -f origin master 2.本地仓库先push在commit
    
    ```
    git报错：'fatal:remote origin already exists'怎么处理？附上git常用操作以及说明。
    解决：1、先删除
    $ git remote rm origin
    2、再次执行添加就可以了。　
    git remote add origin git@github.com:zhoufaquan/Community.git

    ```

# 新建工程提交到gitHub等git服务器的步奏

1.配置查找电脑的.ssh key

2.将.ssh key填充至服务器（网站）

3.在服务器（网站）上新建一个项目，最好直接包含有README 和 .gitignore

4.新建项目完成后，可以看到项目的克隆或者下载地址，等会需要用到的是http的地址


5.使用终端，cd到桌面

6.使用命令行 git clone 项目地址 /* git clone https://github.com/h4836j/addressBook.git */ (后面的是项目地址)

7.克隆项目成功后，再将命令行cd到当前项目路径下去

8.将需要上传的工程文件拷贝到克隆出来的文件夹中

9.初始化git仓库

git init // 在当前项目目录中生成本地git管理,并建立一个隐藏.git目录

10.添加文件到git中

git add . // 添加当前目录中的所有文件到索引

11.提交到本地代码仓库

git commit -m "first commit" //提交到本地源码库，并附加提交注释

12.提交到远程代码仓库

git remote add origin https://github.com/h4836j/addressBook.git //添加到远程项目，别名为origin (后面的是项目地址)

如果报错说远程仓库中已经存在，则先移除远程仓库 git remote rm origin 之后再执行这句

13.推送本地代码到服务器

git push -u origin master //把本地源码库push到github 别名为origin的远程项目中，确认提交

如果报错说本地文件不是最新的，则先拉取远程仓库文件 git pull origin master 之后再执行push操作

#新建分支
1.在远程仓库创建第二个分支
2.本地仓库先拉取 git pull
3.切换分支 git chekout bug1
4.切换回 主线“master”分支

# 资料
[springboot 文档](https://docs.spring.io/spring-boot/docs)

[githubApp文档] (https://developer.github.com/apps/building-github-apps/identifying-and-authorizing-users-for-github-apps/)

[bootstrap](https://v3.bootcss.com/components/#navbar)

[es社区](https://elasticsearch.cn/)

[github](https://github.com/zhoufaquan/Kaola)

# 什么是 Github App

GitHub Apps are first-class actors within GitHub. A GitHub App acts on its own behalf,taking actions via the API directly using its own identity,
 
which means you don't need to maintain a bot or service account as a separate user.
 
 简单翻译一下，就是 Github App 可以通过 Github 提供的认证信息去调用 Github API。
 
 细心的读者会发现，Github 还提供了一个叫做“OAuth App”的东西，它的使用方式和 Github App 非常类似，
 
 最大的不同点是 OAuth App 所获取的权限都是固定且只读的，用户只能读取固定的数据而不能修改数据；
 
 而 Github App 几乎可以获取Github提供的所有功能权限，
 
 且所获取的权限可以被设定为“只读”，“可读可写”和“禁止访问”，对于权限的授权粒度会更细。
 
 # 第三方登录的原理
 
 下面介绍这种登录方式的流程：
 
 1.A 网站跳转到 Github 的授权页面。
 2.Github 授权页面询问用户：“是否允许A网站获取下列权限”，用户点击“允许”，取得授权码。
 3.Github 授权页面重定向回 A 网站，同时在URL 上带上授权码。
 4.A 网站通过 URL 上的授权码往 Github 取回 Token。
 5.A 网站使用这个 Token 去调用 Github API。
 要完成上述的流程，首先必须先注册一个 Github App。
 
 # 注册 Github App
 
 进入 Github主页，点击用户头像，找到 Setting/Developer settings/Github Apps，然后点击“New Github App”，即可进入编辑界面：
 Github App 注册完毕，接下来就需要第三方网站使用这个 APP 的 Client ID 去找 Github 要授权码了
 # 获取授权码（每次授权都会动态改变）
 
 第三方网站要获取授权码，只需要让页面跳转到 Github 授权页即可，其中需要在 URL 中携带两个参数，分别是 Client ID 和 Redirect URL。
 
 跳转后，Github 会询问用户是否允许这个 APP 获取某些权限：
 
 用户确定后，会带着授权码（code）重定向到给定的回调地址:
 
 这时候，第三方页面（这里是 localhost:8087）已经拿到了授权码，接下来就需要凭借这个授权码以及 APP 的 Client ID 和 Client secret 去兑换 Token 了。
 
 
 # 兑换accecc_token(访问令牌)
 
