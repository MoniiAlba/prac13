package estados;

import so.Bitacora;
import so.MemCen;
import so.ProcesoG;
import so.SingletonMemCen;
import so.SingletonSwap;
import so.Swap;

public class Ready extends Thread  {
	private Comunes cola;
	private ProcesoG proceso;
	
	public Ready(Comunes cola) { //para sacar de la cola
		this.cola = cola;
		this.proceso = null;
	}
	
	public Ready (Comunes cola, ProcesoG pg) {
		this.cola = cola;
		this.proceso = pg;
	}
	
	public void add (ProcesoG p) {
		this.cola.add(p);
	}
	
	public ProcesoG remove() {
		return this.cola.remove();
	}
	
	public ProcesoG getProceso() {
		return proceso;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Swap sw = SingletonSwap.getInstance();
		MemCen mem = SingletonMemCen.getInstance();
/* 		System.out.println("[Swap]: isEmpty "+sw.isEmpty());
		Bitacora bitacora1 = new Bitacora("[Swap]: isEmpty "+sw.isEmpty());
		bitacora1.writeLine();
		Bitacora bitacora2 = new Bitacora("[Swap]: elementos "+sw.procesos);
		bitacora2.writeLine(); */
		if( !sw.isEmpty() ){
			ProcesoG proc = sw.pop();
			if( !mem.asignarMemoria(proc) )
				sw.push(proc);
			else
				this.add(proc);

		}
		if(this.proceso == null) {
			this.proceso = this.remove();
			
		}else {
			if(this.proceso.estaEnMemoria() || mem.asignarMemoria(this.proceso)){
				System.out.println("[Ready]: "+this.proceso.toString());
				Bitacora bitacora = new Bitacora("[Ready]: "+this.proceso.toString());
				bitacora.writeLine();
				this.add(this.proceso);
			}
			else
				sw.push(this.proceso);
		}
	}
}
