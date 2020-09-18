package Graph;

public class Arco {

	private Nodo nodo1; 
	private Nodo nodo2;
	
	public Arco(Nodo nodo1, Nodo nodo2) {
		this.nodo1 = nodo1;
		this.nodo2 = nodo2;
	}
	
	public Nodo getNodo1() { return nodo1; }
	public Nodo getNodo2() { return nodo2; }
	
	// OBS: Intenté hacerlo como el repositorio de ejemplo, y noté que si ponía 'Arco' en vez de 'Object' en el parámetro, no 
	public boolean equals(Object arco) {
		return ( (nodo1.getElemento() == ((Arco)arco).getNodo1().getElemento() ) && ( nodo2.getElemento()==((Arco)arco).getNodo2().getElemento()) );
	}
	
	
}
