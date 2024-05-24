# 第8课：对HTTP请求进行参数化

## 目标
本课的目标是使用提取的动态值在JMeter中对HTTP请求进行参数化。

## 步骤

### 8.1. 修改HTTP请求
1. **使用提取的值**
   - 在每个使用参数 `javax.faces.ViewState` 的HTTP请求中，将其值替换为 `${jsfViewState}`。
   - 如有必要，请确保选中 **Encode** 复选框。

---

# [下一步：添加监听器并运行测试](adding-listeners-and-running-tests.md)