# File Transfer Based on Spring MVC

> 注意: 目前该版本不支持文件名为中文的情况。

## 安装与部署步骤

### 1. 下载并配置 Apache Maven
- 访问 [Apache Maven 官网](https://maven.apache.org/download.cgi) 下载 `apache-maven-3.9.9-bin.zip`。
- 解压到本地目录中，并将 `bin` 目录添加到环境变量 `PATH` 中。
- 在项目根目录执行以下命令来构建项目：
  ```bash
  mvn clean package
该命令会在 target 文件夹中生成一个 war 文件。

2. 准备 Tomcat 环境
下载并安装 Tomcat 服务器。
启动 Tomcat。
3. 部署 WAR 文件
将生成的 war 文件放到 Tomcat 的 webapps 目录下。
重启 Tomcat，Tomcat 会自动解压 WAR 文件。
4. 移动 Spring 配置文件
进入 simple-spring-mvc/WEB-INF/classes 目录，将 spring-mvc.xml 文件移动到 WEB-INF 目录中。
5. 访问文件上传页面
在浏览器中访问以下网址：
http://<服务器ip>:8080/simple-spring-mvc/upload
(默认端口为 8080，<服务器ip> 替换为实际的服务器 IP 地址)

你会看到文件上传页面。

![image](https://github.com/user-attachments/assets/f4330fe1-37ec-4a5e-9a57-2ef3c1a9041d)

可通过get请求下载文件
![image](https://github.com/user-attachments/assets/ec8731c6-e91c-42f9-b626-e02b98e298d7)


注意事项
目前该版本不支持文件名为中文的情况，如果有中文文件名，请修改为英文或其他支持的字符集。
