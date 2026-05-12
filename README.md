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
- **MySQL Server 8.0+**
  - [Baixar MySQL](https://dev.mysql.com/downloads/mysql/)
  - Recomendado: Use [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) como GUI

### Desenvolvedor (Opcional)
- **IDE para Frontend**: [Visual Studio Code](https://code.visualstudio.com/) ou similares
- **IDE para Backend**: [IntelliJ IDEA](https://www.jetbrains.com/idea/) (Community é gratuita)

---

## 🚀 Instalação e Setup

### 1️⃣ Clonar o Repositório

```bash
git clone https://github.com/EduardoFernandes1002/MyGameList2.0.git
cd MyGameList2.0
```

### 2️⃣ Configurar o Banco de Dados MySQL

#### Via MySQL Workbench ou MySQL CLI:

```sql
-- Criar o banco de dados
CREATE DATABASE gamelist;

-- Acessar o banco
USE gamelist;

-- Agora você pode executar os scripts SQL do projeto (se houver em backend/src/main/resources/sql/)
-- ou deixar o Hibernate criar as tabelas
```

**Configuração no arquivo `backend/src/main/resources/application.properties`:**

```properties
# Editar credenciais conforme seu MySQL local
spring.datasource.url=jdbc:mysql://localhost:3306/gamelist
spring.datasource.username=root
spring.datasource.password=sua_senha_aqui
```

> **Nota**: Se você não configurou senha para o usuário root do MySQL, deixe em branco.

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
2025-05-12 10:30:00.000  INFO 1234 --- [           main] c.m.backend.BackendApplication        : Started BackendApplication in 5.234 seconds
2025-05-12 10:30:00.000  INFO 1234 --- [           main] o.s.b.w.e.tomcat.TomcatWebServer     : Tomcat started on port(s): 8080
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

### Erro: "MySQL connection refused"
```bash
# Verificar se MySQL está rodando
# Windows: services.msc -> MySQL80 (ou similar)
# Linux: sudo systemctl start mysql
# macOS: brew services start mysql-server

# Testar conexão
mysql -u root -p
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
- **mysql-connector-java** - Driver MySQL
- **jjwt** - Geração e validação de JWT

---

## 📝 Configurações Importantes

### `application.properties` (Backend)
```properties
spring.application.name=backend
spring.datasource.url=jdbc:mysql://localhost:3306/gamelist
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=none        # update, create, none
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

1. **Inicie o MySQL** - Certifique-se que está rodando
2. **Execute o Backend** - `cd backend && mvn spring-boot:run`
3. **Execute o Frontend** - Em novo terminal: `npm start`
4. **Abra o navegador** - http://localhost:4200
5. **Desenvolva** - As mudanças recarregam automaticamente

---

## 📞 Suporte e Contribuição

Se encontrar problemas:
1. Verifique os logs (browser DevTools F12 e console do Spring Boot)
2. Confirme que todas as portas estão disponíveis (4200, 8080, 3306)
3. Limpe cache/node_modules e reinstale
4. Abra uma issue no repositório

---

## 📄 Licença

Este projeto está sob a licença **MIT**. Veja o arquivo LICENSE para mais detalhes.

---

## ✨ Próximos Passos Recomendados

- [ ] Configurar variáveis de ambiente em produção
- [ ] Implementar refresh token para maior segurança
- [ ] Adicionar HTTPS em produção
- [ ] Fazer backup regular do banco de dados
- [ ] Implementar rate limiting na API
- [ ] Adicionar testes e2e automatizados
- [ ] Implementar logging estruturado
- [ ] Configurar CI/CD (GitHub Actions, Jenkins, etc)

---

**Última atualização**: 12 de maio de 2026  
**Versão**: 1.0  
**Maintainer**: [EduardoFernandes1002](https://github.com/EduardoFernandes1002)
