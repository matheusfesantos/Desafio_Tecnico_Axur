# Analisador de HTML - Desafio Técnico Axur

Este projeto foi desenvolvido como parte do **desafio técnico** para a vaga de **Software Development Intern** na [Axur](https://axur.com/). O programa analisa o conteúdo HTML de uma URL e retorna o texto no nível mais profundo da estrutura HTML.

---

## Sobre o Desafio

O desafio consistia em desenvolver um programa em Java que, a partir de uma URL, obtivesse o trecho de texto contido no nível mais profundo da estrutura HTML. O programa deve seguir requisitos específicos, como não utilizar bibliotecas externas e ser executado via linha de comando.

---

## Funcionalidades

- **Análise de HTML**:
  - O programa acessa o conteúdo HTML de uma URL e identifica o texto no nível mais profundo da estrutura.
  - Exemplo:
    - Para o HTML:
      ```html
      <html>
        <head>
          <title>
            Este é o título.
          </title>
        </head>
        <body>
          Este é o corpo.
        </body>
      </html>
      ```
    - A saída será: `"Este é o título."`.

- **Tratamento de Erros**:
  - Se a URL for inválida ou houver falha na conexão, o programa retorna:
    ```
    URL connection error
    ```

- **Detecção de HTML Mal-formado (Opcional)**:
  - O programa pode identificar estruturas HTML mal-formadas (tags sem fechamento, por exemplo) e retornar a mensagem:
    ```
    malformed HTML
    ```

---

## Como Executar

### Requisitos
- **JDK 17**: Certifique-se de ter o Java Development Kit (JDK) versão 17 instalado.
- **Conexão com a Internet**: O programa acessa URLs para obter o conteúdo HTML.

### Passos
1. **Compilar o Programa**:
   - Navegue até o diretório onde o arquivo `HtmlAnalyzer.java` está localizado.
   - Execute o seguinte comando para compilar o código:
     ```bash
     javac HtmlAnalyzer.java
     ```

2. **Executar o Programa**:
   - Execute o programa passando uma URL como argumento:
     ```bash
     java HtmlAnalyzer <URL>
     ```
   - Exemplo:
     ```bash
     java HtmlAnalyzer http://hiring.axreng.com/internship/example1.html
     ```

---

## Exemplo de Uso

### Entrada:
```bash
java HtmlAnalyzer http://hiring.axreng.com/internship/example1.html
```

### Saída:
```
Este é o título.
```

---

## Estrutura do Código

O programa foi desenvolvido em Java e segue uma abordagem simples e direta para analisar o HTML. Aqui estão os principais componentes:

1. **Conexão com a URL**:
   - Usa `java.net.URL` e `java.net.HttpURLConnection` para acessar o conteúdo da URL.

2. **Leitura do HTML**:
   - Lê o conteúdo HTML linha por linha usando `BufferedReader`.

3. **Análise de Profundidade**:
   - Mantém um contador de profundidade para rastrear o nível de aninhamento das tags.
   - Armazena o texto no nível mais profundo encontrado.

4. **Tratamento de Erros**:
   - Captura exceções relacionadas a falhas de conexão ou leitura e exibe mensagens adequadas.

---