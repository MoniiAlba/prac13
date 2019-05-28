package estados;

import so.Bitacora;
import so.ProcesoG;

public class New extends Thread{
	private String nombre;
	private int burst;
	private Comunes cola;
	private int paginas;
	
	public New(String nombre, int burst, Comunes cola) {
		this.nombre = nombre;
		this.burst = burst;
		this.cola = cola;
	}
	public New(String nombre, int burst, Comunes cola, int paginas) {
		this.nombre = nombre;
		this.burst = burst;
		this.cola = cola;
		this.paginas = paginas;
	}
	

	@Override
	public void run() {
		ProcesoG pg = new ProcesoG(nombre, burst, paginas);
		System.out.println("[New]: "+pg.toString());
		Bitacora bitacora = new Bitacora("[New]: "+pg.toString());
		bitacora.writeLine();
		Ready r = new Ready(cola, pg);
		r.start();
		
	}
}
