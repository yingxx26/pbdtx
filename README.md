启动rocketmq（访问地址127.0.0.1:9876需要另外启动管理项目）
cmd
进入D:\rocketmq-all-4.4.0-bin-release\bin
执行 start mqnamesrv.cmd
执行 start mqbroker.cmd -n 127.0.0.1:9876 autoCreateTopicEnable=true
启动三个服务
访问http://localhost:56081/bank1/transfer?accountNo=1&amount=1

假如弹出提示框提示‘错误: 找不到或无法加载主类 xxxxxx’。打开runbroker.cmd，然后将‘%CLASSPATH%’加上英文双引号。保存并重新执行start语句。
# pbdtx
用于研究测试SpringCloud分布式事务控制解决方案，包括2PC、TCC、可靠消息最终一致性，最大努力通知，所用技术包括：Seata，Hmily，RocketMQ等

# 1 基础概念
什么是分布式事务：<https://blog.csdn.net/weixin_44062339/article/details/99044718>

CAP原理：<https://blog.csdn.net/weixin_44062339/article/details/99710968>

BASE理论：<https://blog.csdn.net/weixin_44062339/article/details/99711052>

# 1 seata实现2PC事务控制

代码实现步骤：<https://blog.csdn.net/weixin_44062339/article/details/100179885>

# 2 Hmily实现TCC事务控制

代码实现步骤：<https://blog.csdn.net/weixin_44062339/article/details/100180025>

# 3 RocketMQ事务消息方案

代码实现步骤：<https://blog.csdn.net/weixin_44062339/article/details/100180487>

# 4 课程视频

分布式事务课程视频：<http://www.pbteach.com/post/java_video/subject_dtx/>
# 5 系列讲义
http://www.pbteach.com/post/java_distribut/subject_dtx-01/

http://www.pbteach.com/post/java_distribut/subject_dtx-02/

http://www.pbteach.com/post/java_distribut/subject_dtx-03/

http://www.pbteach.com/post/java_distribut/subject_dtx-04/

http://www.pbteach.com/post/java_distribut/subject_dtx-05/

http://www.pbteach.com/post/java_distribut/subject_dtx-06/
