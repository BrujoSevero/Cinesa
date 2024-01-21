package clases;

public class Asiento {
	private int fila, columna;
	private boolean ocupado;
	
	public Asiento() {
		
	}

	public Asiento(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
		this.ocupado = false;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	public String toString() {
		//Verificamos si el asiento está libre u ocupado.
		if(this.ocupado) {
			return "El asiento de la fila " + fila + " , columna " + columna + " se encuentra ocupado.";
		}else {
			return "El asiento de la fila " + fila + " y columna " + columna + " se encuentra libre.";
		}	
	}
}
