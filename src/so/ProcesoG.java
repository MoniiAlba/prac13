package so;

import java.util.ArrayList;

public class ProcesoG implements Comparable{

	private String nombre;
	private int burst;
	private double tiempoServicio;
	private double tiempoEspera;
	private ArrayList<Integer> paginasAsignadas;
	private int numPags;
	
	public ProcesoG(String nombre, int burst) {
		this.nombre = nombre;
		this.burst = burst;
		this.tiempoEspera = 0.0;
		this.tiempoServicio = 0.0;
		
	}
	public ProcesoG(String nombre, int burst, int numPags) {
		this.nombre = nombre;
		this.burst = burst;
		this.tiempoEspera = 0.0;
		this.tiempoServicio = 0.0;
		this.numPags = numPags;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getBurst() {
		return burst;
	}

	public void setBurst(int burst) {
		this.burst = burst;
	}

	public double getTiempoServicio() {
		return tiempoServicio;
	}

	public void setTiempoServicio(double tiempoServicio) {
		this.tiempoServicio = tiempoServicio;
	}

	public double getTiempoEspera() {
		return tiempoEspera;
	}

	public void setTiempoEspera(double tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}

	/**
	 * @param paginasAsignadas the paginasAsignadas to set
	 */
	public void setPaginasAsignadas(ArrayList<Integer> paginasAsignadas) {
		this.paginasAsignadas = paginasAsignadas;
	}

	/**
	 * @return the paginasAsignadas
	 */
	public ArrayList<Integer> getPaginasAsignadas() {
		return paginasAsignadas;
	}

	/**
	 * @return the numPags
	 */
	public int getNumPags() {
		return numPags;
	}
	
	public String toString() {
		return nombre + ": burst("+ burst+"); tEspera("+ tiempoEspera +" ms); tServicio("
		+ tiempoServicio+" ms) ";
		
	}

	public String printPageTable(){
		StringBuilder str = new StringBuilder();
		if( paginasAsignadas != null){
			for (int indicePag : this.paginasAsignadas) {
				str.append(indicePag + " ");
			}
		}
		return str.toString();
	}

	@Override
	public int compareTo(Object o) {
		ProcesoG otro = (ProcesoG) o;

		return this.numPags - otro.numPags;
	}
	
	@Override
	public boolean equals(Object obj) {
		ProcesoG otro = (ProcesoG) obj;
		return otro.getNombre().equals(otro.getNombre());
	}

	public boolean estaEnMemoria(){
		return this.paginasAsignadas != null ;
	}
	
	
	
	
}
