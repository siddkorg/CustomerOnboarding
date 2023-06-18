FROM maven:3.8.2-jdk-8 as mavenDeps

WORKDIR /onboarding-app
COPY . .
RUN mvn dependency:resolve

FROM mavenDeps as mavenBuild
RUN mvn clean install

CMD mvn spring-boot:run