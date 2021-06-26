FROM maven:3.8.1-openjdk-16 as build

WORKDIR /build

ADD src ./src
ADD pom.xml ./pom.xml

RUN mvn clean package -DskipTests

CMD sleep 30; mvn spring-boot:run
