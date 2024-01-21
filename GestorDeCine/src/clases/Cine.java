package clases;

public class Cine {
	
	private final int filasCine = 15;
	private final int columnasCine = 15;	
	private Asiento[][] asientos = new Asiento[filasCine][columnasCine];
	private int recaudacionTotal;
	private String cuentaCine;
	
	public Cine() {
		
	}

	public Cine(String cuentaCine) {
		//Inciamos la variable a 0
		this.recaudacionTotal=0;
		this.cuentaCine = cuentaCine;
		inicializarAsientos();
	}
	
	private void inicializarAsientos() {
		for(int fila = 0; fila < filasCine; fila++) {
			for(int columna = 0; columna < columnasCine; columna++) {
				this.asientos[fila][columna] = new Asiento(fila,columna);
			}
		}
	}
	
	public boolean verificarDisponibilidad(int fila, int columna) {
		return !this.asientos[fila][columna].isOcupado();
	}
	
	public void reservarAsiento(int fila, int columna) {
		this.asientos[fila][columna].setOcupado(true);
	}
	
	public boolean estaLleno() {
		for(int fila = 0; fila < filasCine; fila++) {
			for(int columna = 0; columna < columnasCine; columna++) {
				if(!this.asientos[fila][columna].isOcupado()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void agregarRecaudación(int abono){
		this.recaudacionTotal += abono;
	}
	
	//Cuando se encuentre lleno el cine, se volverá a vaciralos para empezar de nuevo una nueva película
	public void reiniciarAsientos() {
		for(int fila = 0; fila < filasCine; fila++) {
			for(int columna = 0; columna < columnasCine; columna++) {
				this.asientos[fila][columna].setOcupado(false);
			}
		}
	}

	public String getCuentaCine() {
		return cuentaCine;
	}

	public void setCuentaCine(String cuentaCine) {
		this.cuentaCine = cuentaCine;
	}

	public int getFilasCine() {
		return filasCine;
	}

	public int getColumnasCine() {
		return columnasCine;
	}

	public Asiento[][] getAsientos() {
		return asientos;
	}

	public int getRecaudacionTotal() {
		return recaudacionTotal;
	}

}
