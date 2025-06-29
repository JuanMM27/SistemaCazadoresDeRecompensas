package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Agencia {

	private Set<Cazador> cazadores = new HashSet<Cazador>();
	private Map <Zona,HashSet> zonas=new HashMap<Zona, HashSet>();

	public void agregarCazador(Cazador cazador1) {
		this.cazadores.add(cazador1);

	}

	public Integer cantidadDeCazadores() {
		return this.cazadores.size();
	}

	public void agregarZona(Zona zona) {
		this.zonas.put(zona, zona.getProfugos());
		
	}

}
