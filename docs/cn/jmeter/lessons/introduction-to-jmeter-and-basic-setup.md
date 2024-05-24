# 第1课：介绍JMeter和基本设置

## 目标
本课的目标是介绍JMeter，并指导您完成基本设置过程，包括启动JMeter和向测试计划添加线程组。

## 步骤

### 1.1. 启动JMeter

![jmeter-site.png](../../../srcs/jmeter/site.png)
1. **下载并安装JMeter**
   - 访问[官方JMeter网站](https://jmeter.apache.org/download_jmeter.cgi)并下载最新版本。
   - 解压下载的存档文件。
   - 进入 `bin` 目录，并通过运行 `jmeter.bat` 文件（Windows）或 `jmeter.sh`（macOS/Linux）启动JMeter。

### 1.2. 添加线程组
![interface.png](../../../srcs/jmeter/interface.png)
1. **创建测试计划**
   - 打开JMeter。
   - 右键单击 **测试计划** 节点。
     <br>![test-plan.png](../../../srcs/jmeter/test-plan.png)

   - 选择 **添加 > 线程(用户) > 线程组**。
     <br>![test-plan.png](../../../srcs/jmeter/thread-group.png)

---    
# [下一步：设置HTTP测试脚本记录器](setting-up-http-test-script-recorder.md)