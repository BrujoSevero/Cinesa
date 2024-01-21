package clases;

public class Visualizador implements Runnable{
	private Cine cine;

	public Visualizador() {
		
	}
	
	public Visualizador(Cine cine) {
		this.cine = cine;
	}

	public void mostrarEstadoAsientos() {
		//Recorremos los asientos de cine y los printamos por pantalla
		for (int i = 0; i < cine.getAsientos().length; i++) {
			for (int j = 0; j < cine.getAsientos()[0].length; j++) {
				if (this.cine.getAsientos()[i][j].isOcupado()) {
					//Si está ocupado el asiento printamos una X sino una O.
					System.out.print("[X] ");
				} else {
					System.out.print("[O] ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (cine) {
					//Esperamos para luego mostrar los asientos
					cine.wait();
					mostrarEstadoAsientos();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
