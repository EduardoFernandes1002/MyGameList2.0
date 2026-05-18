# MyGameList 2.0

Uma plataforma completa para gerenciar, descobrir e compartilhar sua lista de jogos favoritos. Sistema full-stack com autenticação segura, ranking de jogadores e recomendações personalizadas.

## 📋 Pré-requisitos

Antes de começar, certifique-se de que você possui os seguintes softwares instalados:

### Requisitos Globais
- **Git** - Para clonar o repositório
  - [Baixar Git](https://git-scm.com/downloads)
- **Node.js** (v18 ou superior) e npm
  - [Baixar Node.js](https://nodejs.org/en/)
  - Verificar instalação: `node --version` e `npm --version`

### Backend
- **Java 17** ou superior
  - [Baixar Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
  - Verificar instalação: `java -version`
- **Maven** (geralmente incluído no JDK)
  - [Baixar Maven](https://maven.apache.org/download.cgi)
  - Verificar instalação: `mvn --version`
- **Banco de Dados** (Escolha uma opção):
  - **MySQL Server 8.0+** - [Baixar MySQL](https://dev.mysql.com/downloads/mysql/)
  - **SQL Server 2019+** - [Baixar SQL Server](https://www.microsoft.com/sql-server/sql-server-downloads)

### Desenvolvedor (Opcional)
- **IDE para Frontend**: [Visual Studio Code](https://code.visualstudio.com/) ou similares
- **IDE para Backend**: [IntelliJ IDEA](https://www.jetbrains.com/idea/) (Community é gratuita)

---

## 🛠️ Extensões VSCode Recomendadas

Para melhor produtividade no desenvolvimento, instale as seguintes extensões no Visual Studio Code:

### Frontend (Angular)
1. **Angular Language Service** (Angular)
   - ID: Angular.ng-template
   - Suporte a templates Angular com autocompletar

2. **Angular Schematics** (Angular)
   - ID: cyrilletuzi.angular-schematics
   - Gera componentes, services, guards via interface visual

3. **TypeScript Vue Plugin (Volar)** (Vue author)
   - ID: Vue.vscode-typescript-vue-plugin
   - Melhor suporte a TypeScript

4. **ESLint** (Microsoft)
   - ID: dbaeumer.vscode-eslint
   - Identifica erros e padrões de código

5. **Prettier - Code formatter** (Prettier)
   - ID: esbenp.prettier-vscode
   - Formatação automática de código

6. **Bootstrap 5 Quick Snippets** (Abhishek Kumar)
   - ID: anmolmaheshwari.abhishek-vscode-bootstrap5-snippets
   - Snippets do Bootstrap 5

### Backend (Java/Spring Boot)
1. **Extension Pack for Java** (Microsoft)
   - ID: vscjava.vscode-java-pack
   - Inclui: Language Support for Java, Debugger for Java, Test Runner for Java, Maven for Java, Project Manager for Java, Visual Studio IntelliCode

2. **Spring Boot Extension Pack** (Microsoft)
   - ID: vmware.vscode-boot-dev-pack
   - Suporte a Spring Boot, Spring Cloud, Cloud Foundry, Kubernetes

3. **Spring Boot Dashboard** (vscode-spring-boot)
   - ID: vscjava.vscode-spring-boot-dashboard
   - Painel para gerenciar aplicações Spring Boot

4. **Lombok Annotations Support for VS Code** (GabrielBB)
   - ID: GabrielBB.little-fought-macro-intellisense
   - Se usar Lombok no projeto

### Banco de Dados
1. **SQL Server (mssql)** (Microsoft) - *Para SQL Server*
   - ID: ms-mssql.mssql
   - Gerenciador de SQL Server com IntelliSense

2. **MySQL** (cweijan)
   - ID: cweijan.vscode-mysql-client2
   - Gerenciador de MySQL com execução de queries

3. **Database Client** (cweijan)
   - ID: cweijan.vscode-database-client
   - Cliente universal para múltiplos bancos (MySQL, SQL Server, PostgreSQL)

### Utilitários
1. **REST Client** (Huachao Mao)
   - ID: humao.rest-client
   - Teste endpoints da API diretamente no VSCode

2. **Thunder Client** (Ranga Vadhineni)
   - ID: rangav.vscode-thunder-client
   - Alternativa ao Postman/Insomnia integrada no VSCode

3. **Git Graph** (mhutchie)
   - ID: mhutchie.git-graph
   - Visualização gráfica do Git

4. **GitLens** (Eric Amodio)
   - ID: eamodio.gitlens
   - Informações de blame, histórico de commits

5. **Markdown Preview Enhanced** (Yiyi Wang)
   - ID: shd101wyy.markdown-preview-enhanced
   - Preview melhorado de Markdown

### Instalação Rápida de Extensões
Cole este comando no VSCode (Ctrl+P) para cada ID:
```
ext install Angular.ng-template
ext install dbaeumer.vscode-eslint
ext install esbenp.prettier-vscode
ext install vscjava.vscode-java-pack
ext install ms-mssql.mssql
ext install cweijan.vscode-mysql-client2
ext install humao.rest-client
ext install mhutchie.git-graph
```

---

## 🚀 Instalação e Setup

### 1️⃣ Clonar o Repositório

```bash
git clone https://github.com/EduardoFernandes1002/MyGameList2.0.git
cd MyGameList2.0
```

### 2️⃣ Configurar o Banco de Dados

Escolha uma das opções abaixo:

#### ✅ Opção A: MySQL 8.0+ (Recomendado para Iniciantes)

**Instalação:**
1. [Baixar MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
2. Instalar com senha para root
3. [Baixar MySQL Workbench](https://dev.mysql.com/downloads/workbench/) (GUI recomendada)

**Criar banco de dados via MySQL Workbench ou CLI:**

```sql
-- Criar o banco de dados
CREATE DATABASE gamelist CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Acessar o banco
USE gamelist;

-- Verificar criação
SHOW DATABASES;
```

**Configuração no arquivo `backend/src/main/resources/application.properties`:**

```properties
# MySQL Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/gamelist?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=sua_senha_mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

---

#### ✅ Opção B: SQL Server 2019+ (Recomendado para Produção)

**Instalação:**

1. **Baixar SQL Server:**
   - [SQL Server 2022 Express](https://www.microsoft.com/sql-server/sql-server-downloads) (Grátis, até 10GB)
   - [SQL Server 2019 Developer](https://www.microsoft.com/sql-server/sql-server-downloads) (Grátis para desenvolvimento)

2. **Instalar SQL Server Management Studio (SSMS):**
   - [Baixar SSMS](https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms)

3. **Verificar instalação:**
   ```bash
   sqlcmd -S localhost\SQLEXPRESS -U sa -P sua_senha
   ```

**Criar banco de dados via SSMS ou T-SQL:**

```sql
-- Conectar ao servidor
USE master;

-- Criar banco de dados
CREATE DATABASE gamelist;

-- Usar o banco
USE gamelist;

-- Verificar criação
SELECT name FROM sys.databases WHERE name = 'gamelist';
```

**Configuração no arquivo `backend/src/main/resources/application.properties`:**

```properties
# SQL Server Configuration
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=gamelist;encrypt=true;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=sua_senha_sqlserver
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.SQLServer2012Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServer2012Dialect
```

**Adicionar dependência no `pom.xml`:**

```xml
<!-- Remova o driver MySQL se estiver usando SQL Server -->
<!-- Adicione: -->
<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>mssql-jdbc</artifactId>
    <version>12.4.1.jre11</version>
</dependency>
```

**Troubleshooting SQL Server:**

| Erro | Solução |
|------|---------|
| `Cannot open server 'localhost'` | Verificar se SQL Server Browser está iniciado (services.msc) |
| `Login failed for user 'sa'` | Confirmara senha ou resetar: `ALTER LOGIN sa ENABLE;` |
| `Connection refused on port 1433` | SQL Server pode estar desativado; iniciar via SSMS |
| `Named Pipes Provider: No such host` | Usar `localhost\SQLEXPRESS` ou `127.0.0.1` |

**Comparativo MySQL vs SQL Server:**

| Aspecto | MySQL | SQL Server |
|--------|-------|-----------|
| **Curva Aprendizado** | Fácil | Médio |
| **GUI Manager** | MySQL Workbench | SSMS (mais completo) |
| **Performance** | Muito bom | Excelente |
| **Relatórios** | Limitados | Reporting Services |
| **Custo** | Gratuito | Gratuito (Express/Developer) |
| **Produção** | ✅ Excelente | ✅✅ Muito melhor |

---

### 3️⃣ Configurar e Executar o Backend

```bash
# Navegue para a pasta backend
cd backend

# Limpar e compilar o projeto (primeiro build leva mais tempo)
mvn clean install

# Executar a aplicação Spring Boot
mvn spring-boot:run
```

**Resultado esperado:**
```
...
2025-05-18 10:30:00.000  INFO 1234 --- [           main] c.m.backend.BackendApplication        : Started BackendApplication in 5.234 seconds
2025-05-18 10:30:00.000  INFO 1234 --- [           main] o.s.b.w.e.tomcat.TomcatWebServer     : Tomcat started on port(s): 8080
```

O backend estará disponível em: **http://localhost:8080**

### 4️⃣ Configurar e Executar o Frontend

**Em um novo terminal**, na pasta raiz do projeto:

```bash
# Instalar dependências do Angular
npm install

# Iniciar o servidor de desenvolvimento
npm start
# OU
ng serve
```

**Resultado esperado:**
```
✔ Compiled successfully.
⠙ Building...
✔ Build complete. Watching for file changes...
...
○ Local:     http://localhost:4200/
```

O frontend estará disponível em: **http://localhost:4200**

---

## 🔍 Estrutura do Projeto

```
MyGameList2.0/
├── backend/                          # API Spring Boot
│   ├── src/main/java/               # Código fonte Java
│   ├── src/main/resources/          # Recursos (application.properties, etc)
│   ├── pom.xml                      # Dependências Maven
│   └── .gitignore
│
├── src/                              # Frontend Angular (Standalone)
│   ├── app/
│   │   ├── pages/                   # Páginas da aplicação
│   │   │   ├── geral/              # Páginas gerais (Home, Categoria, Ajuda)
│   │   │   ├── jogo/               # Páginas de jogos (Info, Rank, Discover)
│   │   │   └── usuario/            # Páginas de usuário (Login, Perfil, Config)
│   │   ├── component/              # Componentes reutilizáveis
│   │   ├── service/                # Serviços (API, Auth, etc)
│   │   ├── guard/                  # Route Guards (auth, admin)
│   │   ├── app.routes.ts           # Rotas da aplicação
│   │   └── app.config.ts           # Configuração Angular
│   ├── assets/                      # Imagens, ícones, etc
│   ├── styles.css                   # CSS global
│   └── index.html
│
├── angular.json                      # Configuração Angular CLI
├── tsconfig.json                     # Configuração TypeScript
├── package.json                      # Dependências npm
└── README.md                         # Este arquivo
```

---

## 📖 Rotas Principais da Aplicação

### Públicas (Sem autenticação)
- `/` - Home
- `/login` - Login de usuários
- `/registro` - Criação de conta
- `/rank` - Ranking de jogos
- `/categoria` - Categorias de jogos
- `/info/:nomeJogo` - Informações do jogo
- `/ajuda` - FAQ e Ajuda

### Protegidas (Requer autenticação)
- `/perfil/:nomeUsuario` - Perfil do usuário
- `/config/:nomeUsuario` - Configurações do usuário
- `/descoberta/:nomeJogo` - Descoberta de jogos

### Admin Only (Requer role "Administrador")
- `/recomendado` - Jogos recomendados
- `/admin` - Painel administrativo
- `/t3st3s` - Página de testes

---

## 🔐 Autenticação e Segurança

### Como Funciona
- **JWT (JSON Web Tokens)** para autenticação stateless
- **Token armazenado** no localStorage do navegador
- **Verificação automática** de permissões via Route Guards
- **Expiração de token**: 7 dias (604800000 ms)

### Configurar Chave Secreta JWT

Edite `backend/src/main/resources/application.properties`:

```properties
jwt.secret=SuaChaveSecretaForte1234567890!@#$%
jwt.expiration=604800000
```

> ⚠️ **Importante**: Em produção, use uma chave secreta forte e segura!

---

## 🛠️ Desenvolvimento

### Criar um Novo Componente Angular

```bash
# Na raiz do projeto frontend
ng generate component pages/novo-componente
# ou abreviado
ng g c pages/novo-componente
```

### Executar Testes

```bash
# Testes unitários
npm test
# ou
ng test

# Build de produção
npm run build
# ou
ng build --configuration production
```

### Scripts npm Disponíveis

```bash
npm start          # Inicia servidor dev (ng serve)
npm run build      # Build para produção
npm run watch      # Build em modo watch
npm test           # Executa testes Karma
```

---

## 🌐 Endpoints da API Backend

A API está disponível em `http://localhost:8080/api/`

### Exemplos de Endpoints:
- `GET /api/jogos` - Listar jogos
- `GET /api/jogos/:id` - Detalhes do jogo
- `POST /api/auth/login` - Login
- `POST /api/auth/register` - Registrar
- `GET /api/usuarios/:nomeUsuario` - Perfil do usuário
- `GET /api/ranking` - Ranking de jogadores

> Consulte a documentação da API ou explore os Controllers em `backend/src/main/java/`

---

## 🐛 Troubleshooting

### Erro: "Port 4200 is already in use"
```bash
# Usar uma porta diferente
ng serve --port 4201
```

### Erro: "Cannot find module '@angular/...'
```bash
# Reinstalar dependências
rm -rf node_modules package-lock.json
npm install
```

### Erro: "Connection refused" (MySQL/SQL Server)

**MySQL:**
```bash
# Windows: services.msc -> MySQL80 (ou similar)
# Linux: sudo systemctl start mysql
# macOS: brew services start mysql-server

# Testar conexão
mysql -u root -p
```

**SQL Server:**
```bash
# Windows: services.msc -> SQL Server (SQLEXPRESS) e SQL Server Browser
# Linux: sudo systemctl start mssql-server
# macOS: docker start sqlserver (se usar container)

# Testar conexão
sqlcmd -S localhost\SQLEXPRESS -U sa -P sua_senha
```

### Erro: "Cannot access 'localhost:8080'"
```bash
# Verificar se Java/Spring está compilado e rodando
# Confirme que Maven instalou as dependências
mvn clean install

# Verifique logs do Spring Boot
```

### JWT Token Expirado
```bash
# Clear localStorage e faça login novamente
# No console do navegador (F12 > Console):
localStorage.clear()
```

### Erro ao conectar com SQL Server: "Named Pipes Provider"
```bash
# Verificar se SQL Server Browser está rodando
# Windows: services.msc -> SQL Server Browser (SQLEXPRESS) -> Iniciar
# Tentar com IP: jdbc:sqlserver://127.0.0.1:1433
# Verificar porta (padrão: 1433): netstat -an | find "1433"
```

---

## 📦 Dependências Principais

### Frontend (Angular 19)
- **@angular/animations** - Animações
- **@angular/material** - Componentes Material Design
- **@angular/router** - Roteamento
- **bootstrap** - Framework CSS
- **swiper** - Carrosel de imagens
- **rxjs** - Programação reativa

### Backend (Spring Boot 3.5.3)
- **spring-boot-starter-web** - API REST
- **spring-boot-starter-data-jpa** - ORM
- **mysql-connector-java** ou **mssql-jdbc** - Driver banco de dados
- **jjwt** - Geração e validação de JWT

---

## 📝 Configurações Importantes

### `application.properties` (Backend - MySQL)
```properties
spring.application.name=backend
spring.datasource.url=jdbc:mysql://localhost:3306/gamelist?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
server.error.include-stacktrace=never
jwt.secret=MinhaChaveSecretaMuitoLonga1234567890
jwt.expiration=604800000
```

### `application.properties` (Backend - SQL Server)
```properties
spring.application.name=backend
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=gamelist;encrypt=true;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.SQLServer2012Dialect
server.error.include-stacktrace=never
jwt.secret=MinhaChaveSecretaMuitoLonga1234567890
jwt.expiration=604800000
```

### `angular.json` (Frontend)
- Porta padrão: **4200**
- Build output: `dist/my-game-list2.0/`
- CSS Framework: Bootstrap 5.3.3

---

## 🔄 Fluxo Típico de Desenvolvimento

1. **Inicie o Banco de Dados** - MySQL ou SQL Server deve estar rodando
2. **Execute o Backend** - `cd backend && mvn spring-boot:run`
3. **Execute o Frontend** - Em novo terminal: `npm start`
4. **Abra o navegador** - http://localhost:4200
5. **Desenvolva** - As mudanças recarregam automaticamente

---

## 📞 Suporte e Contribuição

Se encontrar problemas:
1. Verifique os logs (browser DevTools F12 e console do Spring Boot)
2. Confirme que todas as portas estão disponíveis (4200, 8080, 3306/1433)
3. Limpe cache/node_modules e reinstale
4. Abra uma issue no repositório

---

## 📄 Licença

Este projeto está sob a licença **MIT**. Veja o arquivo LICENSE para mais detalhes.

---

---

**Última atualização**: 18 de maio de 2026  
**Versão**: 1.1  
**Maintainer**: [EduardoFernandes1002](https://github.com/EduardoFernandes1002)
