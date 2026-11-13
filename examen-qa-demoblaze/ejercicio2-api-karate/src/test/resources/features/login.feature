Feature: Login de usuarios en Demoblaze

  Background:
    * def Codificador = Java.type('com.demoblaze.api.Codificador')
    * def registrado = call read('classpath:helpers/crear-usuario.feature')
    * url baseUrl

  @login @positivo
  Scenario: Login con usuario y password correctos
    * def claveB64 = Codificador.aBase64(registrado.clave)
    Given path 'login'
    And request { username: '#(registrado.usuario)', password: '#(claveB64)' }
    When method post
    Then status 200
    And match response contains 'Auth_token:'

  @login @negativo
  Scenario Outline: Login con password incorrecto - <caso>
    * def claveB64 = Codificador.aBase64(claveIncorrecta)
    Given path 'login'
    And request { username: '#(registrado.usuario)', password: '#(claveB64)' }
    When method post
    Then status 200
    And match response == { errorMessage: 'Wrong password.' }

    Examples:
      | read('classpath:data/login_incorrecto.json') |