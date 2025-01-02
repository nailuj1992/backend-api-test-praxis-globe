# Prueba técnica - Praxis Globe

## Clonar e importar el proyecto

Primeramente se requiere descargar el **Spring Tool Suite 4**, para lo cual incluyo el siguiente enlace para descargarlo: https://spring.io/tools

![image](https://github.com/user-attachments/assets/7d068716-5311-4e3f-86e7-e0d69025b460)

Ahora se procede a clonar el proyecto. Una vez clonado, se procede a importar el proyecto en STS4.

![image](https://github.com/user-attachments/assets/e64a1aae-1830-4c25-b206-31600cf5af23)
![image](https://github.com/user-attachments/assets/9cf1f077-ece6-4e30-9120-8c2e580e7c62)
![image](https://github.com/user-attachments/assets/1f243b77-85b1-42da-865b-77c084ac38b5)

## Ejecución de scripts de DB - MySQL

Una vez importado el proyecto, procedemos a buscar el archivo **sql.sql**, el cual está contenido en el directorio *src/main/resources*.

![image](https://github.com/user-attachments/assets/f6da802d-2874-4290-ab37-c3990c4bdfe9)

Ahora se procede a descargar e instalar cualquier proveedor de Base de Datos MySQL en *localhost*, así como el workbench. En mi caso, he instalado XAMPP, el cual provee una conexión a DB.

![image](https://github.com/user-attachments/assets/1f1ab669-c830-474c-a7e9-52ff51bba6c6)

Asimismo, se ejecuta el workbench de MySQL para poder acceder a la DB.

![image](https://github.com/user-attachments/assets/c05b5976-ed27-43a0-8a7e-5816db8d2289)

Ahora copiamos el contenido del archivo mencionado antes en el workbench y lo pegamos en el editor del workbench.

![image](https://github.com/user-attachments/assets/2c0cb104-9a3b-4ba3-852e-9bc9985016cb)

## Ejecución del proyecto

De vuelta en el STS4, damos clic derecho al proyecto, y buscamos la opción *Run As > Maven build...*

![image](https://github.com/user-attachments/assets/8d007902-7724-4ca4-98a1-14660dc8baf6)
![image](https://github.com/user-attachments/assets/c185ad4f-25bb-4e2d-8890-e4e6fedac41f)

De este modo nos aseguramos de compilar el proyecto y ejecutar las pruebas unitarias.

![image](https://github.com/user-attachments/assets/00b5740f-7433-45d8-8114-9ac7365ebb60)

Finalmente, nos dirigimos al menú del proyecto, y buscamos la opción *Run As > Spring Boot App*

![image](https://github.com/user-attachments/assets/4e11a95b-09f6-4be7-b971-3b6e6989968c)

Y el proyecto se encuentra desplegado en la máquina local, listo para ejecutar las pruebas pertinentes por medio de Postman.

![image](https://github.com/user-attachments/assets/91dcf279-e6ce-4295-8908-13ebfaeef099)

## Pruebas realizadas

### Prueba 1: Producto existe y tiene una promoción vigente

![image](https://github.com/user-attachments/assets/32cbe178-512e-4e7b-a233-7f8ba63a3e69)

### Prueba 2: Producto existe pero no tiene promociones vigentes

![image](https://github.com/user-attachments/assets/198e2820-feff-415f-b356-6f9febb1b137)

### Prueba 3: Producto no existe

![image](https://github.com/user-attachments/assets/8be481c6-d5d7-434f-9827-7f919d991b85)
