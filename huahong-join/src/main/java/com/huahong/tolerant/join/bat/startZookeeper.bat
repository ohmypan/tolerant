@echo off
REM 声明采用UTF-8编码
chcp 65001
echo 开始了
F:
CD F:\安装软件\kafka_2.11-2.2\kafka_2.11-2.2.0
echo 当前路径是 %cd%,zookeeper 启动了
bin\windows\zookeeper-server-start.bat config\zookeeper.properties
echo zookeeper 启动了