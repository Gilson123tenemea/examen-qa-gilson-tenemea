PRUEBA DE CARGA - SERVICIO DE LOGIN (FAKESTOREAPI)

1. DESCRIPCION
Prueba de carga del servicio POST https://fakestoreapi.com/auth/login
con credenciales (user, passwd) parametrizadas desde un archivo CSV.

2. VERSIONES Y REQUISITOS
  - Apache JMeter 5.6.3
  - Java OpenJDK Temurin 21.0.13 (JMeter 5.6.3 requiere Java 8 o superior)
  - Sistema operativo: Windows 11
  - Conexion a internet
  - JMeter instalado y su carpeta bin agregada al PATH, o usar la ruta completa a
    bin\jmeter.bat
  Verificar en la terminal:
         java -version
         jmeter -v

3. ESTRUCTURA DEL REPOSITORIO
  jmeter\plan_carga_login.jmx     Plan de prueba de JMeter
  data\usuarios.csv               Datos de entrada (user,passwd)
  resultados\resultados.jtl       Resultados crudos de la ultima ejecucion
  resultados\reporte-html\        Reporte HTML de JMeter (abrir index.html)
  readme.txt                      Este archivo
  conclusiones.txt                Hallazgos y conclusiones

4. EJECUCION PASO A PASO
  1) Abrir una terminal (PowerShell) y ubicarse en la carpeta raiz del proyecto,
     la que contiene este readme.txt:
         cd "RUTA\examen-qa-carga-login"
  2) Borrar los resultados previos. JMeter exige que la carpeta del reporte no
     exista (o este vacia) y el archivo .jtl se acumularia:
         Remove-Item resultados\reporte-html, resultados\resultados.jtl -Recurse -Force
  3) Ejecutar la prueba en modo consola (no usar la interfaz grafica para la carga):
         jmeter -n -t jmeter\plan_carga_login.jmx -l resultados\resultados.jtl -e -o resultados\reporte-html
     Duracion: aproximadamente 4 minutos y medio.
  4) Abrir el reporte:
         start resultados\reporte-html\index.html
     En el Dashboard, la tabla "Statistics" muestra Error %, Throughput y tiempos.
  5) (Opcional) Abrir el plan en la interfaz grafica para revisarlo:
         jmeter -t jmeter\plan_carga_login.jmx

  El archivo CSV se lee con la ruta relativa ..\data\usuarios.csv respecto al
  plan, por lo que no hay que modificar rutas.

5. ESCENARIO DE PRUEBA
  - Servicio: POST /auth/login, cuerpo {"username":"${user}","password":"${passwd}"}
  - Datos: data\usuarios.csv (5 usuarios, reutilizados en ciclo)
  - 50 usuarios virtuales, ramp-up de 30 segundos, duracion de 240 segundos
  - Constant Throughput Timer: 1500 peticiones por minuto (objetivo 25 TPS)
  - Timeouts: conexion 10 segundos, respuesta 60 segundos
  - Validaciones por peticion: codigo HTTP 201, existencia de $.token en el
    JSON y tiempo de respuesta maximo de 1500 ms

6. CRITERIOS DE ACEPTACION
  - Throughput sostenido de al menos 20 TPS
  - Tiempo de respuesta maximo de 1,5 segundos
  - Tasa de error menor al 3% del total de peticiones (una peticion que supera
    1,5 segundos o que no devuelve 201 con token se cuenta como error)

7. RESULTADO DE LA ULTIMA EJECUCION
  - 5971 peticiones, 0 errores (0,00 %), throughput de 24,86 TPS
  - Tiempo de respuesta: promedio 352 ms, p95 431 ms, maximo 1190 ms
  - Los tres criterios se cumplieron. Detalle y analisis en conclusiones.txt