#!/bin/bash
BASE_PATH=$(dirname "$0")
echo "begin deploy admin-website,path=${BASE_PATH}"
cd $BASE_PATH
kubectl delete svc admin-website
kubectl delete deploy admin-website
docker rmi swr.cn-north-4.myhuaweicloud.com/wmwei/admin-website:0.0.1
docker build -t swr.cn-north-4.myhuaweicloud.com/wmwei/admin-website:0.0.1 .
kubectl apply -f k8s/admin-website-deploy.yaml
kubectl apply -f k8s/admin-website-server.yaml
echo "deploy admin-website end"
cd -
