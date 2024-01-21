# Cinesa
## Proyecto Simulación Cine en Java
---
Este es mi proyecto de *Java* referente al gestor y simulación de un Cine. Las clases que lo componen son las siguientes:
  
<ul>
	<li>Asiento.java -> Representa un asiento individual dentro del cine, con información de su ubicación (fila y
columna) y si está ocupado.</li>
	<li>Cine.java -> Modela el cine que contiene una matriz de asientos. Esta clase debe ser capaz de verificar la
disponibilidad de los asientos, gestionar las reservas, comprobar si el cine está completo, manejar la
recaudación total de las ventas y reiniciar los asientos cuando sea necesario.</li>
	<li>Cliente.java -> Cada cliente, ejecutándose como un hilo independiente, intentará reservar un asiento
específico en el cine y tendrá información personal y bancaria.</li>
	<li>ProcesadorDePagos.java -> Se encargará de simular el proceso de pago, realizando transferencias
bancarias desde la cuenta del cliente a la del cine.</li>
	<li>GestorDeReservas.java -> Funciona como intermediario entre el cliente y el sistema del cine. Esta clase
verifica la disponibilidad de asientos, gestiona el proceso de pago y, en caso de que un asiento esté
ocupado, busca el asiento alternativo más cercano disponible.</li>
  <li>Visualizador.java -> Un hilo que muestra el estado actual de los asientos en el cine y se actualiza cada
vez que se realiza una reserva.</li>
  <li>Main.java -> Inicia y controla la simulación. Esta clase crea y gestiona hilos para los clientes y el
visualizador, y se encarga del flujo continuo de la simulación.</li>
</ul>

URL dle proyecto: https://github.com/BrujoSevero/Cinesa.git
