#language: pt
#encoding: utf8
Funcionalidade: Buscas no Fake Ecommerce
  Como um cliente do site FakeEcommerce
  Gostaria de poder buscar por produto
  Para customizar as compras adiconando ao carrinho
  Busco por produto fora da categoria retorna resultado nao encontrado


  @buscar_por_termo_valido
  Cenário: Buscar por termo válido
    Dado que busco nome do produto "shirt"
    Quando clico no botao da lupa
    Entao devem ser retornados produto "shirt"

  Cenario: adicionar produto no carrinho
    Dado que procuro produto "shirt"
    Quando clico na lupa
    Entao adiciona ao carrinho de compras


  # Completar o cenário abaixo
  @busca_sem_resultados
  Cenário: Busca sem resultados
    Dado que busco pelo produto "cafe"
    Quando clico no botao de busca
    Entao retorna resultado nao encontrado




