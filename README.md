# controle-financeiro-java
Projeto pessoal para gerenciamento de receitas e despesas usando Java + Spring Boot + MySQL.

# 📊 Sistema de Controle Financeiro

Este é um projeto desenvolvido com o objetivo de organizar receitas, despesas e gerar relatórios mensais automatizados. Mais que um simples CRUD, o sistema oferece geração de relatórios em PDF estilizados, integração com banco de dados e exibição dinâmica via Thymeleaf.

---

## ⚙️ Funcionalidades

- ✅ Cadastro e listagem de receitas e despesas
- 📅 Geração de relatório mensal por ano/mês
- 🧾 Simulador de relatório com dados fictícios
- 📄 Exportação de relatório em PDF com design personalizado
- 🎨 Interface HTML estilizada e responsiva
- 🛠️ Integração com Thymeleaf e OpenHTML to PDF

---

## 🔧 Tecnologias utilizadas

- Java 17
- Spring Boot 3.5.3
- Thymeleaf
- Maven
- Flying Saucer (OpenHTML to PDF)
- MySQL
- Lombok

---

## 🚀 Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuUsuario/controle-financeiro.git


2. Configure o banco de dados MySQL:

Crie um schema chamado controlefinanceiro

Ajuste o application.properties com suas credenciais

3. Rode o projeto com Maven:

bash
mvn clean install
mvn spring-boot:run

4. Acesse no navegador:

Relatório do mês: http://localhost:8080/relatorio/view/2025/07

Simulação de relatório: http://localhost:8080/relatorio/view/simulado

Exportar PDF: http://localhost:8080/relatorio/view/pdf/2025/07


🌱 Aprendizados e desafios
Durante o desenvolvimento, enfrentei desafios como:

Integração de bibliotecas externas para geração de PDF

Tratamento de erros complexos com Thymeleaf e XML

Estilização compatível com HTML renderizável por motores PDF

Uso de DTOs e templates reutilizáveis para simulação e dados reais

Este projeto me ajudou a consolidar conhecimentos em backend Java com Spring, arquitetura de templates e exportação de arquivos, além de fortalecer habilidades na depuração e resolução de problemas.

## 📷 Imagens

### 🔍 Visualização no navegador

![Relatório HTML](.assets/)
![Relatório HTML](./controlefinanceiro/src/main/java/com/joseane/controlefinanceiro/assets/Captura%20de%20tela%202025-07-12%20144530.png)
![](./)

### 📄 PDF gerado

![Relatório PDF](./controlefinanceiro/src/main/java/com/joseane/controlefinanceiro/assets/Captura%20de%20tela%202025-07-12%20144538.png)
