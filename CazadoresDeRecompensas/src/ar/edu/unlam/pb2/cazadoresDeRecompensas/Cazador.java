package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Cazador {

	protected String nombre;
	protected Integer experiencia;
	protected Zona zona;
	protected List<Profugo> capturados = new ArrayList<Profugo>(); // Esto se podria cambiar a un HashSet para evitar
																	// duplicados

	public Cazador(String nombre, Integer experiencia) {
		this.nombre = nombre;
		this.experiencia = experiencia;
	}

	public String getNombre() {
		return nombre;
	}

	public abstract Boolean intentarCaptura(Profugo p);// Crea la clase abstracta intentar captura, para ser
														// sobreescrita en cada cazador
	public abstract Set<Profugo> intentarCapturaEnZonaAsignada(Zona zona);

	public abstract Boolean asignarZona(Zona zona);
		
	public Integer cantidadDeProfugosCapturados() {
		return this.capturados.size();
	}
	@Override
	public String toString() {
	    return "Cazador: " + this.nombre + 
	           " | Experiencia: " + this.experiencia +
	           " | Zona asignada: " + (this.zona != null ? zona.getNombre() : "Ninguna") +
	           " | Capturas: " + this.capturados.size();
	}

}
