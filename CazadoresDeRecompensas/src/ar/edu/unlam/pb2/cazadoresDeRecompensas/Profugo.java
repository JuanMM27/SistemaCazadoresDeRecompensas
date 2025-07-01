package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class Profugo {

	private String nombre;
	private Integer nivelInocencia;
	private Boolean esNervioso;
	private Integer nivelHabilidad;

	public Profugo(String nombre, Integer nivelInocencia, Integer nivelHabilidad, Boolean nervioso) {
		if(nivelHabilidad < 1 || nivelHabilidad > 100) {
			throw new NivelesNoPermitidosException("La habilidad debe ser entre 1 y 100.");
		}
		if(nivelInocencia < 1) {
			throw new NivelesNoPermitidosException("El nivel de inocencia no puede ser menor a 1");
		}
		this.nombre=nombre;
		this.nivelInocencia=nivelInocencia;
		this.nivelHabilidad=nivelHabilidad;
		this.esNervioso=nervioso;
	}
	
	public Integer getNivelInocencia() {
		return this.nivelInocencia;
	}
	public Integer getNivelHabilidad() {
		return this.nivelHabilidad;
	}
	public Boolean getEsNervioso() {
		return this.esNervioso;
	}
	

	public void setEsNervioso(Boolean esNervioso) {
		this.esNervioso = esNervioso;
	}
	

	public void setNivelHabilidad(Integer nivelHabilidad) {
		this.nivelHabilidad = nivelHabilidad;
	}
	public void habilidadIntimada(Integer descuento) {
		this.nivelHabilidad-=descuento;
		
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
		return "Profugo [Nombre: " + this.nombre + ", Nivel Inocencia: "+this.nivelInocencia+
				", Nivel Habilidad: "+this.nivelHabilidad+", Es nervioso: "+this.esNervioso+"]";
	}


	
}
