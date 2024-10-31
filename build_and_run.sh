#!/bin/bash
BASE_PATH=$(dirname "$0")
echo "begin build servicecomb,path=${BASE_PATH}"
cd "$BASE_PATH" || exit 1
mvn clean install
echo "build servicecomb success!"
echo "begin deploy servicecomb"
sh zookeeper-server/zookeeper-deploy.sh
sh edge-service/edge-deploy.sh
sh mysql-server/mysql-deploy.sh
sh authentication-server/auth-deploy.sh
sh resource-server/resource-deploy.sh
sh admin-service/admin-backend-deploy.sh
sh admin-website/admin-website-deploy.sh
echo "deploy servicecomb success!"
cd - || exit 0