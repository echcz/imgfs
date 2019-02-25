# imgfs

使用 SpringBoot + MongoDB 构建的图片服务器

## 说明

imgfs 使用了 MongoDB 数据库做为图片存储库，而不是使用本地文件系统。MongoDB 有非常强大的数据管理与横向扩容能力，并且图片不是大文件，几乎都不会超过 MongoDB 的文档大小限制 (16 MB)，所以选择 MongoDB 进行图片数据的存储与管理再合适不过了。

imgfs 使用了 Caffeine 作为本地缓存。在这个图片服务器中，性能瓶颈在与 MongoDB 的连接中，而在实际使用中，只有少量的图片会被经常访问到，所以加上本地缓存是非常合适的。从 Spring Boot 2.0 开始，因性能问题，Caffeine 取代了 Guava，成为推荐的本地缓存。

## TODO

添加权限管理。因为 imgfs 不需要自己作登录验证，所以不需要使用安全框架。添加一些拦截器，用于从外部进行验证即可。

改造成 Webflux 反应式 Web，以取得更好的性能。

## 使用

clone 本仓库 -> gradle bootRun

clone 本仓库 -> gradle booJar -> java -jar ...