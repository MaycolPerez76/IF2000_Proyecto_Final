IF2000\_Proyecto\_Final
Sistema de Reservación de Vuelos
---

Curso: IF2000 – Programación I



Este proyecto es un sistema básico para simular la reservación de un tiquete de avión.  

Está desarrollado en Java con NetBeans e incluye una interfaz gráfica construida con Swing.



---



\## Funcionalidades del sistema

\- Seleccionar origen y destino.

\- Elegir clase (Business o Economy).

\- Ingresar nombre e identificación del pasajero.

\- Seleccionar fecha y hora del vuelo.

\- Verificar disponibilidad de asientos.

\- Generar el tiquete del vuelo.

\- Generar la factura del vuelo.

\- Calcular costos adicionales por equipaje.



---



\## Estructura del proyecto



\### \*\*Package: IF2000\*\*

\- \*\*Main.java\*\* – Punto de entrada del programa.



\### \*\*Package: Interface\*\*

\- \*\*Interface.java\*\* – Interfaz gráfica del sistema.  

\- \*\*Start.java\*\* – Inicia y muestra la interfaz.



\### \*\*Package: domain\*\*

\- \*\*Flight.java\*\* – Información del vuelo.  

\- \*\*Invoice.java\*\* – Calcula y muestra la factura.  

\- \*\*Passenger.java\*\* – Datos del pasajero.  

\- \*\*Plane.java\*\* – Maneja capacidades y ocupación del avión.  

\- \*\*Ticket.java\*\* – Genera la información del tiquete.



\### \*\*Package: logic\*\*

\- \*\*CalculateAmount.java\*\* – Cálculo de montos del vuelo.  

\- \*\*PlaneAvailability.java\*\* – Manejo de disponibilidad de asientos.  

\- \*\*Reservation.java\*\* – Lógica de reserva del vuelo.  

\- \*\*ValidateInformation.java\*\* – Validación de nombre, ID y datos ingresados.



---



\## Requisitos

\- Java 8 o superior  

\- NetBeans  

\- No utiliza base de datos (los datos son simulados en el código)



---



\## Cómo ejecutar el programa

1\. Abrir el proyecto en NetBeans.  

2\. Ejecutar desde \*\*Main.java\*\* o con \*\*Run Project\*\*.  

3\. Ingresar los datos en la interfaz.  

4\. Usar los botones para verificar disponibilidad, generar el tiquete y la factura.



---



\## Integrantes

\- Dylan Montero  

\- Eitel Jiménez  

\- Maycol Pérez



