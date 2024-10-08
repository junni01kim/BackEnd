# Spring Boot와 Docker Compose를 이용한 베이스 백엔드 서버
### 구축 사항
1. 자체 로그인 (java security)
2. Swagger Ui
3. MariaDb
4. Spring Boot

※ Base_FrontEnd 구현 필요

# AWS 개설 후 해야할 것
1. IntelliJ와 동일한 JDK를 일치시킨다. (현재 correntto-21)
2. Docker Download
3. Docker Compose Download

## Git 설치 방법
[Linux Git Download](https://medium.com/@dassandeep0001/how-to-install-git-in-ec2-instance-1bfeb1cc9dc9)
```
sudo yum update -y

sudo yum install git -y

git — version

git config — global user.name “Your Name”
```

## Docker 설치 방법
[Amazon Linux 2024 Download for Docker](https://docs.aws.amazon.com/ko_kr/serverless-application-model/latest/developerguide/install-docker.html)
__링크만으론 sudo 없이 docker ps 사용안됨__  
이후 `$ newgrp docker` 이용할 것
```
sudo yum update -y

# Amazon Linux 2023의 경우
sudo yum install -y docker

sudo service docker start

sudo usermod -a -G docker ec2-user

newgrp docker

docker ps
```

## Docker Compose 설치 방법
[Amazon Linux 2024 Download for Docker Compose](https://gist.github.com/npearce/6f3c7826c7499587f00957fee62f8ee9)
```
sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose

sudo chmod +x /usr/local/bin/docker-compose

docker-compose version
```

## Amazon Corretto Download
[JAVA 21 설치 정리](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/downloads-list.html)
1. tar파일 압축 해제
2. Java 파일 위치 지정
```
curl -LO https://corretto.aws/downloads/latest/amazon-corretto-21-x64-linux-jdk.tar.gz

tar -zxvf amazon-corretto-21-x64-linux-jdk.tar.gz

mv amazon-corretto-21.0.4.7.1-linux-x64/ JAVA21/

rm amazon-corretto-21-x64-linux-jdk.tar.gz
```

[자바 환경변수 설정](https://zetawiki.com/wiki/%EB%A6%AC%EB%88%85%EC%8A%A4_$JAVA_HOME_%ED%99%98%EA%B2%BD%EB%B3%80%EC%88%98_%EC%84%A4%EC%A0%95#google_vignette)
1. 압축 해제된 파일 위치에 환경변수 설정
```
export JAVA_HOME=/home/ec2-user/JAVA21

$JAVA_HOME/bin/javac -version
```

## 깃 클론
백엔드 다운로드
```
git clone https://github.com/junni01kim/BackEnd.git
```

프론트엔드 다운로드(임시)
```
git clone https://github.com/junni01kim/FrontEnd.git
```

## 프로젝트 실행
```
cd ~/BackEnd/

chmod +x ./gradlew # 한번만

docker-compose down

./gradlew clean build

docker-compose up -d
```

## ※주의 사항※
1. repository clone을 했다면, `./gradlew clean build`를 한번 진행할 것
   - `docker-compose up -d` 이전 그래들에 Jar파일이 생성되지 않기 때문이다.
2. `./gradlew clean build` 진행하기 전 `chmod +x gradlew` 사전 진행 필요
   - 처음 파일을 받으면, gradlew 파일에 실행 권한이 존재하지 않기 때문이다. (추후 repo 단계에서 수정 예정)
3. __※중요※__ ec2 프리티 t2.micro는 도커 실행 시 __인스턴스 과부하로__ 작동이 멈추기 때문에, 멈췄다면 __인스턴스 중지__ 후 __다시 시작__ 해야 한다.
4. 127.0.0.0 데이터베이스 접근 불가로, ip 개방 코드 mariadb sql 작성 필요.
