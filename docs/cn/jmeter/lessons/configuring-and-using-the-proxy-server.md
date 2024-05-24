# 第3课：配置和使用代理服务器

## 目标
本课的目标是在JMeter中配置代理服务器，并演示如何将其用于记录HTTP(S)请求。

## 步骤

### 3.1. 配置代理服务器
1. **设置端口和URL模式**
   - 在 **HTTP(S)测试脚本录制器** 窗口中，将 **端口** 字段设置为 `9090`。
   - 在 **排除的URL模式** 部分，点击 **添加**，输入诸如 `.*\.gif`、`.*\.js` 和 `.*\.css` 等模式。
     <br>![setting-port-and-url-pattern.png](../../../srcs/jmeter/setting-port-and-url-pattern.png)
### 3.2. 启动代理服务器
1. **开始录制**
   - 点击 **HTTP(S)测试脚本录制器** 窗口底部的 **开始** 按钮。
     <br>![start-recording-button.png](../../../srcs/jmeter/start-recording-button.png)
---

# [下一步：记录和管理HTTP请求](recording-and-managing-http-requests.md)