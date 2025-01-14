# Challenge-ConversorDeMonedas

## 📌 Descripción del Proyecto  
El **Conversor de Monedas** es una aplicación Java que permite a los usuarios realizar conversiones entre varias monedas de Latinoamérica y el dólar estadounidense, utilizando tasas de cambio obtenidas en tiempo real desde la API de ExchangeRate. Además, la aplicación guarda un historial de las conversiones realizadas, incluyendo la fecha y hora de cada operación, en un archivo JSON para consulta futura.  

---

## 🎯 Funcionalidades  
1. Conversión en tiempo real entre las siguientes monedas:  
   - **ARS** - Peso argentino  
   - **BOB** - Boliviano boliviano  
   - **BRL** - Real brasileño  
   - **CLP** - Peso chileno  
   - **COP** - Peso colombiano  
   - **MXN** - Peso mexicano  
   - **PEN** - Sol peruano  
   - **USD** - Dólar estadounidense  
2. Menú interactivo para:  
   - Seleccionar moneda de origen y destino.  
   - Ingresar el monto a convertir.  
   - Visualizar el resultado de la conversión.  
3. Registro automático de todas las conversiones realizadas en un archivo `historial_conversor.json` con la fecha y hora de cada operación.  
4. Fácil manejo de errores en caso de entrada no válida o problemas con la conexión a la API.  

---

## 🛠 Tecnologías Utilizadas  
- **Java**: Lenguaje principal de desarrollo.  
- **Gson**: Biblioteca para manejo de archivos JSON.  
- **HttpClient**: Para realizar solicitudes HTTP a la API de ExchangeRate.  
- **ExchangeRate API**: Fuente de datos para las tasas de cambio actualizadas.  

---

## 🚀 Cómo pueden usarlo los usuarios  
1. Clona este repositorio o descarga los archivos fuente.  
2. Asegúrate de tener instalado **Java 11** o superior en tu máquina.  
3. Abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ IDEA o Eclipse).  
4. Ejecuta el archivo principal `Principal.java`.  
5. Sigue las instrucciones del menú interactivo para:  
   - Seleccionar las monedas de origen y destino.  
   - Ingresar el monto a convertir.  
   - Visualizar el resultado y realizar nuevas conversiones.  

---

## 📂 Acceso al Proyecto  
Puedes acceder al código fuente del proyecto en el repositorio oficial:  
https://github.com/dangerouskeen/Challenge-ConversorDeMonedas.git

---

## 📈 Estado del Proyecto  
El proyecto está en su versión inicial completamente funcional. Las siguientes características pueden añadirse en futuras versiones:  
- Soporte para más monedas.  
- Interfaz gráfica para mayor facilidad de uso.  
- Opciones para exportar el historial a otros formatos, como Excel o PDF.  

---

## Créditos
- Diseño y Desarrollo: Eduardo
- Año: 2025
- Licencia: Este proyecto está bajo la licencia de ALURA-LATAM ONE. Todos los derechos reservados.
