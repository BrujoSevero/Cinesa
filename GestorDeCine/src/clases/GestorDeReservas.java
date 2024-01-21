package clases;

public class GestorDeReservas {
	private Cine cine;
	private ProcesadorDePagos procesadorDePagos;
	
	public GestorDeReservas(Cine cine, ProcesadorDePagos procesadorDePagos) {
		this.cine = cine;
		this.procesadorDePagos = procesadorDePagos;
	}
	
	public synchronized void intentarReservar(Cliente cliente, int filaDeseada, int columnaDeseada) {
		System.out.println("El cliente " + cliente.getNombre() + " "+cliente.getApellidos()+" quiere reservar el asiento de la fila " + filaDeseada + " y columna " + columnaDeseada);
		System.out.println("Se registra con la cuenta de correo " + cliente.getCorreo() + " y la cuenta del banco " + cliente.getCuentaBancaria());
		
		if(this.cine.verificarDisponibilidad(filaDeseada, columnaDeseada)) {
			System.out.println("Asiento disponible.");
			procesarReserva(cliente, filaDeseada, columnaDeseada);
		}else {		
			System.out.println("Asiento no disponible, se procede a buscar un asiento alternativo...Por favor espere");
			int intentosColumna = 0;
			int nuevaFila = filaDeseada;
			int nuevaColumna = columnaDeseada;
			
			//Llamamos a la función buscarAsientoAlternativo y le ponemos los params de fila y columna nueva para verificar si queda algún asiento dispnible
			//cercano al que ha elegido el cliente.
			while ((!buscarAsientoAlternativo(nuevaFila, nuevaColumna))) {
				//Vamos sumando +1 tanto a la columna como a los intentos tantas veces hasta que encontrmos un asiento libre
				nuevaColumna++;
				intentosColumna++;
				//Si los intentosColumna es igual al número de columnas del cine se suma +1 a la fila para que suba y reiniciamos de nuevo el intentosColumna
				if (intentosColumna == this.cine.getColumnasCine()) {
					nuevaFila++;
					intentosColumna = 0;
				}else if (nuevaFila == this.cine.getFilasCine()) {
					nuevaFila = 0;
				}else if (nuevaColumna == this.cine.getColumnasCine()) {
					nuevaColumna = 0;
				}
			}

			System.out.println("El asiento " + (nuevaColumna + 1) + " de la fila " + (nuevaFila + 1)
					+ " está disponible. Se procede a reservarla.");
			//Una vez destacado el asiento disponible procedemos a realizar la reserva de dicho asiento
			procesarReserva(cliente, nuevaFila, nuevaColumna);		
			
		}
	}
	
	//Función para buscar un asiento aternativo por si el elegido por el cliente está ocupado.
	public boolean buscarAsientoAlternativo(int filaDeseada, int columnaDeseada) {	
		//Miramos si la fila y columna deseada, si está dsponible nos devolverá un true sino un false.
		if (this.cine.verificarDisponibilidad(filaDeseada, columnaDeseada)) {
			return true;
		} else {
			return false;
		}
	}

	public void procesarReserva(Cliente cliente, int fila, int columna) {
		System.out.println("Se procede a reservar el asiento.");
		
		if (this.procesadorDePagos.procesarPago(cliente.getCuentaBancaria(), cliente.getFondos())) {
			cine.reservarAsiento(fila, columna);
			System.out.println("El cliente cumple con los requisitos y ha reservado con éxito.");
		} else {
			System.out.println("El cliente no cumple con los fondos mínimos para reservar el asiento.");
		}

	}

	public Cine getCine() {
		return cine;
	}

	public ProcesadorDePagos getProcesadorDePagos() {
		return procesadorDePagos;
	}

	public void setProcesadorDePagos(ProcesadorDePagos procesadorDePagos) {
		this.procesadorDePagos = procesadorDePagos;
	}
	
}
