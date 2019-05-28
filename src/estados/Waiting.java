package estados;

import so.Bitacora;
import so.ProcesoG;

public class Waiting extends Thread{
	private Comunes colaReady;
	private ProcesoG pg;

	public Waiting(Comunes colaReady, ProcesoG pg) {
		super();
		this.colaReady = colaReady;
		this.pg = pg;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		double sleepWaiting = Math.random()*1000;
		try {
			System.out.println("[Waiting]: "+pg.toString());
			Bitacora bitacora = new Bitacora("[Waiting]: "+pg.toString());
			bitacora.writeLine();
			Thread.sleep((long) sleepWaiting);
			this.pg.setTiempoEspera(this.pg.getTiempoEspera()+sleepWaiting);
			Ready ready = new Ready (this.colaReady, pg);
			ready.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
