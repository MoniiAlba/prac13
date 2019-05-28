package estados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import so.Bitacora;
import so.MemCen;
import so.ProcesoG;
import so.SingletonMemCen;

public class Terminated extends Thread{

	private ProcesoG pg;
	private static int procesosTerminados = 0;
	
	public static int getProcesosTerminados() {
		return procesosTerminados;
	}
	
	public Terminated(ProcesoG pg) {
		this.pg = pg;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("[Terminated]: "+pg.toString());
		MemCen mem = SingletonMemCen.getInstance();
		mem.liberarMemoria(pg);
		Bitacora bitacora = new Bitacora("[Terminated]: "+this.pg.toString());
		bitacora.writeLine();
		Terminated.procesosTerminados++;
		System.out.println("[Terminated]: Procesos terminados "+Terminated.procesosTerminados);
		bitacora = new Bitacora("[Terminated]: Procesos terminados "+Terminated.procesosTerminados);
		bitacora.writeLine();
	}
}
