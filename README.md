# NoSql2023

Lenguaje utilizado JAVA con sprinboot
Base de datos Mongodb con atlas para mantener la base en la nube
Ide utilizado Intellij idea
Para chequear la base utilizamos Mongodb Compass
Para la ejecucion utilizamos postman
Para la prueba de carga utilizamos Jmeter
Automatizacion de pruebas con Jenkins


Modelo de datos lógico:

Personas (ci, nombre, apellido, edad) con id cedula
Domicilios (id, ci, departamento, localidad, calle, nro, apto, padron, ruta, km, letra, barrio) con clave id

En un principio habiamos pensado usar una tercera coleccion Direcciones compuesto por el id de Domicilios y el id de Personas pero al avanzar vimos que no era lo mas optimo por las consultas y redundancia de datos. Por lo que procedimos a usar solo dos colecciones y de esta forma las consultas quedan mas eficientes

Proceso de instalacion:

- Instalamos el ide intellij
- Instalamos java 17 correto
- Instalamos mongodb que incluye el mongdb compass
- Importar el proyecto git
- Configurar el archivo aplication properties (el cual adjuntamos en el correo de la entrega ya que no lo subimos al git para que no se nos rompiera la configuracion)
  El archivo application.properties va en la carpeta src/main/resources
  El contenido del archivo application.properties tiene lo siguiente:
  spring.data.mongodb.uri=mongodb+srv://Ch91:RdKjF54WY4Amc4@tecnocluster.sslbqbf.mongodb.net/?retryWrites=true&w=majority
  spring.data.mongodb.database=NoSQL_Obli
  server.port=8089
- Tener en cuenta que el server.port tendra configurado el puerto que sera utilizado para levantar la api
- Hacer el build y ejecutar el archivo main NoSql2023Application.java

Ejecucion postman:

Ajuntamos json de la coleccion en el correo que contiene las llamadas a la api
Las llamadas a las api son:
http://localhost:8089/api/getAllPersonas
http://localhost:8089/api/addPersona
http://localhost:8089/api/getAllDomicilios
http://localhost:8089/api/addDomicilio/888 donde 888 es la cedula de la persona existente en el sistema a la que se le va a agregar la direccion
En el body de esta llamada va un json del estilo:
{

    "departamento":"Soriano",
    "localidad": "canelones",
    "calle": "malibu",
    "nro": 2245,
    "apto": 12,
    "padron": 100254,
    "ruta": 9,
    "km": 21,
    "letra": "D",
    "barrio": "chancha"
}
http://localhost:8089/api/getAllDomCriterio?barrio=chancha&localidad=sas&depto=asa donde barrio, localidad y depto son los campos por los cuales se busca el domicilio. No tienen porque estar todos


Jmeter:
Realizamos pruebas de carga con los diferentes endpoints, tirando entorno a las 200 usuarios con delay de 10s 
Vimos que la api soporta la carga y a su vez analizamos las respuestas de los diferentes endpoints
En conclusion jmeter es un sistema muy utilizado para realizar estas pruebas, vimos que es bastante intuitivo y util

Jenkins:
Realizamos la configuracion del sistema con algo de dificultad (no es muy intuitivo)
Configuramos el ambiente para que tomara el git como codigo fuente
Realizamos la configuracion para que utilice newman (comando de terminal para postman)
Una vez pulsamos construir realiza la ejecucion del sistema
Finaliza sin errores
Procedimos a leer la respuesta la cual es coherente pero no es muy intuitivo
