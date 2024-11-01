#!/bin/bash
BASE_PATH=$(dirname "$0")
echo "begin deploy mysql,path=${BASE_PATH}"
cd "$BASE_PATH" || exit 1
kubectl delete svc mysql
kubectl delete deploy mysql
sleep 20
docker rmi swr.cn-north-4.myhuaweicloud.com/wmwei/mysql:5.7
docker build -t swr.cn-north-4.myhuaweicloud.com/wmwei/mysql:5.7 .
kubectl apply -f k8s/mysql-conf.yaml
kubectl apply -f k8s/mysql-deploy.yaml
kubectl apply -f k8s/mysql-server.yaml
echo "deploy mysql end"
cd - || exit 0
