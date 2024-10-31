
# docker pull file
`
    docker pull mysql:5.7
    docker tag  mysql:5.7 swr.cn-north-4.myhuaweicloud.com/wmwei/mysql:5.7 
`

# docker run
`
    docker run -d --name mysql-server -p 3306:3306 -e "MYSQL_ROOT_PASSWORD=Redhat123" swr.cn-north-4.myhuaweicloud.com/wmwei/mysql:5.7
`
