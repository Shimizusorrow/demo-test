FROM openjdk:8-jdk-alpine

# 标签 可以通过 docker inspect <iamge>查看
LABEL version="0.0.1" dsc="这是blog服务器" by="shimizu"

# 挂载一个data 作为通用目录
VOLUME ["/data"]

ARG JAR_FILE=target/*.jar
# 将jar包修改名称并添加到容器中
ADD ${JAR_FILE} app.jar

# 允许指定的端口
EXPOSE 8090/tcp

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
ENV LANG C.UTF-8

# 启动jar
ENTRYPOINT ["java","-jar","/app.jar"]