package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class Profugo {

	private String nombre;
	private Integer inocencia;
	private Boolean nervioso;
	private Integer habilidad;

	public Profugo(String nombre, Integer inocencia, Integer habilidad, Boolean nervioso) {
		this.nombre=nombre;
		this.inocencia=inocencia;
		this.habilidad=habilidad;
		this.nervioso=nervioso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profugo other = (Profugo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profugo [nombre=" + nombre + "]";
	}
	
}
