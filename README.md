# **Sistema de Gestao de Vendas**  

---

## **1. Descrição do Projeto**  
Este projeto é um sistema de login e dashboard desenvolvido em Java, utilizando a arquitetura MVC (Model-View-Controller). O sistema permite que usuários se autentiquem com email e senha e, após a autenticação, sejam redirecionados automaticamente para um painel de controle (Dashboard) com funcionalidades específicas.  

---

## **2. Requisitos do Sistema**  

### **2.1 Requisitos Funcionais**  
- Autenticar usuários com base em email e senha.  
- Redirecionar para o Dashboard após login bem-sucedido.  
- Gerenciar menus e painéis dentro do Dashboard.  

### **2.2 Requisitos Não Funcionais**  
- Usar padrão MVC para organização do código.  
- Interface gráfica desenvolvida com Swing.  
- Logs integrados com SLF4J para depuração.  

---

## **3. Estrutura do Projeto**  

- **Modelo (Model)**  
  Contém as classes que representam os dados do sistema, como `Usuario`.  

- **Visão (View)**  
  Responsável pela interface gráfica, incluindo as telas de Login e Dashboard.  

- **Controlador (Controller)**  
  Gerencia a lógica do sistema, como autenticação e inicialização das telas.  

### **Principais Classes**  
1. **`Usuario`**  
   Representa os dados do usuário, como id, nome, email, senha, perfil e status.

2. **`Login`**  
   Tela inicial para entrada de email e senha.  

3. **`Dashboard`**  
   Painel principal exibido após login bem-sucedido.  

4. **`LoginControlador`**  
   Controlador que gerencia a lógica de autenticação e redirecionamento para o Dashboard.  

5. **`UsuarioServico`**  
   Contém a lógica de negócio relacionada ao usuário, como validação de login e busca por email.  

---

## **4. Configuração e Inicialização**  

### **4.1 Requisitos**  
- **Java 11+** instalado no sistema.  
- Dependências no `pom.xml` para SLF4J e outras bibliotecas.  

### **4.2 Passo a Passo para Inicialização**  
1. Clone o repositório do projeto no ambiente local.  
2. Importe o projeto em sua IDE de preferência (Ex: IntelliJ IDEA, Eclipse).  
3. Garanta que todas as dependências do Maven estejam instaladas.  
4. Compile o projeto para verificar erros.  

### **4.3 Execução**  
1. Localize a classe `Login` no pacote principal.  
2. Execute a classe `Login`.  
3. Informe suas credenciais de email e senha na interface do login.  
4. Após o login bem-sucedido, o `Dashboard` será exibido automaticamente.  

---

## **5. Fluxo do Sistema**  

### **5.1 Tela de Login**  
1. O sistema apresenta campos para email e senha.  
2. O botão de login dispara a verificação das credenciais.  
3. Caso as credenciais sejam válidas:
   - O Dashboard é iniciado.  
4. Caso as credenciais sejam inválidas:
   - Uma mensagem de erro é exibida.  

### **5.2 Dashboard**  
- Após o login, o painel principal exibe o menu e as funcionalidades associadas ao perfil do usuário.  
- Permite acesso a formulários e módulos adicionais via o método `setForm`.  

---

## **6. Log e Depuração**  

### **6.1 Integração com SLF4J**  
- Todos os logs do sistema estão configurados usando a biblioteca SLF4J.  
- Mensagens importantes, como status de login e inicialização do Dashboard, são registradas nos logs.  

### **6.2 Logs de Fluxo**  
Exemplos de logs gerados:  
- Sucesso ou falha na autenticação.  
- Inicialização do Dashboard.  
- Eventos de interação com painéis e menus.  

---

## **7. Pontos de Atenção**  

1. **Inicialização do Menu no Dashboard**  
   Certifique-se de que o menu foi inicializado corretamente para evitar `NullPointerException`.  

2. **Configuração do Painel Principal**  
   Valide que os componentes estão sendo adicionados ao painel principal com os métodos `add`, `repaint` e `revalidate`.  

3. **Exibição da Interface Gráfica**  
   Utilize a `SwingUtilities.invokeLater` para manipular componentes Swing de forma segura.  
