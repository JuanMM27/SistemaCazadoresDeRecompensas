package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Agencia {

	private Set<Cazador> cazadores = new HashSet<Cazador>();
	private Map<Zona, Set<Profugo>> zonas = new HashMap<Zona, Set<Profugo>>();

	public Boolean agregarCazador(Cazador cazador1) {		
			return this.cazadores.add(cazador1);	

	}

	public Integer cantidadDeCazadores() {
		return this.cazadores.size();
	}
	public void agregarZona(Zona zona) {
		if(!zona.getProfugos().isEmpty())
		this.zonas.put(zona, zona.getProfugos());

	}
	public Integer cantidadDeZonas() {
		return this.zonas.size();
	}

	public HashSet<Profugo> profugosPorZona(Zona zona) {
		if (zonas.containsKey(zona)) {
			return zona.getProfugos();			
		}
		throw new ObjetoNoEncontradoException("No existe el objeto");
	}

	public Zona obtenerZona(String nombre) {
		for (Map.Entry<Zona, Set<Profugo>> i : this.zonas.entrySet()) {
			if (i.getKey().getNombre().equals(nombre)) {
				return i.getKey();
			}
		}
		throw new ObjetoNoEncontradoException("No existe el objeto");

	}
	//Metodo para obtener un map con las capturas hechas por cada cazador
	//public Map<Cazador, Set<Profugo>> obtenerCapturasDeLosCazadores(){
		//Map<Cazador, Set<Profugo>> capturas = new HashMap<>();
		
		//for(Cazador cazador : cazadores) {
		
		//}
	
}
