package estados;

import java.util.LinkedList;
import java.util.Queue;
import so.ProcesoG;

public class Comunes {

	private Queue<ProcesoG> cola;
	private int tamMax;
	
	public Comunes(int tam) {
		this.cola = new LinkedList<>();
		this.tamMax = tam;
	}
	
	public synchronized void add (ProcesoG proceso) {
		while(this.cola.size() >= this.tamMax) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.cola.add(proceso);
		notifyAll();
	}
	
	public synchronized ProcesoG remove () {
		while(this.cola.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ProcesoG pg = this.cola.remove();
		notifyAll();
		return pg;
	}
}
