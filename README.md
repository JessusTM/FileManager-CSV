
# CSV (Comma Separated Values)

## Introduccion

Este repositorio contiene el código completo para la manipulación de archivos CSV utilizando Java, presenta clases y métodos para realizar todas las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) desde la consola, haciendo uso de las claves que entrega Java para la manipulación de archivos.
## Definición CSV

Archivo de texto plano que almacena datos delimitando las entradas con comas. Los archivos CSV se utilizan frecuentemente cuando se necesita que los datos sean compatibles con diferentes programas. Pueden abrirse en editores de texto, programas de hojas de cálculo como Excel u otras aplicaciones especializadas.

## File

La clase `File` en Java es utilizada para manipular archivos y directorios de manera uniforme en distintos sistemas operativos. Permite la creación, eliminación y obtención de información sobre archivos de forma compatible con cualquier entorno operativo.

El método `exists()` verifica si un archivo o directorio existe en el sistema antes de realizar operaciones adicionales. Esto facilita la verificación de la presencia de un recurso antes de intentar acceder a él.
## FileWriter

La clase `FileWriter` en Java se utiliza para escribir datos en forma de caracteres a un archivo. A diferencia de trabajar con bytes, `FileWriter` maneja caracteres, que son unidades de texto como letras y símbolos. Esta clase convierte automáticamente estos caracteres a su representación binaria adecuada y los escribe en el archivo.

**Características:**
- **Orientada a Caracteres:** Está diseñada para escribir texto legible por humanos en archivos, en lugar de datos binarios.
  
- **Conversión Automática:** Cada carácter se convierte internamente a una secuencia de bytes utilizando un conjunto de reglas conocido como codificación de caracteres (como UTF-8). `FileWriter` maneja esta conversión automáticamente, lo que facilita escribir texto directamente a un archivo sin preocuparse por la conversión manual de caracteres a bytes.

## BufferedWriter

La clase `BufferedWriter` en Java se utiliza para escribir datos en forma de caracteres a un archivo de manera más eficiente que utilizando directamente la clase `FileWriter`. Esto se logra mediante el uso de un buffer interno.

### ¿Qué es un buffer?

Un `buffer` es una región de la memoria física que almacena temporalmente los datos mientras se trasladan de un lugar a otro. En el caso de `BufferedWriter`, el `buffer` almacena caracteres antes de escribirlos en el archivo.

### Ventajas

Sin `buffer` cada llamada al método `write()` de `FileWriter` escribe directamente en el archivo, lo que puede resultar en múltiples accesos al disco. Estos accesos son costosos en términos de tiempo. `BufferedWriter` acumula los caracteres en un `buffer` y realiza una única operación de escritura cuando el `buffer` está lleno o cuando se cierra el `BufferedWriter`, reduciendo así el número de operaciones de escritura y mejorando el rendimiento.

### FileWriter y BufferedWriter

`BufferedWriter` se utiliza en conjunto con `FileWriter` para aprovechar las capacidades de escritura de `FileWriter` y mejorar su eficiencia. `FileWriter` es responsable de convertir los caracteres en bytes y escribirlos en un archivo, mientras que `BufferedWriter` optimiza este proceso mediante el uso de un `buffer`.

## FileReader

La clase `FileReader` en Java se utiliza para leer datos en forma de caracteres desde archivos. 

### Creación de un FileReader
Se puede crear un `FileReader` utilizando el nombre del archivo

También se puede crear un `FileReader` utilizando un objeto `File`.  


### Métodos de FileReader
La clase FileReader proporciona implementaciones para varios métodos presentes en la clase Reader.

- `read()`: Lee un solo carácter del lector.


### Cierre del FileReader

Para cerrar el `FileReader`, se utiliza el método `close()`. Una vez que se llama a este método, no se puede utilizar el `FileReader` para leer más datos.
## BufferedReader

En Java para leer un archivo de texto, en lugar de leer cada carácter uno por uno desde el principio hasta el final, Java utiliza un `BufferedReader`. Este objeto actúa como un marcador de página en un libro, almacenando una cantidad considerable de caracteres en un búfer especial para permitir una lectura más eficiente.

Al igual que un lector puede avanzar más rápido utilizando un marcador de página en un libro, Java puede procesar los caracteres almacenados en el `búfer` de `BufferedReader` de manera más rápida que si los leyera directamente desde el archivo cada vez. Esto evita las múltiples visitas lentas al archivo, mejorando significativamente el rendimiento.

### Lectura de Texto con BufferedReader

Para inicializar un `BufferedReader`, se utiliza su constructor `BufferedReader(Reader)`.

Después de utilizar el `BufferedReader`, se debe llamar a su método `close()` para liberar los recurss asociados con él.       
## Documentación

[Java Platform Standard Ed 8 - File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html)

[Java Platform Standard Ed 8 - FileWriter](https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html)

[Java Baeldung - FileWriter](https://www.baeldung.com/java-filewriter)

[Java Platform Standard Ed 8 - BufferedWriter](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html)

[Java Platform Standard Ed 8 - FileReader](https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html)

[Java Baeldung - FileReader](https://www.baeldung.com/java-filereader)

[Java Platform Standard Ed 8 - BufferedReader](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html)

[Java Baeldung - BufferedReader](https://www.baeldung.com/java-buffered-reader)
