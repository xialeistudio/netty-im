# IM聊天服务器

1. 基于netty开发，包含自定义协议设计
2. 数据包处理函数基于注解设计，彻底抛弃if/else，提高代码可维护性

## feature
+ [x] 协议设计，参考 common项目中的PacketCodec
+ [x] 基于注解的数据包处理，参考client/server项目中的processor.ProcessorProxy

## todo
+ [ ] 登录拦截