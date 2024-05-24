# 第7课：创建测试场景

## 目标
本课的目标是通过整理记录的请求并在JMeter中添加动态值提取来创建一个测试场景。

## 步骤

### 7.1. 添加简单控制器
1. **整理请求**
   - 右键单击 **线程组**。
     <br>![thread-group-icon.png](../../../srcs/jmeter/thread-group-icon.png)
   - 选择 **添加 > 逻辑控制器 > 简单控制器**。
     <br>![new-simple-controller-button.png](../../../srcs/jmeter/new-simple-controller-button.png)
   - 将所有记录的HTTP请求从 **Recording Controller** 拖放到 **Simple Controller** 中。

### 7.2. 添加正则表达式提取器
1. **动态值提取**
   - 右键单击需要动态值的HTTP请求（例如，`javax.faces.ViewState`）。
   - 选择 **添加 > 后置处理器 > 正则表达式提取器**。
     <br>![new-regular-expression-button.png](../../../srcs/jmeter/new-regular-expression-button.png)
   - 配置提取器：
      - **引用名称：** `jsfViewState`
      - **正则表达式：** `<input type="hidden" name="javax\.faces\.ViewState" value="(.*?)"`
      - **模板：** `$1$`
      - **匹配号：** `0`
        <br>![regular-expression-extractor-fields.png](../../../srcs/jmeter/regular-expression-extractor-fields.png)

---

# [下一步：给HTTP请求参数化](parameterizing-http-requests.md)