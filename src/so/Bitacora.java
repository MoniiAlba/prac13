package so;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bitacora {
	
	private BufferedWriter bw;
	private String linea;
	
	public  Bitacora(String linea) {
		this.linea = linea;
	}
	
	public synchronized void writeLine() {
		try {
			bw = new BufferedWriter(new FileWriter("bitacora.txt", true));
			bw.append(linea);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
