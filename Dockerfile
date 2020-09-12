FROM openjdk:8u191-jre-alpine3.8
RUN apk add curl jq

WORKDIR /usr/share/dockerNilesh

ADD target/TrainlineDockerSelenium.jar TrainlineDockerSelenium.jar
ADD target/TrainlineDockerSelenium-tests.jar TrainlineDockerSelenium-tests.jar
ADD target/libs libs

ADD TFW.xml TFW.xml
ADD TL.xml TL.xml

ADD healthcheck.sh healthcheck.sh

ENTRYPOINT sh healthcheck.sh
#java -cp TrainlineDockerSelenium.jar:TrainlineDockerSelenium-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE