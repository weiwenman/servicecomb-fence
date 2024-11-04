#!/bin/bash
BASE_PATH=$(dirname "$0")
echo "begin deploy zipkin-demo,path=${BASE_PATH}"
cd "$BASE_PATH" || exit 1
kubectl delete svc zipkin-demo
kubectl delete deploy zipkin-demo
sleep 20
docker rmi swr.cn-north-4.myhuaweicloud.com/wmwei/zipkin:latest
docker tag openzipkin/zipkin:latest swr.cn-north-4.myhuaweicloud.com/wmwei/zipkin:latest
kubectl apply -f k8s/zipkin-demo-conf.yaml
kubectl apply -f k8s/zipkin-demo-deploy.yaml
kubectl apply -f k8s/zipkin-demo-server.yaml
echo "deploy zipkin-demo end"
cd - || exit 0
