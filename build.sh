#/bin/bash

Image_Name="justgo"
ContainerName="justGo"

Image_ID = `sudo docker images|grep -i ${Image_Name}|awk '{print $3}'`
echo "镜像ID = "$Image_ID 
Contain_ID=`sudo docker ps -a |grep -i ${ContainerName}|awk '{print $1}'`
echo "容器ID = "$Contain_ID"

if test -z "$Image_ID":
then 
    echo "镜像不存在"
else 
    if test -z "$Contain_ID"
        then echo "容器不存在"
    else
         echo "容器将要被执行stop命令"
         sudo docker stop $ContainerName
         echo "容器处于stop状态"
    if
     echo "旧镜像将要被删除"
     sudo docker rmi -f $Image_Name
     echo "成功删除旧镜像" 
fi
echo "镜像构建中:------->"

cd target
cp ../Dockerfile .
sudo docker build -t $Image_Name .

if test -z "$Contain_ID"
    then 
        echo "容器不存在"
else 
    sudo docker rm -f ${ContainerName}
    echo "旧容器已被删除"

echo "创建新容器"
sudo  docker run -d -p 8300:8300 $ContainerName $Image_Name
