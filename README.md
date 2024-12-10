# filetransfer
based on Springmvc
attention:目前还不支持文件名为中文的情况
1.在maven官网下载apache-maven-3.9.9-bin.zip，解压到电脑某个目录中，将bin目录添加到环境变量path中，然后在项目根目录使用mvn clean package命令在target文件夹中生成一个war文件。
2.服务器准备好tomcat环境
3.把war文件放在tomcat的webapps目录下并重启tomcat
4.再次打开webapps目录，你会发现war文件被解压了，进入simple-spring-mvc/WEB-INF/classes目录，把spring-mvc.xml移动到WEB-INF目录
5.访问网址http://<服务器ip>:8080/simple-spring-mvc/upload  (8080是tomcat的默认端口)即可看到文件上传目录
