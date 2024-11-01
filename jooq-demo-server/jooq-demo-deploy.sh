#!/bin/bash
BASE_PATH=$(dirname "$0")
echo "begin deploy jooq-demo,path=${BASE_PATH}"
cd "$BASE_PATH" || exit 1
kubectl delete svc jooq-demo
kubectl delete deploy jooq-demo
sleep 20
docker rmi swr.cn-north-4.myhuaweicloud.com/wmwei/jooq-demo-server:0.0.1
docker build -t swr.cn-north-4.myhuaweicloud.com/wmwei/jooq-demo-server:0.0.1 .
kubectl apply -f k8s/jooq-demo-deploy.yaml
kubectl apply -f k8s/jooq-demo-server.yaml
echo "deploy jooq-demo end"
cd - || exit 0
