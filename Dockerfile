FROM amazoncorretto:17-alpine3.16-jdk
#as builder

LABEL authors="kesaa"

WORKDIR /app
RUN apk update
RUN apk add git

RUN git clone https://github.com/kevinesaa/softka_stock_producer.git

RUN chmod 755 ./softka_stock_producer/gradlew
RUN ./softka_stock_producer/gradlew  -p  ./softka_stock_producer/ --stacktrace bootJar

RUN mkdir /temp
RUN mv /app/softka_stock_producer/build/libs/producer-0.0.1-SNAPSHOT.jar /temp/app.jar

RUN rm -rf /app/*

RUN mv /temp/app.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]