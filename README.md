# Spring Boot Rest API demo

## Método `/hello`

Este método devuelve un saludo simple, "Hello, World!".

**Ejemplo de uso con curl:**

```bash
curl -X GET http://localhost:8080/hello
```

## Método `/reverse`

Este método toma un parámetro de entrada llamado `input` y devuelve el string invertido.

**Ejemplo de uso con curl:**

```bash
curl -X GET http://localhost:8080/reverse?input=example
```

## Método `/palindrome`

Este método toma un parámetro de entrada llamado `input` y devuelve `true` si el string es un palíndromo y `false` si no lo es.

**Ejemplo de uso con curl:**

```bash
curl -X GET http://localhost:8080/palindrome?input=radar
```

Por favor, asegúrate de reemplazar `localhost:8080` con la dirección y puerto correctos de tu servidor.

## Containarización

Para construir la imagen de Docker, ejecuta el siguiente comando:

```bash
docker build -t spring-boot-rest-api-demo .
```

Para ejecutar la imagen de Docker, ejecuta el siguiente comando:

```bash
docker run -p 8080:8080 spring-boot-rest-api-demo
```
