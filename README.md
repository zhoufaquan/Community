# 讨论社区

# 工具

# 资料
[springboot 文档](https://docs.spring.io/spring-boot/docs)

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
 # 获取授权码
 
 第三方网站要获取授权码，只需要让页面跳转到 Github 授权页即可，其中需要在 URL 中携带两个参数，分别是 Client ID 和 Redirect URL。
 
 跳转后，Github 会询问用户是否允许这个 APP 获取某些权限：
 
 用户确定后，会带着授权码重定向到给定的回调地址:
 
 这时候，第三方页面（这里是 localhost:8080）已经拿到了授权码，接下来就需要凭借这个授权码以及 APP 的 Client ID 和 Client secret 去兑换 Token 了。