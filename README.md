# Desafio DBServer - Prova para alinhamento de conhecimentos em automação de testes
## Testes automatizados API

Estes *Script* foi desenvolvido para a prova de testes automatizados da mentoria da **DBserver**, tem por objetivo testar e validar casos de uso para a API [**ViaCEP**](https://viacep.com.br/)

### PRÉ REQUISITOS

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas ou dependências:

* [Git](https://git-scm.com)
* [Java](https://www.java.com/pt-BR/)
* [JDK](https://www.oracle.com/java/technologies/downloads/)
* [JUnit 5](https://junit.org/junit5/)
* [Maven](https://maven.apache.org/)

Além disto é bom ter uma IDE Java para trabalhar com o código como por exemplo o [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/) ou [Ecplipse](https://www.eclipse.org/downloads/) dentre outras.

### EXECUÇÃO
#### Classes
* Abra o projeto "nivelamento_db_p2"
* Navegar até o pacote src/test/java/testCases/viaCep
#### Teste consultar CEP válido
* Na classe *TestsCepValido* clicar com o botão direito
* Clicar no menu "Run TestsCepValido
#### Teste consultar CEP Invalido
* Na classe *TestsCepInvalido* clicar com o botão direito
* Clicar no menu "Run TestsCepInvalido
#### Teste consultar CEP Inexistente
* Na classe *TestsCepInexistente* clicar com o botão direito
* Clicar no menu "Run TestsCepInexistente

#### Rodar vários
* É possível também rodar todos os testes
* Navegar até o pacote src/teste/java/testCases/viaCep
* No pacote *testCases* clicar com o botão direito
* Clicar na opção "Run 'Tests' in 'testCases.viaCep'"

### RETORNO
* Para o teste de CEP Válido, após a execução do mesmo será criado um arquivo no seguinte caminho:
* src/main/resources/properties/ReturnOfGetCepValido.properties
* Neste arquivo poderá ser consultado o retorno da solicitação de um cep válido.

### CENÁRIOS DE TESTE

#### Cenário 1: Consulta CEP Válido
* Passo 1: **Dado que** o usuário insere um CEP válido \
* Passo 2: **Quando** o serviço é consultado \
* Passo 3: **Então** é retornado o CEP, logradouro, complemento, bairro, localidade, uf e ibge

#### Cenário 2: Consulta CEP Inexistente
* Passo 1: **Dado** que o usuário insere um CEP que não exista na base dos Correios \
* Passo 2: **Quando** o serviço é consultado \
* Passo 3: **Então** é retornado um atributo erro

#### Cenário 3: Consulta CEP com formato inválido
* 1 **Dado que** o usuário insere um CEP com formato inválido \
* 2 **Quando** o serviço é consultado \
* 3 **Então** é retornado uma mensagem de erro (HTML)