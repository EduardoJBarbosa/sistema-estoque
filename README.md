# Sistema de Controle de Estoque
Projeto real desenvolvido para o programa **genAI - iFood** | Java + Spring Boot + SQL (JPA / H2)

## O que faz
- Cadastro de produtos (nome, categoria, preço, estoque mínimo)
- Entrada e saída de estoque com regra de negócio: saída não deixa o saldo ficar negativo
- Alerta de produtos abaixo do estoque mínimo
- API REST pronta para testar no Postman / Insomnia

## Como rodar
```bash
mvn spring-boot:run
# API em http://localhost:8080/api/produtos
# Console H2 em http://localhost:8080/h2-console (JDBC: jdbc:h2:mem:estoquedb, user: sa)
```

## Exemplos
```bash
# Criar
curl -X POST http://localhost:8080/api/produtos -H "Content-Type: application/json" -d '{"nome":"Arroz 5kg","categoria":"Alimentos","quantidade":10,"preco":29.90,"estoqueMinimo":5}'
# Entrada
curl -X POST "http://localhost:8080/api/produtos/1/entrada?qtd=5"
# Saída
curl -X POST "http://localhost:8080/api/produtos/1/saida?qtd=2"
# Alerta
curl http://localhost:8080/api/produtos/alerta/abaixo-do-minimo
```

## Como usei IA generativa neste projeto
Usei LLMs (ChatGPT / Gemini / Copilot) como par de programação para: modelar a entidade, revisar a regra de saída de estoque, gerar cenários de teste e melhorar a documentação. O código final foi revisado e entendido por mim — consigo explicar cada decisão na entrevista.

## Autor
Eduardo de Jesus Barbosa — Sistemas de Informação
