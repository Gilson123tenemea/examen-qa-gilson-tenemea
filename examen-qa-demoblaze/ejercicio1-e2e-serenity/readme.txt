EJERCICIO 1 - PRUEBA E2E: FLUJO DE COMPRA EN DEMOBLAZE

1. DESCRIPCION
Prueba funcional automatizada del flujo de compra en https://www.demoblaze.com/
Framework: Serenity BDD 5.3.3 + Cucumber 7.34.2 + patron Screenplay (Java 21, Maven).

Flujo cubierto:
  - Agregar dos productos al carrito
  - Visualizar el carrito
  - Completar el formulario de compra
  - Finalizar la compra y validar el mensaje de confirmacion

2. REQUISITOS
  - Java JDK 17 o superior (probado con Temurin 21)
  - Apache Maven 3.9 o superior (probado con 3.9.16)
  - Google Chrome instalado
  - Conexion a internet
    Verificar con:  java -version   y   mvn -version

3. ESTRUCTURA DEL PROYECTO
  pom.xml                               Dependencias y plugins
  src/test/resources/features/          Feature en Gherkin (espanol)
  src/test/resources/data/              Datos de prueba en CSV (compradores.csv)
  src/test/resources/serenity.conf      Configuracion de navegador y reportes
  src/test/java/com/demoblaze/
     runners/                           Runner de Cucumber (JUnit 5)
     stepdefinitions/                   Definicion de pasos
     tasks/                             Acciones de negocio (Screenplay)
     interactions/                      Acciones tecnicas (alertas, esperas)
     userinterfaces/                    Locators de cada pagina
     models/                            Modelo de datos de la compra
     questions/                         Verificaciones
     utils/                             Lector del CSV
  reportes/                             Copia de los reportes de la ultima ejecucion

4. EJECUCION PASO A PASO
  1) Descomprimir el .zip y abrir una terminal en la carpeta ejercicio1-e2e-serenity
  2) Ejecutar:
         mvn clean verify
     Se abrira Chrome y se ejecutaran los escenarios del feature.
  3) Al terminar, Maven debe indicar BUILD SUCCESS.

  Opciones adicionales:
     Ejecutar sin ventana de Chrome:   mvn clean verify -Dheadless.mode=true
     Cambiar la URL del sitio:         mvn clean verify -Ddemoblaze.url=https://www.demoblaze.com/
     Ejecutar solo un tag:             mvn clean verify -Dcucumber.filter.tags="@smoke"

5. REPORTES
  Reporte de Serenity:   target/site/serenity/index.html
  Reporte de Cucumber:   target/cucumber-report/cucumber.html
                         target/cucumber-report/cucumber.json
  Se incluye ademas una copia de los reportes de la ultima ejecucion en la carpeta reportes/.

6. DATOS DE PRUEBA
  - Los productos de cada escenario se definen en la tabla "Ejemplos" del feature.
  - Los datos del comprador se leen de src/test/resources/data/compradores.csv
    usando la columna "caso" como clave.
  - Para agregar un caso nuevo: anadir una fila en el CSV y una fila en "Ejemplos" con el mismo valor de "caso".