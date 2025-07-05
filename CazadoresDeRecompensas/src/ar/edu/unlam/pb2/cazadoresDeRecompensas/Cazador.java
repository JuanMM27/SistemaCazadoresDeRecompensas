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
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Zona getZona() {
		return zona;
	}
	
	public Integer getExperiencia() {
		return this.experiencia;
	}

	public abstract Boolean intentarCaptura(Profugo p);// Crea la clase abstracta intentar captura, para ser
														// sobreescrita en cada cazador
	public abstract Set<Profugo> intentarCapturaEnZonaAsignada(Zona zona);

	public abstract Boolean asignarZona(Zona zona);
		
	public Integer cantidadDeProfugosCapturados() {
		return this.capturados.size();
	}

	@Override
	public int hashCode() {
	    return nombre.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;

	    Cazador other = (Cazador) obj;
	    return this.nombre.equals(other.nombre);
	}
}
