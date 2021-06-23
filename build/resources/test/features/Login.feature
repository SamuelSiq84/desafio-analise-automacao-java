#language: pt
#encoding: utf8
Funcionalidade: Ecommerce Fake
  Como um cliente gostaria criar login na página de autenticação insiro e-mail e clico no botão create account
  Como cliente quero logar na página digito e-mail e senha e clico no botão sign in
  Caso digito e-mail inválido retorna mensagem de erro na autenticação
  Caso digito e-mail e esqueço a senha clico no link Forgot your password


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
    Quando digito no campo "email" e clico no link forgot your password
    Entao informo "email" e clico no botao Retrieve Password


