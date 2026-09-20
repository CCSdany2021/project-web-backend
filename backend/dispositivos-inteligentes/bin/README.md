# Dispositivos Inteligentes — Backend

Este proyecto es la parte de "atrás" (backend) de una tienda de dispositivos inteligentes. No tiene pantallas ni nada visual — su trabajo es guardar la información de los productos, marcas, categorías y comentarios, y entregarla cuando se la piden.

## Con qué se hizo

- **Java** como lenguaje de programación.
- **Jakarta EE** para construir la API (la forma en que otros programas le piden datos a este proyecto).
- **MySQL** como base de datos, donde se guarda toda la información.
- **Apache Tomcat** como servidor, que es el programa que mantiene esta aplicación encendida y escuchando peticiones.

## Cómo funciona, en palabras simples

Cuando alguien (por ejemplo, la página web del frontend) pide "dame la lista de dispositivos", este programa:

1. Recibe esa petición.
2. Busca la información en la base de datos MySQL.
3. La devuelve en un formato llamado **JSON**, que es como una lista ordenada de datos que cualquier página web puede leer y mostrar.

Todo esto pasa a través de direcciones (URLs) específicas, llamadas **endpoints**:

| Qué pides | Dirección | Qué te devuelve |
|---|---|---|
| Lista de dispositivos | `/api/dispositivos` | Todos los dispositivos disponibles |
| Un dispositivo puntual | `/api/dispositivos/{id}` | Los datos de un solo dispositivo |
| Lista de marcas | `/marcas` | Samsung, Apple, Dell, etc. |
| Lista de categorías | `/categorias` | Celulares, Laptops, etc. |
| Lista de comentarios | `/comentarios` | Los comentarios de los usuarios |

## Cómo ejecutarlo

1. Tener instalado: Java, Maven, Apache Tomcat y MySQL.
2. Cargar la base de datos:
   ```
   mysql -u root -p < database/dispositivos_inteligentes.sql
   ```
3. Abrir el archivo `src/main/java/com/ucompensar/dispositivos/util/Conexion.java` y poner ahí el usuario y la contraseña de tu propio MySQL.
4. Compilar el proyecto:
   ```
   mvn clean package
   ```
   Esto genera un archivo `.war` dentro de la carpeta `target/` (o puedes usar el `.war` que ya viene listo, sin compilar, si te lo compartieron aparte).
5. Copiar ese `.war` a la carpeta `webapps` de Tomcat, y prender Tomcat.
6. Probar abriendo en el navegador:
   ```
   http://localhost:8080/dispositivos-inteligentes-1.0-SNAPSHOT/api/dispositivos
   ```
   Si aparece una lista de dispositivos en texto, todo quedó funcionando.

## El proyecto hermano

La parte visual (lo que el usuario ve y usa) está en otro proyecto aparte, hecho en React: **dispositivos-inteligentes-frontend**.
