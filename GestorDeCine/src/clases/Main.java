package clases;

public class Main {

	public static void main(String[] args) {	
		int dineroCliente = 35;
		//Iniciamos las clases
		Cine cine = new Cine("Cinesa");
		ProcesadorDePagos procesadorDePagos = new ProcesadorDePagos(cine);
		GestorDeReservas gestorDeReservas = new GestorDeReservas(cine, procesadorDePagos);
		Visualizador visualizador = new Visualizador(cine);

		Thread th = new Thread(visualizador);
		//Inciamos el hilo del visulaizador
		th.start();

		while (true) {
			try {
				
				Cliente cliente = new Cliente(gestorDeReservas, cine, dineroCliente);
				th = new Thread(cliente);
				//Inciamos el hilo del cliente
				th.start();
				//Tiempo que tarda en venir cada cliente
				Thread.sleep(2000);

				// Cuando el cine esté lleno, lo reinciamos
				if (cine.estaLleno()) {
					System.out.println("El cine está lleno y la película ha empezado. " + cine.getCuentaCine()
							+ " ha recaudado " + cine.getRecaudacionTotal() + "€");
					System.out.println("Vaciando la sala para que comience la siguiente película...");

					// Tiempo en que se tarda de vacia el cine
					Thread.sleep(3000);

					cine.reiniciarAsientos();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
