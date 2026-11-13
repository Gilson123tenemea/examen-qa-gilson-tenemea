@ignore
Feature: Helper - crear un usuario nuevo

  Scenario: Registrar usuario con nombre unico
    * def Codificador = Java.type('com.demoblaze.api.Codificador')
    * def prefijo = karate.get('prefijo', 'qa')
    * def clave = karate.get('clave', 'Clave123')
    * def usuario = prefijo + '_' + java.lang.System.currentTimeMillis()
    * def claveB64 = Codificador.aBase64(clave)
    Given url baseUrl
    And path 'signup'
    And request { username: '#(usuario)', password: '#(claveB64)' }
    When method post
    Then status 200