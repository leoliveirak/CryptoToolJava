# CryptoTool: Kit de Ferramentas Criptográficas em Java

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Bouncy Castle](https://img.shields.io/badge/Bouncy%20Castle-4CAF50?style=for-the-badge&logo=data:image/svg+xml;base64,PHN2ZyB2aWV3Qm94PSIwIDAgMjQgMjQiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+PHBhdGggZD0iTTcuNjQyIDcuNjg1QzguMDE1IDcuNTQyIDguNzY0IDcuMzUzIDkuMDM2IDcuMzA5QzkuMzUgNy4xNTYgOS42NjcgNy4wMTcgOS45NTcgNi44MTNjMTAuMzU0IDYuNjEgMTAuODU0IDYuNDUyIDExLjI5NiA2LjMyQzEyLjA2MiA2LjAyNyAxMi42MjEgNS44MzQgMTMuMDg1IDUuNjEzQzEzLjgwNSA1LjM5MiAxNC42NDUgNS4wOTQgMTUuMjk4IDQuNzQ4QzE2LjA0NiA0LjQwMiAxNi44MzMgNC4wMzggMTcuNTM4IDMuNjQ1QzE4LjIyMSA2LjAyMiAxOS4xMDcgNi43NTUgMTkuOTUzIDcuNDM0QzIwLjI1OCA3LjcwOCAyMC42MzYgOC4wNDQgMjAuOTQxIDguMjgxQzIxLjIxOCA4LjQ5NiAyMS40NDQgOC42NjkgMjEuNTYzIDguNzM5QzIxLjk3MiA5LjAyIDIyLjM3IDkuMzcgMjIuNzE1IDkuNzMzQzIyLjcwNiA4LjA4OSAyMi44MDggNi44ODUgMjIuNzA2IDUuNjczQzIzLjE5MyA1LjI2MiAyMyuNzQ0IDQuODczIDI0LjI1IDQuNDczQzIxLjM5NCAzLjkxNyAxOS4yMjcgMy40MjggMTcuNDEzIDIuODY4QzE1LjY3IDIzNTcgMTQuMTU1IDEuODE5IDEyLjM0MSAxLjI3NkMxMS4zOTEgMC45MzUgMTAuMzU4IDAuNjczIDkuNDEwLjUzM0M4LjQ2MSAwLjM3IDcuMzg1IDAuMjc2IDYuNDE4IDAuNDE3QzQuNTk0IDAuODY2IDAuNzc2IDEuNDY4IDEuMDE0IDIuMTk1QzEuNDYgMS42OTEgMS45NzkgMS4zMDEgMi41MjUgMC45ODNDMi4xMTIgMS44NDIgMS40NTIgMi42MDMgMC42OTYgMy4zMzZDMi4xOTMgMy43MzcgLTAuNSAzLjcyNyAtMC44NzUgNC42NzRDMS4wMTggNS41MiAyLjU0MiA2LjA5NSAzLjg5NiA2Ljc2RDYuMjUuNDMzIDYuNDI5IDcuMDk0IDcuNjQyIDcuNjg1TNNy43OTggMTkuMDk4QzcuNzU1IDE5LjU0NiA3Ljc0MSAxOS44NTggNy43MDEgMjAuMTQ3QzcuNjggMjAuNDc4IDcuNjUyIDIwLjc1MiA3LjY0MiAyMS4wMDhDNy40ODUgMjEuMDM4IDcuNDA2IDIxLjE2IDcuMzM1IDIxLjMxNEM3LjA3MyAyMS44MyA2Ljc5MiAyMi4yNzEgNi40NTMgMjIuNzk3QzYuMDQyIDIyLjk3NSA1LjU4OSAyMy4wOTYgNS4wNzUgMjMuMTg0QzQuNjc0IDIyLjczOCAzLjk5NSAyMi4yMzIgMy4zMzcgMjEuODUzQzIuODQzIDIxLjUyNiAyLjMwNyAyMS4yOTcgMS43NDUgMjAuOTk5QzEuNDU2IDIwLjcyMiAxLjE4MyAyMC40MjcgMC45MTMgMjAuMTE3QzAuNjk5IDE5LjgyOCAwLjQ3OCAxOS41NjggMC4zMDcgMTkuMzNDMC4zMjIgMTguMjk0IDAuMTM3IDE2Ljk1NiAwLjEyNiAxNS41OTZDMi40NzIgMTUuMjc3IDAuODUyIDE0Ljk0IDEuMTk4IDE0LjY0NUMxLjU3IDE4LjUyNSAyLjE2NyAxOC45MjcgMi44OTEgMTkuNDE4QzMuNTg4IDE5LjkwMSAzNC41NCAyMC4yNzIgNS41NjIgMjAuNDEzQzYuNTg0IDIwLjU3MSA3LjE0NSAyMC4wOSAyMi43OTggMTkuMDk4TDE1LjI5OCAxOC4yQzE1LjIyMSAxOS42OTMgMTUuMjk5IDIxLjA1NSAxNS4yNzcgMjIuMzcyQzE1LjcwMyAyMi43MjYgMTYuMTk3IDIzLjA2MiAxNi42NjMgMjMuMzcxQzE3LjE2NSAyMi44NjYgMTcuNzYgMjIuMjk3IDE4LjMyIDIxLjcyOUMxOC44OTcgMjEuMDgxIDE5LjQ2MiAyMC40MyAxOS45MDMgMTkuOTIyQzIwLjY5MiAxOS4wNDMgMjEuNDU5IDE4LjE4NiAyMi4wNTYgMTcuMjEzQzIyLjQ4MyAxNi40NjggMjIuNzQ4IDE1LjQ4NyAyMi43NDggMTQuNDA5QzIyLjc0OCAxMy40NzkgMjIuNTk1IDEyLjU5NCAyMi4zMjQgMTEuOTg1QzIxLjk3OSAxMS4xMzYgMjEuNDQ4IDEwLjUyNSAyMC42ODYgOS44NjVMMTUuMjk5IDEwLjUyNEMxNS4xMjggMTEuMDMgMTUuMDM1IDExLjUzIDE0Ljk2MiAxMi4wMjRMMTAuMTE4IDEyLjIyMkM5LjgyOSAxMi4zNTcgOS43MjIgMTIuNDkgOS41NzcgMTIuNjYyTDQuNzgxIDEyLjgxNkM0LjIxOCAxMi42ODIgMy41NzMgMTIuNTUgMy4xNSAxMi40MDlDMi40MDggMTIuMjkgMS42MDcgMTIuMDYyIDAuODQ3IDExLjgyMThMMi4zNDkgMTAuODQ4QzIuMzA3IDEwLjM1NCAzLjM2MyA5Ljk4IDQuNDczIDkuNjUyQzcuMjI5IDkuMDI3IDkuODI5IDguNzk4IDEyLjQ3NiA4Ljg0MkMyMC4xMDkgMTYuMjM4TDIyLjY0NCAxNC44MkMyMi42NDQgMTQuNjU4IDIyLjU1NyAxNC40OTkgMjIuNDQ2IDE0LjI5NUMyMy4xNjUgMTQuMDkyIDIzLjczIDEzLjg1NiAyNC4yMDkgMTMuNjE2TDI0LjIwOSAxMi42ODNDMjMuNTI4IDEzLjI3NCAyMi45NjUgMTMuNTMgMjIuNDAzIDEzLjczNUMyMi4xOTMgMTIuMzU5IDIyLjA2MiAxMS4wOCAyMi4xNzkgMTAuMDYyQzIxLjY2NiA5LjYxOCAyMS4yMTIgOS4yNTEgMjAuNjY3IDguODg2QzIwLjM4OSA4LjQ5NyAxOS43MzcgOC4xMjEgMTkuMDk5IDcuNjQ2QzcuNjQyIDcuNjg1IDcuNzk4IDE5LjA5OHoiLz48L3N2Zz4=)](https://www.bouncycastle.org/)
[![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)](https://git-scm.com/)

---

## Descrição

O `CryptoTool` é uma aplicação de linha de comando desenvolvida em Java que oferece um conjunto básico de funcionalidades criptográficas. Este projeto serve como uma demonstração prática de conceitos fundamentais em segurança da informação, incluindo hashing e criptografia simétrica (AES), com uma ênfase na integração da robusta biblioteca **Bouncy Castle**.

Este projeto visa praticar Java, Git, conceitos de segurança da informação e a capacidade de integrar bibliotecas externas para fins criptográficos.

## Funcionalidades

O `CryptoTool` permite ao usuário realizar as seguintes operações através de uma interface de linha de comando interativa:

1.  **Gerar Hash SHA-256 de Texto:** Calcula o hash SHA-256 de uma string de texto fornecida pelo usuário. Ideal para verificar a integridade de pequenas mensagens ou dados.

2.  **Gerar Hash SHA-256 de Arquivo:** Calcula o hash SHA-256 de um arquivo especificado pelo caminho. Essencial para verificar a integridade de arquivos após download ou transmissão.

3.  **Gerar Chave AES e IV:** Gera uma chave secreta AES de 256 bits e um Vetor de Inicialização (IV) aleatório de 16 bytes. Ambos são apresentados em formato Base64 para fácil uso em operações de criptografia/descriptografia.

4.  **Criptografar Texto AES:** Criptografa uma string de texto fornecida pelo usuário usando uma chave AES e um IV. O texto cifrado resultante é exibido em Base64.

5.  **Descriptografar Texto AES:** Descriptografa uma string de texto cifrado (em Base64) usando a chave AES e o IV correspondentes, restaurando o texto plano original.

## Conceitos Criptográficos Implementados

Este projeto aborda os seguintes conceitos e tecnologias criptográficas:

* **Hashing (SHA-256):** Utiliza o Secure Hash Algorithm 256 bits para gerar *digests* de tamanho fixo. O hashing é uma função unidirecional usada para verificar a integridade dos dados, garantindo que não foram alterados.

* **Criptografia Simétrica (AES):** Implementa o Advanced Encryption Standard (AES) para garantir a confidencialidade dos dados. AES é um algoritmo de criptografia em bloco amplamente reconhecido e seguro.

* **Modo de Operação CBC (Cipher Block Chaining):** Utilizado com o AES, o CBC encadeia os blocos cifrados, tornando cada bloco de texto cifrado dependente de todos os blocos de texto plano anteriores. Isso aumenta a segurança ao prevenir ataques baseados em padrões repetitivos.

* **Vetor de Inicialização (IV):** Um valor aleatório (não secreto) usado apenas uma vez com uma dada chave em modos de operação como CBC. Garante que a criptografia do mesmo texto plano com a mesma chave produza textos cifrados diferentes, aumentando a robustez do sistema.

* **Padding (PKCS7Padding):** Esquema de preenchimento que assegura que o texto plano tenha um tamanho múltiplo do tamanho do bloco do algoritmo (16 bytes para AES), adicionando bytes extras conforme necessário antes da criptografia e removendo-os após a descriptografia.

* **Java Cryptography Architecture (JCA):** O framework da plataforma Java para criptografia. O `CryptoTool` interage com a JCA para acessar os serviços criptográficos de forma agnóstica à implementação.

* **Bouncy Castle:** Uma biblioteca criptográfica de código aberto que atua como um provedor JCA. Sua inclusão no projeto demonstra familiaridade com uma ferramenta de segurança robusta e fornece implementações adicionais de algoritmos e padrões, como o `PKCS7Padding` preferencialmente utilizado aqui.

## Tecnologias Utilizadas

* **Java:** Linguagem de programação principal utilizada.

* **Java Development Kit (JDK) 17:** Ambiente de desenvolvimento para Java.

* **Bouncy Castle (bcprov-jdk18on-1.81.jar):** Biblioteca de criptografia externa para prover funcionalidades adicionais e robustas.

* **Git:** Sistema de controle de versionamento utilizado para gerenciar o código-fonte.

* **GitHub:** Plataforma de hospedagem de repositórios Git.

* **Visual Studio Code:** IDE utilizada para o desenvolvimento.

## Como Configurar e Executar o Projeto

Siga os passos abaixo para configurar e rodar o `CryptoTool` em seu ambiente.

### Pré-requisitos

* **Git Instalado:** Verifique com `git --version`. Se não tiver, baixe em [git-scm.com](https://git-scm.com/).
* **Java Development Kit (JDK) 17:** Certifique-se de ter o JDK 17 instalado e configurado em suas variáveis de ambiente. Verifique com `java -version` e `javac -version`.

### Clonagem do Repositório

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/leoliveirak/CryptoToolJava.git
    ```

2.  **Navegue para o diretório do projeto:**
    ```bash
    cd CryptoToolJava
    ```

### Compilação e Execução

Você pode compilar e executar o projeto via linha de comando ou através do VS Code (com a "Extension Pack for Java").

#### Opção A: Linha de Comando (Terminal)

1.  Abra seu terminal e navegue até a pasta raiz do projeto (`CryptoToolJava`).

2.  **Compile o programa:**
    * **Windows:**
        ```bash
        javac -cp ".;lib\bcprov-jdk18on-1.81.jar" src\CryptoTool.java
        ```
    * **Linux/macOS:**
        ```bash
        javac -cp ".:lib/bcprov-jdk18on-1.81.jar" src/CryptoTool.java
        ```

3.  **Execute o programa:**
    * **Windows:**
        ```bash
        java -cp ".;lib\bcprov-jdk18on-1.81.jar;src" CryptoTool
        ```
    * **Linux/macOS:**
        ```bash
        java -cp ".:lib/bcprov-jdk18on-1.81.jar:src" CryptoTool
        ```

#### Opção B: Visual Studio Code

1.  Certifique-se de ter a **"Extension Pack for Java"** instalada no VS Code.

2.  Abra a pasta `CryptoToolJava` no VS Code (`File > Open Folder...`).

3.  O VS Code geralmente detecta automaticamente os JARs na pasta `lib`. Se não, abra a Paleta de Comandos (`Ctrl+Shift+P`), digite `Java: Configure Classpath`, e adicione o JAR `bcprov-jdk18on-1.81.jar` da pasta `lib`.

4.  No arquivo `CryptoTool.java`, clique no ícone "Run" (triângulo verde) acima do método `main`, ou clique com o botão direito no arquivo e selecione "Run Java".

5.  A saída interativa do programa aparecerá no painel "TERMINAL" do VS Code.

## Exemplos de Uso

1.  **Gerar Chave AES e IV (Opção 3):**
    ```
    Your choice: 3
    Generated AES Key: [UMA CHAVE BASE64 AQUI]
    Generated IV (Base64): [UM IV BASE64 AQUI]
    You can use these keys for AES encryption/decryption.

    Guarde a chave e o IV para criptografar/descriptografar!

    ```

2.  **Criptografar Texto AES (Opção 4):**
    * (Usando a chave e IV gerados acima)
    ```
    Your choice: 4
    Text to encrypt: Meu texto secreto
    Enter AES Key (Base64): [COLE A CHAVE GERADA]
    Enter IV (Base64): [COLE O IV GERADO]
    Encrypted Data (Base64): [TEXTO CIFRADO EM BASE64]

    ```

3.  **Descriptografar Texto AES (Opção 5):**
    * (Usando o texto cifrado, chave e IV gerados/usados acima)
    ```
    Your choice: 5
    Text to decrypt: [COLE O TEXTO CIFRADO]
    Enter AES Key (Base64): [COLE A CHAVE GERADA]
    Enter IV (Base64): [COLE O IV GERADO]
    Decrypted Data: Meu texto secreto

    ```

4.  **Gerar Hash SHA-256 de Texto (Opção 1):**
    ```
    Your choice: 1
    Enter the text to hash using SHA-256:
    Ola mundo
    SHA-256 Hash: ac47e6feab59506ec30a67f51f3c7bdabbd37ed0332713f277fc3da956bf779d

    ```

5.  **Gerar Hash SHA-256 de Arquivo (Opção 2):**
    * (Crie um arquivo `test.txt` na raiz do seu projeto com algum conteúdo, ex: "Este eh um arquivo de teste.")
    ```
    Your choice: 2
    Enter the file path to hash using SHA-256: teste.txt
    SHA-256 Hash of file: [HASH DO ARQUIVO teste.txt]

    ```

## O que Aprendi

Ao desenvolver o `CryptoTool`, aprofundei meu conhecimento em:

* **Fundamentos Criptográficos:** Reforcei a compreensão de funções hash criptográficas (SHA-256) e de criptografia simétrica (AES), incluindo modos de operação (CBC), a importância de Vetores de Inicialização (IVs) e esquemas de preenchimento (PKCS7Padding).

* **Java Cryptography Architecture (JCA):** Entendi como a JCA abstrai as implementações criptográficas e permite a integração de provedores de segurança.

* **Integração com Bouncy Castle:** Ganhei experiência prática na adição e utilização de uma biblioteca de criptografia de terceiros (Bouncy Castle) em um projeto Java, entendendo seu papel em prover algoritmos e funcionalidades não padrão.

* **Desenvolvimento de Ferramentas CLI:** Pratiquei a criação de uma interface de linha de comando interativa para utilitários, incluindo a manipulação de entrada/saída do usuário e tratamento de exceções.

* **Gerenciamento de Versão com Git:** Reforcei as práticas de commit incrementais e significativos, mantendo um histórico de projeto limpo e organizado.

## Próximos Passos (Potenciais Melhorias)

* Adicionar funcionalidades de criptografia assimétrica (RSA) para geração de pares de chaves, assinatura digital e verificação.

* Implementar a criptografia e descriptografia direta de arquivos (não apenas hashes).

* Adicionar suporte para outros algoritmos de hash (SHA-512, MD5) e cifras simétricas.

* Explorar a dockerização da aplicação para facilitar o deploy e o ambiente de execução.

* Desenvolver uma interface gráfica de usuário (GUI) simples para a ferramenta.

## Autor

**Leonardo Klitzke**
