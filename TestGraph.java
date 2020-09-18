package Graph;

public class TestGraph {

	public static void main(String a[]) {
		Graph grafo = new Graph();
		grafo.addNode(1); // Nodo agregado con éxito
		grafo.addNode(3); // Nodo agregado con éxito
		grafo.addNode(1); // Nodo no agregado (YA EXISTE)
		grafo.addEdge(2, 3); // Arco no agregado (NO EXISTE NODO '2')
		grafo.addEdge(1, 3); // Arco agregado con éxito
		grafo.addEdge(1, 3); // Arco no agregado (YA EXISTE)
		grafo.removeEdge(1, 3); // Arco removido con éxito
		grafo.removeNode(1); // Nodo removido con éxito
		grafo.removeEdge(1, 3); // Arco no removido (YA SE REMOVIÓ)
	}
}
