# NoSql2023

Lenguaje y herramientas utilizadas: 

- JAVA con Springboot.
- Mongodb Atlas.
- IntelliJ Idea.
- Mongodb Compass.
- Postman.
- Jmeter.
- Jenkins.
- Docker desktop.

Modelo de datos lógico:

- Personas (ci, nombre, apellido, edad) con clave ci

- Domicilios (idDom, ciPer, departamento, localidad, calle, nro, apto, padron, ruta, km, letra, barrio) con clave idDom

En un principio se habia propuesto usar una tercera coleccion Direcciones compuesto por el id de Domicilios y el id de Personas pero al avanzar vimos que no era lo mas óptimo para las consultas y redundancia de datos, por lo que procedimos a usar solo dos colecciones y de esta forma las consultas quedarian mas eficientes.

Proceso de instalacion:

- Instalar el IDE IntelliJ IDEA.
- Instalar java 17.
- Clonar el proyecto Git.
- Configurar el archivo application properties (el cual adjuntamos en el correo de la entrega ya que no lo subimos al git por cuestiones de seguridad)
  El archivo application.properties va en la carpeta src/main/resources
  El contenido del archivo application.properties tiene los datos necesarios para conectarse al cluster y por consiguiente a la database en MongoDB Atlas.
- Tener en cuenta que el server.port tendra configurado el puerto que sera utilizado para levantar la api.
- Hacer el build y correr el archivo main NoSql2023Application.java

Operaciones ofrecidas como API REST:

http://localhost:8089/api/addPersona

Se le pasa un JSON con lo siguientes datos:
{

    "ci": "12586987",
    "nombre":"Emiliano",
    "apellido": "Furtado",
    "edad": "26"
}

http://localhost:8089/api/getAllPersonas (devuelve todas las personas de la bd)

http://localhost:8089/api/addDomicilio/12586987 (donde 12586987 es la cedula de la persona existente en el sistema a la que se le va a agregar la dirección)

Se le pasa además un JSON con lo siguientes datos:
{

    "departamento":"Montevideo",
    "localidad": "Montevideo",
    "calle": "Cno Maldonado",
    "nro": 1378,
    "apto": 12,
    "padron": 100254,
    "ruta": 8,
    "km": 12,
    "letra": "D",
    "barrio": "Union"
}

http://localhost:8089/api/getAllDomicilios (devuelve todos los domicilios de la bd)

http://localhost:8089/api/getDomiciliosPersona?ci=12586987&page=0&size=3 (el campo page y size son opcionales. Sin ellos por defecto muestra hasta 5 domicilios.

http://localhost:8089/api/getAllDomCriterio?barrio=Union&localidad=Montevideo&depto=Montevideo (no es obligatorio usar los 3 parametros, se puede buscar por uno solo o dos campos combinados)

http://localhost:8089/api/deleteDomicilios (elimina todos los domicilios de la bd)

http://localhost:8089/api/deletePersonas (elimina todas las personas de la bd)


Jmeter: 
Realizamos pruebas de carga con los diferentes endpoints, tirando entorno a las 200 usuarios con delay de 10s.  
Vimos que la api soporta la carga y a su vez analizamos las respuestas de los diferentes endpoints. 
En conclusion jmeter es un sistema muy utilizado para realizar estas pruebas, vimos que es bastante intuitivo y util.

Jenkins: 
Realizamos la configuracion del sistema con algo de dificultad (no es muy intuitivo). 
Configuramos el ambiente para que tomara el git como codigo fuente. 
Realizamos la configuracion para que utilice newman (comando de terminal para postman). 
Una vez pulsamos construir realiza la ejecucion del sistema. 
Finaliza sin errores. 
Procedimos a leer la respuesta la cual es coherente pero no es muy intuitivo.

Docker:
IntelJ Idea tiene instalado por defecto un plugin de docker que nos hizo mas fácil la tarea de dockerizar la app.
Solo fue necesario crear la conexion con Docker desktop desde los settings.
Con la herramienta de Maven integrada en IntelJ IDea se creo el JAR de la app y luego en la terminal usar el comando:
{

    ./mvnw spring-boot:build-image //crea la imagen a partir del jar
    docker run -p 8091:8091 -t nosql-2023:0.0.1-SNAPSHOT //corremos la app ya dockerizada
}