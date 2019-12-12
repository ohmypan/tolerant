@echo off
REM 声明采用UTF-8编码
chcp 65001
echo 开始了
F:
CD F:\安装软件\kafka_2.11-2.2\kafka_2.11-2.2.0
echo 当前路径是 %cd%,kafka启动了
bin\windows\kafka-server-start.bat config\server.properties
echo kafka启动了