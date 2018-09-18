## 作业
1. 一个基本的Gradle配置由那几部分组成，它们各代表什么含义？

```
+ task
+ 插件：plugins { id :'java' }
+ 依赖：dependencies{ }
+ 仓库配置：repositories{ }
+ jdk版本：sourceCompatibility = 1.8
+ 源文件路径配置：sourceSets { }
+ 测试：test{}
+ gradle build依赖：buildscript { }
+ 依赖范围的配置：configurations{}
+ group 'thoughtworks.example.cn'
+ version '1.0-SNAPSHOT'
```

2. 单元测试主要测什么？自己设计一个例子来证明

```
测试单个方法的输入输出是否符合预期
+ 错误情况
+ 边界情况
+ 正常情况
```

3. 你觉得单元测试和TDD有哪些好处？

```
+ 保证代码正确性
+ 保证重构后的正确性
+ 快速定位bug，减少调试时间
+ 明确完成进度
+ 明确当前目标，开始下一个任务
+ 测试即文档

+ 从用户角度思考，更关注接口，而不是具体实现
+ 不陷入细节，测试覆盖率更高
+ 划分情况，集中注意解决一个问题
```

4. 完成*分组排序* TDD实现，要求有Tasking图，小步提交
[](https://raw.githubusercontent.com/tw-graduate-step-up/qqdou-TaskingCreateOrder/master/41537237553_.pic.jpg)
5. 完成*创建订单* TDD实现，要求有Tasking图，小步提交
