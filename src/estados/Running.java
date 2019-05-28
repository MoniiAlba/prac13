package estados;

import so.Bitacora;
import so.ProcesoG;

public class Running extends Thread{
	private Comunes colaReady;
	private int procesosTerminados;
	
	
	public Running(Comunes colaReady) {
		super();
		this.colaReady = colaReady;
		this.procesosTerminados = 0;
	}
	public int getProcesosTerminados() {
		return this.procesosTerminados;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while( true ) {
			Ready ready = new Ready(this.colaReady);
			ready.start();
			try {
				ready.join();
				ProcesoG pg = ready.getProceso();
				System.out.println("[Running]: "+pg.toString());
				Bitacora bitacora = new Bitacora("[Running]: "+pg.toString());
				bitacora.writeLine();
				double sleeping = Math.random()*1000;
				Thread.sleep((long) sleeping);
				pg.setTiempoServicio(pg.getTiempoServicio()+sleeping);
				pg.setBurst(pg.getBurst()-1);
				if(pg.getBurst()>0) {
					Waiting waiting = new Waiting(this.colaReady, pg);
					waiting.start();
				}else {
					Terminated terminated = new Terminated(pg);
					terminated.start();
					terminated.join();
					this.procesosTerminados++;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
