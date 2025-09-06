# Etapa de build com Maven
FROM maven:3.8.6-eclipse-temurin-17-alpine AS build

WORKDIR /app

# Copia o pom.xml e baixa dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte e constrói o projeto
COPY src ./src
RUN mvn clean package -DskipTests

# Imagem final para execução
FROM eclipse-temurin:17-jdk-alpine

# Define o diretório de trabalho
WORKDIR /app

# Volume para arquivos temporários
VOLUME /tmp

# Copia o JAR gerado da etapa de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

# Comando para executar o JAR
ENTRYPOINT ["java", "-Dserver.port=8081", "-jar", "app.jar"]