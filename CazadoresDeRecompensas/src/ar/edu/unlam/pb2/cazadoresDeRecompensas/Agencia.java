package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Agencia {

	private Set<Cazador> cazadores = new HashSet<>();
	private Map<Zona, Set<Profugo>> zonas = new HashMap<>();
	private Map<Cazador, Set<Profugo>> mapaDeCapturas = new HashMap<>();

	public void agregarCazador(Cazador cazador1) {
		this.cazadores.add(cazador1);
	}

	public Integer cantidadDeCazadores() {
		return this.cazadores.size();
	}

	public void agregarZona(Zona zona) {
		this.zonas.put(zona, zona.getProfugos());
	}

	public Integer cantidadDeZonas() {
		return this.zonas.size();
	}

	public HashSet<Profugo> profugosPorZona(Zona zona) {
		HashSet<Profugo> consulta = null;
		if (zonas.containsKey(zona)) {
			consulta = zona.getProfugos();
		}else {
			throw new ObjetoNoEncontradoException("Zona no encontrada");
		}
		return consulta;
	}

	public Zona obtenerZona(String nombre) {
		for (Map.Entry<Zona, Set<Profugo>> i : this.zonas.entrySet()) {
			if (i.getKey().getNombre().equals(nombre)) {
				return i.getKey();
			}
		}
		throw new ObjetoNoEncontradoException("No existe el objeto");
	}

	// Mapa con las capturas hechas por cada cazador
	public Map<Cazador, Set<Profugo>> obtenerCapturasDeLosCazadores() {
	    mapaDeCapturas = new HashMap<>();
	    
	    for (Cazador cazador : cazadores) {
	        if (cazador.getZona() != null) {
	            Set<Profugo> capturados = cazador.intentarCapturaEnZonaAsignada(cazador.getZona());
	            if (!capturados.isEmpty()) {
	                mapaDeCapturas.put(cazador, capturados);
	            }
	        }
	    }
	    return mapaDeCapturas;
	}


	public Cazador getCazadorConMasCapturas() {
	    Cazador mejor = null;
	    int max = 0;
	    for (Map.Entry<Cazador, Set<Profugo>> entry : mapaDeCapturas.entrySet()) {
	        if (entry.getValue().size() > max) {
	            max = entry.getValue().size();
	            mejor = entry.getKey();
	        }
	    }
	    return mejor;
	}
	public Profugo getProfugoMasHabilCapturado() {
	    Profugo masHabil = null;
	    for (Set<Profugo> capturas : mapaDeCapturas.values()) {
	        for (Profugo p : capturas) {
	            if (masHabil == null || p.getNivelHabilidad() > masHabil.getNivelHabilidad()) {
	                masHabil = p;
	            }
	        }
	    }
	    return masHabil;
	}
}