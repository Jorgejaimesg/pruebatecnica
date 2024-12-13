# Proyecto: Prueba Técnica

Este proyecto requiere la configuración de una base de datos y la ejecución de algunos scripts para poder iniciar y probar la aplicación. A continuación, te guío a través de los pasos necesarios.

## Paso 1: Crear la Base de Datos

Antes de iniciar el proyecto, debes crear una base de datos en PostgreSQL. En la consola de PostgreSQL o en pgAdmin 4, ejecuta el siguiente comando:

CREATE DATABASE pruebatecnica;

## Paso 2: Configurar la Conexión a la Base de Datos

1. Abre el proyecto en Visual Studio Code.
2. Navega hasta la carpeta `src/main/resources`.
3. Abre el archivo `application-dev.properties`.
4. Modifica las configuraciones de usuario y contraseña para que coincidan con los de tu instancia de PostgreSQL.

![imagen](https://github.com/user-attachments/assets/c8db8bd6-e28f-4e63-91b6-495a2dc3079d)

## Paso 3: Ejecutar el Proyecto

Una vez que hayas configurado la base de datos, es hora de ejecutar el programa:

1. Corre el proyecto en tu entorno de desarrollo.
   
2. Espera a que el programa termine de iniciar.

![imagen](https://github.com/user-attachments/assets/7f0770f3-a857-4911-87f2-995f57e1180f)

## Paso 4: Insertar Datos Iniciales

Cuando el programa esté corriendo, es necesario insertar datos de prueba en la base de datos. Para esto, realiza los siguientes pasos:

1. Navega hasta `src/main/resources` y abre el archivo `data.sql`.
2. Ejecuta el siguiente script para insertar los datos iniciales:

```
INSERT INTO categoria (nombre) VALUES
('Electronica'),
('Hogar'),
('Deportes'),
('Ropa'),
('Juguetes');

INSERT INTO producto (nombre, descripcion, precio, categoria_id) VALUES
('Televisor', 'Televisor LED de 42 pulgadas', 1200.50, 1),
('Smartphone', 'Telefono inteligente con 128GB de almacenamiento', 800.30, 1),
('Aspiradora', 'Aspiradora robot para limpieza automatica', 250.10, 2),
('Sofa', 'Sofa de 3 plazas con tapizado de cuero', 500.20, 2),
('Bicicleta', 'Bicicleta de pista con 21 velocidades', 300.00, 3),
('Balon de futbol', 'Balon oficial de tamaño 5', 25.00, 3),
('Camiseta', 'Camiseta deportiva de algodon', 20.00, 4),
('Pantalones', 'Pantalones de mezclilla para hombre', 40.00, 4),
('Barbie', 'Barbie articulada con accesorios', 35.00, 5),
('Puzzle', 'Rompecabezas de 1000 piezas', 15.00, 5);
```

## Paso 5: Probar las Consultas con Insomnia

Una vez insertados los datos, puedes probar las consultas utilizando **Insomnia** o cualquier otra herramienta de pruebas de APIs, la URL que se usará sera la siguiente: `http://localhost:8081/`



### Peticiones `POST` y `PUT` para Productos

Para la creación y actualización de productos, utiliza el siguiente formato:

```
{
	"nombre": "",
	"descripcion": "",
	"precio": ,
	"categoria": {
		"id": 
	}
}
```

### Peticiones `POST` para Categorías

Para crear una categoría, utiliza el siguiente formato. Ten en cuenta que las categorías no tienen una petición `PUT`:

```
{
	"nombre": ""
}
```

### EJEMPLOS

#### GET
aqui se pueden ver las consultas get tanto de categorias como de productos
 `http://localhost:8081/categorias`
![imagen](https://github.com/user-attachments/assets/e93f83bf-389b-4eda-a232-dc77888ab35b)

productos tiene tres consultas get: 
 1. `http://localhost:8081/productos` en esta nos muestra todos los productos
![imagen](https://github.com/user-attachments/assets/fc5ba646-ed70-4e3d-98ed-b91d7e10a007)

2. `http://localhost:8081/productos/categoria/1` en esta nos muestra todos los productos que pertenecen a la categoria 1
![imagen](https://github.com/user-attachments/assets/b2450da7-ead4-420a-8f60-911462858abc)

3. `http://localhost:8081/productos/1` en esta nos muestra solo el producto al que le corresponde el id
![imagen](https://github.com/user-attachments/assets/c74d37d8-0e2d-4cc2-88b7-c93426e12690)


 



 


