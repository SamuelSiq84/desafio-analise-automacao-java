#language: pt
#encoding: utf8
Funcionalidade: Login no Ecommerce Fake
  Como um cliente gostaria de ir na página de autenticação insiro e-mail e clico no botão create account
  e ao logar digito e-mail e senha e clico no botão sign in, caso digito e-mail inválido retorna mensagem de erro na autenticação


  # Completar o cenário abaixo
  Cenário: Criar login
    Dado que acesso o site na pagina de autenticacao
    Quando insiro "email" e clico no botao create account
    Entao realizo o cadastro da conta

  Cenário: Realizar login
    Dado  que acesso o site para realizar o login
    Quando insiro "email" e "senha" e clico no botao sign in
    Entao logo com as crendecias validas


  # Completar o cenário abaixo
  Cenário: Login com falha
    Dado que na pagina de autenticacao
    Quando digito no campo "e-mail" e "senha"
    Entao retorna mensagem de erro na autenticacao

  Cenário: Esquecir a senha
    Dado que acesso a pagina de autenticacao
    Quando digito no campo "email" e clico no link Forgot You Password
    Entao informo "email" e clico no botao Retrieve Password


