#!/bin/bash

docker run --name mysql-server \
-p 3306:3306 \
--restart=always \
-e='MYSQL_ROOT_PASSWORD=!Redhat123' \
-v D:/docker/mysql/data:/var/lib/mysql  \
-v D:/docker/mysql/logs:/var/log/mysql \
-d swr.cn-north-4.myhuaweicloud.com/wmwei/mysql:5.7