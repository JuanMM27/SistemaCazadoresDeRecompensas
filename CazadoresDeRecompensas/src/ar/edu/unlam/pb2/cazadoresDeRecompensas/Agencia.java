/*package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Agencia {

	private Set<Cazador> cazadores = new HashSet<Cazador>();
	private Map<Zona, Set<Profugo>> zonas = new HashMap<Zona, Set<Profugo>>();

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
	//Metodo para obtener un map con las capturas hechas por cada cazador
	public Map<Cazador, Set<Profugo>> obtenerCapturasDeLosCazadores(){
		Map<Cazador, Set<Profugo>> capturas = new HashMap<>();
		
		for(Cazador cazador : cazadores) {
			Zona zona = cazador.getZona();
			if(zona != null) {
				Set<Profugo> profugosCapturados = cazador.intentarCapturaEnZonaAsignada(zona);
				if(!profugosCapturados.isEmpty()) {
					 if (!capturas.containsKey(cazador)) {
		                    capturas.put(cazador, new HashSet<>());//Si no contiene la clave, crea un HashSet nuevo para los capturados
		                }
		                capturas.get(cazador).addAll(profugosCapturados);
		                cazador.capturados.addAll(profugosCapturados);
				}
			}
		}
		return capturas;
	}
	
	public Profugo getProfugoMasHabilCapturado() {
		Map<Cazador, Set<Profugo>> capturas = obtenerCapturasDeLosCazadores();
		Profugo masHabil = null;
		
		for(Set<Profugo> profugos : capturas.values()) {
	        for (Profugo p : profugos) {
	            if (masHabil == null || p.getNivelHabilidad() > masHabil.getNivelHabilidad()) {
	            	//Si el nivel de habilidad del profugo iterado es mayor al del objeto guardado, lo sobreescribimos
	                masHabil = p;
	            }
	        }
	    }
		if (masHabil == null) {
		    System.out.println("No se encontró ningún prófugo capturado.");
		} else {
		    System.out.println("Prófugo más hábil encontrado: " + masHabil.getNombre() + " (habilidad: " + masHabil.getNivelHabilidad() + ")");
		}
	    return masHabil;
	}
	
	public Cazador getCazadorConMasCapturas() {
	    Map<Cazador, Set<Profugo>> capturas = obtenerCapturasDeLosCazadores();
	    Cazador mejorCazador = null;
	    Integer maxCapturas = 0;

	    for (Cazador c : capturas.keySet()) {
	        int cantidad = capturas.get(c).size();
	        if (mejorCazador == null || cantidad > maxCapturas) {
	            mejorCazador = c;
	            maxCapturas = cantidad;
	        }
	    }

	    return mejorCazador;
	}
}
*/
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

	private Profugo getProfugoMasHabilCapturado(Map<Cazador, Set<Profugo>> capturas) {
	    Profugo masHabil = null;
	    for (Set<Profugo> profugos : capturas.values()) {
	        for (Profugo p : profugos) {
	            if (masHabil == null || p.getNivelHabilidad() > masHabil.getNivelHabilidad()) {
	                masHabil = p;
	            }
	        }
	    }
	    return masHabil;
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