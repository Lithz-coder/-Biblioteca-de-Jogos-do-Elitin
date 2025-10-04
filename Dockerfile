# Estágio 1: Build da Aplicação com Maven
# Usamos uma imagem que já tem o Maven e o Java 17 instalados.
FROM maven:3.8-openjdk-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo de configuração do Maven para baixar as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia todo o código-fonte do projeto
COPY src ./src

# Executa o comando para empacotar a aplicação em um arquivo .jar
# O -DskipTests acelera o processo por não rodar os testes durante o deploy
RUN mvn package -DskipTests

# Estágio 2: Execução da Aplicação
# Usamos uma imagem leve, que contém apenas o necessário para rodar Java (JRE)
FROM eclipse-temurin:17-jre

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo .jar que foi gerado no estágio de build
# Atenção: ajuste o nome do .jar se for diferente no seu projeto
COPY --from=build /app/target/bibliotecajogos-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080, que é a padrão do Spring Boot
EXPOSE 8080

# Comando final que será executado quando o container iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]
