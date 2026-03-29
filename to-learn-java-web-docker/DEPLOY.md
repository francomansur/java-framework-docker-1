# Deploy com Docker - Guia Rápido

## Pré-requisito
- Docker Desktop instalado e rodando

---

## 1. Subir tudo (Tomcat + MySQL + phpMyAdmin)

```bash
docker compose up -d --build
```

> O `-d` roda em background. O `--build` compila o projeto e gera o WAR automaticamente.

## 2. Acessar

| Serviço        | URL                                              |
|----------------|--------------------------------------------------|
| Tomcat (home)  | http://localhost:8080/                            |
| Sua aplicação  | http://localhost:8080/to-learn-java-web-docker/   |
| phpMyAdmin     | http://localhost:8081/                            |

## 3. Parar tudo

```bash
docker compose down
```

---

## Onde fica o arquivo WAR?

O WAR **não aparece na sua máquina**. Ele é gerado **dentro do Docker** durante o build:

1. O Docker executa `mvn clean package` dentro de um container Maven
2. O WAR é gerado em `/app/target/to-learn-java-web-docker.war` (dentro do container de build)
3. O WAR é copiado para `/usr/local/tomcat/webapps/` no container do Tomcat

Para ver o WAR dentro do container:

```bash
docker exec tomcat-app ls /usr/local/tomcat/webapps/
```

Para copiar o WAR para sua máquina (se precisar):

```bash
docker cp tomcat-app:/usr/local/tomcat/webapps/to-learn-java-web-docker.war ./to-learn-java-web-docker.war
```

---

## Deploy / Redeploy (após alterar código)

Editou o código-fonte? Rode:

```bash
docker compose up -d --build
```

Isso vai:
1. Recompilar o projeto com Maven
2. Gerar um novo WAR
3. Recriar o container do Tomcat com o WAR atualizado
4. MySQL e phpMyAdmin continuam rodando (dados preservados)

Se quiser forçar rebuild completo (sem cache):

```bash
docker compose up -d --build --force-recreate
```

---

## MySQL

| Campo        | Valor     |
|------------- |-----------|
| Host         | localhost |
| Porta        | 3306      |
| Banco        | teste     |
| Usuário      | teste     |
| Senha        | teste     |
| Senha root   | teste     |

> Dentro do código Java, use `mysql` como host (nome do serviço no Docker), não `localhost`.
