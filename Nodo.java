package Graph;

public class Nodo {
	
	private int elemento;
	
	public Nodo(int elemento) {
		this.elemento = elemento;
	}
	
	public int getElemento() { return elemento; }
	public void setElemento(int elemento) { this.elemento = elemento; }
	
	public boolean equals(Object nodo) {
		return elemento == ((Nodo)nodo).getElemento();
	}
	
}
