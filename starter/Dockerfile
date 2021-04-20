FROM java:8
WORKDIR /blog
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} blog.jar
EXPOSE 8090
EXPOSE 18010
VOLUME /blog
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
ENV LANG C.UTF-8
# 暴露 18010 端口用于远程调试
ENTRYPOINT ["java","-jar","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=18010","blog.jar"]
