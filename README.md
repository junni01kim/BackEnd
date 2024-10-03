# Spring Boot와 Docker Compose를 이용한 베이스 백엔드 서버
※ Base_FrontEnd 구현 필요

# AWS 개설 후 해야할 것
1. IntelliJ와 동일한 JDK를 일치시킨다. (현재 correntto-21)
2. Docker Download
3. Docker Compose Download

## Git 설치 방법
[Linux Git Download](https://medium.com/@dassandeep0001/how-to-install-git-in-ec2-instance-1bfeb1cc9dc9)

## Docker 설치 방법
[Amazon Linux 2024 Download for Docker](https://docs.aws.amazon.com/ko_kr/serverless-application-model/latest/developerguide/install-docker.html)
__링크만으론 sudo 없이 docker ps 사용안됨__ 이후 `$ newgrp docker` 이용할 것

## Docker Compose 설치 방법
[Amazon Linux 2024 Download for Docker Compose](https://gist.github.com/npearce/6f3c7826c7499587f00957fee62f8ee9)

## Amazon Corretto Download
[JAVA 21 설치 정리](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/amazon-linux-install.html)

## ※주의 사항※
`docker-compose up -d` 이전 그래들에 Jar파일이 생성되지 않은 관계로, `./gradlew clean build`를 한번 진행할 것
