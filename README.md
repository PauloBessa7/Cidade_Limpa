# Cidade Limpa

## 📝 Sobre o Projeto

O "Cidade Limpa" é um sistema de chamados projetado para que qualquer pessoa possa registrar ocorrências de lixos em sua cidade. A plataforma permite que os usuários informem o local do incidente (bairro e rua), com a opção de adicionar o número do endereço para maior precisão, respeitando a privacidade de quem reporta.

O sistema lista todas as ocorrências abertas, permitindo que outros usuários interajam por meio de um botão de "gostei". Essa funcionalidade serve como um sistema de ranqueamento, destacando os chamados mais relevantes para a comunidade. Quando uma solicitação é atendida e o problema resolvido, o status da ocorrência pode ser alterado para "concluído".

---

## 🛠️ Tecnologias Utilizadas

O projeto foi construído com as seguintes tecnologias:

* **Backend:** Java 17 com Spring Boot, Spring Web, Spring Data JPA e Maven.
* **Banco de Dados:** H2 Database (em memória).
* **Frontend:** HTML5, CSS3 e JavaScript.

---

## Endpoints da API

A API REST do projeto segue a arquitetura stateless e expõe os seguintes endpoints, todos a partir da base `/ocorrencias`:

| Método HTTP | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/` | Retorna uma lista com todas as ocorrências registradas, ordenadas pela quantidade de curtidas em ordem decrescente. |
| `GET` | `/{id}` | Busca e retorna uma ocorrência específica pelo seu ID. |
| `POST` | `/` | Cria uma nova ocorrência com base nos dados enviados no corpo da requisição. |
| `PATCH` | `/{id}/curtir` | Adiciona um "gostei" (incrementa o contador de curtidas) a uma ocorrência específica. |
| `PATCH` | `/{id}/concluir` | Altera o status de uma ocorrência para "concluído". |

---

## 📂 Estrutura de Pastas

O projeto está organizado em duas pastas principais: `backend` e `frontend`.

```
cidade.limpa/
├── backend/
│   └── cidade.limpa/
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/
│       │   │   │   └── com/cidade/limpa/
│       │   │   │       ├── configs/
│       │   │   │       │   └── CorsConfig.java
│       │   │   │       ├── controller/
│       │   │   │       │   └── OcorrenciaController.java
│       │   │   │       ├── model/
│       │   │   │       │   └── OcorrenciaModel.java
│       │   │   │       ├── repository/
│       │   │   │       │   └── OcorrenciaRepository.java
│       │   │   │       ├── service/
│       │   │   │       │   └── OcorrenciaService.java
│       │   │   │       └── Application.java
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   └── test/
│       │       └── java/com/cidade/limpa/
│       │           └── ApplicationTests.java
│       ├── pom.xml
│       └── HELP.md
└── frontend/
    ├── cidade_limpa.html
    ├── style.css
    └── app.js
```
---
## Imagens do projeto

![image](https://github.com/user-attachments/assets/f754d33e-625b-4b76-9710-f92e8edd9190)

![image](https://github.com/user-attachments/assets/494ace20-c623-4cfd-8551-51857c2223fb)

![image](https://github.com/user-attachments/assets/c8101e82-faed-484d-97cc-9ace2164f2f3)

