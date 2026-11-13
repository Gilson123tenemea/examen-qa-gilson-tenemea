EJERCICIO 2 - PRUEBAS DE API: SIGNUP Y LOGIN EN DEMOBLAZE

1. DESCRIPCION
Pruebas automatizadas de los servicios REST de https://www.demoblaze.com/
  - Signup: POST https://api.demoblaze.com/signup
  - Login:  POST https://api.demoblaze.com/login
Herramienta: Karate 1.5.1 (Java 21, Maven).

Casos cubiertos:
  1. Crear un nuevo usuario en signup
  2. Intentar crear un usuario ya existente
  3. Usuario y password correctos en login
  4. Usuario y password incorrectos en login

2. REQUISITOS
  - Java JDK 17 o superior (probado con Temurin 21)
  - Apache Maven 3.9 o superior (probado con 3.9.16)
  - Conexion a internet
  Verificar con:  java -version   y   mvn -version

3. ESTRUCTURA DEL PROYECTO
  pom.xml                                   Dependencias (Karate)
  src/test/resources/karate-config.js       Variables globales (baseUrl) y timeouts
  src/test/resources/features/              signup.feature y login.feature
  src/test/resources/helpers/               crear-usuario.feature (reutilizable)
  src/test/resources/data/                  usuarios_nuevos.csv y login_incorrecto.json
  src/test/java/com/demoblaze/api/          ApiRunnerTest (runner) y Codificador (Base64)
  reportes/karate-reports/                  Copia del reporte de la ultima ejecucion

4. EJECUCION PASO A PASO
  1) Descomprimir el .zip y abrir una terminal en la carpeta ejercicio2-api-karate
  2) Ejecutar:
         mvn clean test
  3) Al terminar, Maven debe indicar BUILD SUCCESS y Karate mostrara el resumen
     de escenarios (todos passed).

  Opcional - ejecutar solo un grupo por tag:
         mvn clean test -Dkarate.options="--tags @login"
     Tags disponibles: @signup, @login, @positivo, @negativo

5. REPORTE
  Reporte de Karate:  target/karate-reports/karate-summary.html
  Se incluye ademas una copia en la carpeta reportes/karate-reports/.

6. DATOS DE PRUEBA Y VARIABLES
  - La URL base se define una sola vez en karate-config.js (variable baseUrl).
  - Los usuarios nuevos se leen de data/usuarios_nuevos.csv (Scenario Outline).
  - Las claves incorrectas del login se leen de data/login_incorrecto.json (Scenario Outline).
  - Cada ejecucion genera nombres de usuario unicos (prefijo + marca de tiempo),
    por lo que las pruebas se pueden repetir sin conflictos.
  - La API espera la contrasena codificada en Base64; el helper Codificador.java la convierte.