Feature: Signup de usuarios en Demoblaze

  Background:
    * def Codificador = Java.type('com.demoblaze.api.Codificador')
    * url baseUrl

  @signup @positivo
  Scenario Outline: Crear un usuario nuevo - <caso>
    * def usuario = prefijo + '_' + java.lang.System.currentTimeMillis()
    * def claveB64 = Codificador.aBase64(clave)
    Given path 'signup'
    And request { username: '#(usuario)', password: '#(claveB64)' }
    When method post
    Then status 200
    And assert karate.toString(response).trim() == '' || karate.toString(response).trim() == '""'

    Examples:
      | read('classpath:data/usuarios_nuevos.csv') |

  @signup @negativo
  Scenario: Intentar crear un usuario ya existente
    * def existente = call read('classpath:helpers/crear-usuario.feature')
    * def claveB64 = Codificador.aBase64(existente.clave)
    Given path 'signup'
    And request { username: '#(existente.usuario)', password: '#(claveB64)' }
    When method post
    Then status 200
    And match response == { errorMessage: 'This user already exist.' }