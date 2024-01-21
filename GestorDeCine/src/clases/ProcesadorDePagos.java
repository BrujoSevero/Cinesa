package clases;

public class ProcesadorDePagos {	
	private Cine cine;
	private final int precioEntrada = 20;
	
	public ProcesadorDePagos(Cine cine) {
		this.cine = cine;
	}
	
	public boolean procesarPago(String cuentaCliente, int fondosCliente) {
		System.out.println("Verificación cuenta cliente + fondo: "+ cuentaCliente + " -> " + fondosCliente + " €");
		
		if(fondosCliente >= precioEntrada) {
			System.out.println("Pago realizado a la cuenta cliente: " + cuentaCliente);
			cine.agregarRecaudación(precioEntrada);
			
			return true;
		}else {
			System.out.println("Pago denegado por fondo inferior al precio de entrada a la cuenta cliente: " + cuentaCliente);
			
			return false;
		}
	}
	
	public int getPrecioEntrada() {
		return precioEntrada;
	}
}
