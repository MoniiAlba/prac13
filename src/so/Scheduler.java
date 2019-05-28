package so;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import estados.Comunes;
import estados.New;
import estados.Running;
import estados.Terminated;

public class Scheduler {


	public static void main(String[] args) {
		int totalProcesos = 0;
		Comunes colaReady = new Comunes(10);
		BufferedReader br = null;
		Running run = new Running(colaReady);
		run.start();
		try {
			br = new BufferedReader(new FileReader("cmdbatchSM.txt"));
		    String line = br.readLine();
		    String[] temp;
		    while (line != null) {
		    	totalProcesos++;
		    	temp = line.split(" ");
		    	New n = new New(temp[1], Integer.parseInt(temp[2]), colaReady, Integer.parseInt(temp[3]));
		    	n.start();
		        line = br.readLine();
			}
			//totalProcesos = ;
			System.out.println("[Scheduler]: Total procesos " + totalProcesos);
		    while( totalProcesos > Terminated.getProcesosTerminados()) {
		    	System.out.print("");
		    }
			System.out.println("[Scheduler]: Carga terminada");
			Bitacora bitacora = new Bitacora("[Scheduler]: Carga terminada");
			bitacora.writeLine();
		    System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}

	}

}
