# Sistema de Gerenciamento de Produtos com JDBC

### 📋 Descrição do Projeto

Aplicação de linha de comando para controle de estoque de produtos alimentícios e vestuários, com persistência em banco de dados MySQL. Implementa operações CRUD completas através de JDBC, seguindo princípios de programação orientada a objetos com herança e classes abstratas.

#### Componentes principais

- ConexaoDB.java: Classe utilitária para gerenciar conexões com o banco de dados
- Produto.java: Classe abstrata base com atributos e métodos comuns
- ProdutoAlimenticio.java: Classe concreta para produtos alimentícios
- ProdutoVestuario.java: Classe concreta para produtos de vestuário
- Main.java: Interface de linha de comando com menus interativos

#### Funcionalidades principais

- Cadastro de produtos alimentícios (com validade) e vestuários (com tamanho, cor e material)
- Cálculo automático de lucro (preço venda - preço custo)
- Operações CRUD completas para ambos os tipos de produtos
- Validação de entrada de dados
- Relatórios de produtos cadastrados

### 🔧 Pré-requisitos

- Java JDK 8 ou superior
- Banco de dados relacional (ex: MySQL, PostgreSQL, SQLite)
- Driver JDBC do MySQL (mysql-connector-java.jar)
- IDE Java (Eclipse, IntelliJ, etc.)

### 🚀 Instalação e execução

1. Clone o repositório:

```
git clone https://github.com/seu-usuario/CONEXAODB
```

2. Importe o projeto no Eclipse:
- File → Import → Existing Projects into Workspace
- Selecione a pasta do projeto clonado

3. Adicione o driver JDBC ao classpath do projeto.

4. Configure a URL de conexão, usuário e senha em ConexaoDB.java:
   
```
private static final String URL = "jdbc:mysql://localhost:3306/seu_banco";
private static final String USUARIO = "root"
private static final String SENHA = ""
```

5. Execute a classe Main.java e siga as instruções no terminal.

### 🛠️ Funcionalidades Implementadas

Sistema de menus hierárquico:
- Menu principal para escolha de categoria (alimentos/vestuários)
- Submenus com operações CRUD para cada categoria

Persistência com JDBC:
- Conexão gerenciada centralmente

Validações:
- Checagem de campos obrigatórios
- Tratamento de tipos de dados incorretos
- Verificação de IDs existentes para operações de atualização/exclusão

Relatórios:
- Listagem completa com formatação clara
- Exibição de cálculo de lucro

### 📝 Exemplo de saída

#### Interface Principal

![image](https://github.com/user-attachments/assets/52add69e-6ec8-4efd-9481-924ff0dd3878)
![image](https://github.com/user-attachments/assets/6fd96513-c2be-4fa7-a61b-6e178595a3f4)


#### Interface Principal dos Alimentos

![image](https://github.com/user-attachments/assets/f6b3158c-556b-46e8-bd2a-63583694e0a1)
![image](https://github.com/user-attachments/assets/dee93cb2-1104-4932-b604-be80be911e74)


#### Inserção de Alimento

![image](https://github.com/user-attachments/assets/361f79e3-41dd-4eab-bd45-2c311661eaa3)
![image](https://github.com/user-attachments/assets/beff292b-6ed8-4ae3-81bc-7247847263a5)


#### Atualização de Alimento

![image](https://github.com/user-attachments/assets/9f0402a1-17ac-4573-ae43-e3912acb3f91)
![image](https://github.com/user-attachments/assets/ab4f308c-9dfa-4d88-98ea-1eedc8359709)


#### Leitura de registros de Alunos
  
![image](https://github.com/user-attachments/assets/1479b127-0a82-43c3-9936-cec477754665)
![image](https://github.com/user-attachments/assets/ab4f308c-9dfa-4d88-98ea-1eedc8359709)


#### Remoção de Alimento

![image](https://github.com/user-attachments/assets/ccde9f64-572c-4b12-a304-65354e96e13b)
![image](https://github.com/user-attachments/assets/c4d731ec-ccda-4f0b-913b-50412b710483)


#### Sair

![image](https://github.com/user-attachments/assets/d2050ce2-1a95-4aa0-b870-3a1a5123c8c0)



#### Interface Principal dos Vestuários

![image](https://github.com/user-attachments/assets/e671271e-8b32-4f11-9a6b-6048c14bdf2f)
![image](https://github.com/user-attachments/assets/08ab1af4-f436-4352-909a-ca588a747120)


#### Inserção de Vestuário

![image](https://github.com/user-attachments/assets/e00a564e-c42d-4b61-a739-d1f97d69cd37)
![image](https://github.com/user-attachments/assets/df11f8e2-9308-4997-9e27-f27d46b8a381)


#### Atualização de Vestuário

![image](https://github.com/user-attachments/assets/1fe5cdec-c728-4585-b628-bc61563d3df2)
![image](https://github.com/user-attachments/assets/070468bd-78f0-4432-940f-28242e89de69)


#### Leitura de Registros de Vestuário

![image](https://github.com/user-attachments/assets/fa8b9e21-a812-4e39-ada3-4b7b22bc32b6)
![image](https://github.com/user-attachments/assets/df11f8e2-9308-4997-9e27-f27d46b8a381)


#### Remoção de Vestuário

![image](https://github.com/user-attachments/assets/71f1536c-a592-4c6b-8d66-9917d1a2c2fc)
![image](https://github.com/user-attachments/assets/0a3eb14c-c38c-4fbf-a4b7-a72f4fe89371)


#### Sair

![image](https://github.com/user-attachments/assets/5f018594-3f85-4e09-9cda-5f1dda1d3a9b)


## ✒️ Autores

* **Mateus Franco Bezerra** - *Trabalho Inicial* - CONTROLE_PRODUTOS
