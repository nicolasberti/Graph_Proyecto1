package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Graph {

	private List<Nodo> nodes;
	private List<Arco> arcos;
	private static Logger logger;
	
	public Graph() {
		nodes = new ArrayList<Nodo>();
		arcos = new ArrayList<Arco>();
		
		if (logger == null){
			
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
	}
	
	public void addNode(int node) {
		int index = nodes.indexOf(new Nodo(node));
		logger.info("addNode: [Nodo: "+ node +"] - Index: "+ index);
		if(index < 0) {
			logger.fine("El nodo se agregó correctamente.");
			nodes.add(new Nodo(node));
		}
		else 
			logger.warning("El nodo no pudo ser agregado tal que ya existe.");
	}
	
	public void addEdge(int node1, int node2) {
		int index_node1 = nodes.indexOf(new Nodo(node1));
		int index_node2 = nodes.indexOf(new Nodo(node2));
		logger.info("addEdge: [Nodo 1: "+ node1 +" - Index: "+index_node1+"] [Nodo 2: "+node2+" - Index: "+index_node2+"]");
		if(index_node1 >= 0 && index_node2 >= 0) { // Comprueba que existan los nodos
			int index_arco = arcos.indexOf(new Arco(nodes.get(index_node1), nodes.get(index_node2)));
			logger.info("addEdge: [Arco de Nodo ["+node1+"] a Nodo ["+node2+"] - Index del Arco: "+index_arco);
			if(index_arco < 0) {// Comprueba que el arco no esté
				Arco arco = new Arco(nodes.get(index_node1), nodes.get(index_node2));
				arcos.add(arco);
				logger.fine("El arco se agregó correctamente.");
			}
			else 
				logger.warning("El arco no pudo ser agregado tal que ya existe.");
		} 
		else
			logger.warning("El arco no pudo ser agregado ya que alguno de los nodos no existe.");
			
	}
	
	public void removeNode(int node) {
		int index = nodes.indexOf(new Nodo(node));
		logger.info("removeNode: [Nodo: "+ node +"] - Index: "+ index);
		if(index >= 0) {
			/*
			 * OBS: En removeNode hay que remover los arcos que tengna como node1 a node o viceversa (que node sea node2)
			 *
			 */
			Iterator<Arco> it = arcos.iterator();
			List<Arco> arcosEliminar = new ArrayList<Arco>();
			while(it.hasNext()) {
				Arco arco = it.next();
				if(arco.getNodo1().getElemento() == node)
					arcosEliminar.add(arco);
				else if(arco.getNodo2().getElemento() == node)
					arcosEliminar.add(arco);
			}
			arcos.removeAll(arcosEliminar); // Utilizo este método para eliminar todos los arcos
			// OBS 2: Tal que se que los nodos existen y de más, no es necesario hacer la verificación asi que simplemente uso esto en vez de invocar al metodo removeEdge.
			nodes.remove(index);
			logger.fine("El nodo fue removido correctamente.");
		}
		else 
			logger.warning("El nodo no pudo ser removido tal que no existe.");
	}
	
	public void removeEdge(int node1, int node2) {
		int index_node1 = nodes.indexOf(new Nodo(node1));
		int index_node2 = nodes.indexOf(new Nodo(node2));
		logger.info("removeEdge: [Nodo 1: "+ node1 +" - Index: "+index_node1+"] [Nodo 2: "+node2+" - Index: "+index_node2+"]");
		if(index_node1 >= 0 && index_node2 >= 0) { // Comprueba que existan los nodos
			int index_arco = arcos.indexOf(new Arco(nodes.get(index_node1), nodes.get(index_node2)));
			if(index_arco >= 0) {// Comprueba que el arco exista
				arcos.remove(index_arco);
				logger.fine("El arco fue removido correctamente.");
			}
			else 
				logger.warning("El arco no pudo ser agregado tal que ya existe.");
		}
		else 
			logger.warning("El arco no pudo ser removido tal que alguno de los nodos no existe.");
	}
	
	
}
