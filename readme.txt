GUIA DE EJECUCION - EXAMEN PRACTICO QA (GILSOIN)
================================================

CONTENIDO DEL PAQUETE
  examen-qa-demoblaze\ejercicio1-e2e-serenity   Ejercicio E2E (Serenity BDD)
  examen-qa-demoblaze\ejercicio2-api-karate     Ejercicio API (Karate)
  examen-qa-carga-login                         Prueba de carga (JMeter)

REQUISITOS
  Los requisitos y las versiones exactas de cada ejercicio estan en el readme.txt
  de su carpeta. Resumen:
    - Windows 11 y conexion a internet
    - Java JDK 21 (Temurin 21.0.13)
    - Apache Maven 3.9.16           (ejercicios 1 y 2)
    - Google Chrome                 (ejercicio 1)
    - Apache JMeter 5.6.3           (prueba de carga)
  Verificar en la terminal:   java -version    mvn -version    jmeter -v

PASO 0 - DESCOMPRIMIR
  Descomprimir el zip, por ejemplo en C:\Examen-QA-Gilsoin
  En las rutas siguientes <RAIZ> es esa carpeta.
  Abrir PowerShell (o la terminal de VS Code).

-------------------------------------------------------------------------
EJERCICIO 1 - E2E: FLUJO DE COMPRA EN DEMOBLAZE (Serenity BDD)
-------------------------------------------------------------------------
  1) Ir a la carpeta del ejercicio:
         cd "<RAIZ>\examen-qa-demoblaze\ejercicio1-e2e-serenity"
  2) Ejecutar la prueba (se abre Chrome, 2 escenarios, aprox. 3 minutos):
         mvn clean verify
     Debe terminar con BUILD SUCCESS.
  3) Abrir los reportes:
         start target\site\serenity\index.html          (reporte de Serenity)
         start target\cucumber-report\cucumber.html     (reporte de Cucumber)
  Reportes ya generados (sin ejecutar nada):
         reportes\serenity\index.html     reportes\cucumber\cucumber.html
  Documentacion: readme.txt y conclusiones.txt en la misma carpeta.

-------------------------------------------------------------------------
EJERCICIO 2 - API: SIGNUP Y LOGIN (Karate)
-------------------------------------------------------------------------
  1) Ir a la carpeta del ejercicio:
         cd "<RAIZ>\examen-qa-demoblaze\ejercicio2-api-karate"
  2) Ejecutar las pruebas (6 escenarios, menos de 1 minuto):
         mvn clean test
     Debe terminar con BUILD SUCCESS.
  3) Abrir el reporte de Karate:
         start target\karate-reports\karate-summary.html
  Reporte ya generado (sin ejecutar nada):
         reportes\karate-reports\karate-summary.html
  Documentacion: readme.txt y conclusiones.txt en la misma carpeta.

-------------------------------------------------------------------------
EJERCICIO 3 - PRUEBA DE CARGA DEL LOGIN (JMeter)
-------------------------------------------------------------------------
  1) Ir a la carpeta del ejercicio:
         cd "<RAIZ>\examen-qa-carga-login"
  2) Borrar los resultados previos (JMeter exige que no existan):
         Remove-Item resultados\reporte-html, resultados\resultados.jtl -Recurse -Force
  3) Ejecutar la prueba en modo consola (aprox. 4 minutos):
         jmeter -n -t jmeter\plan_carga_login.jmx -l resultados\resultados.jtl -e -o resultados\reporte-html
  4) Abrir el reporte:
         start resultados\reporte-html\index.html
  Criterios a revisar en la tabla Statistics: Error % menor a 3, Throughput de
  al menos 20 por segundo y tiempos de respuesta menores a 1500 ms.
  Documentacion: readme.txt y conclusiones.txt en la misma carpeta.

NOTAS
  - Si se prefiere solo ver los resultados, los reportes de la ultima ejecucion
    ya estan incluidos en cada carpeta.
  - Los ejercicios 1 y 2 dependen de https://www.demoblaze.com/ y
    https://api.demoblaze.com/ ; el 3 depende de https://fakestoreapi.com/.
    Son servicios publicos y su disponibilidad puede variar.