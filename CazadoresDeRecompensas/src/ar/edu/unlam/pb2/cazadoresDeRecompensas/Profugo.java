package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class Profugo {

	private String nombre;
	private Integer nivelInocencia;
	private Boolean esNervioso, nerviosismoBloqueado, inocenciaMinima40;
	private Integer nivelHabilidad;

	public Profugo(String nombre, Integer nivelInocencia, Integer nivelHabilidad, Boolean nervioso) {
		if (nivelHabilidad < 1 || nivelHabilidad > 100) {
			throw new NivelesNoPermitidosException("La habilidad debe ser entre 1 y 100.");
		}
		if (nivelInocencia < 1) {
			throw new NivelesNoPermitidosException("El nivel de inocencia no puede ser menor a 1");
		}
		this.nombre = nombre;
		this.nivelInocencia = nivelInocencia;
		this.nivelHabilidad = nivelHabilidad;
		this.esNervioso = nervioso;
		this.nerviosismoBloqueado = false;
		this.inocenciaMinima40 = false;
	}

	public Integer getNivelInocencia() {
		return this.nivelInocencia;
	}

	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getNivelHabilidad() {
		return this.nivelHabilidad;
	}

	public Boolean getEsNervioso() {
		return this.esNervioso;
	}

	public void setEsNervioso(Boolean esNervioso) {
		if (nerviosismoBloqueado && esNervioso == true) {
			return;// Corta el codigo y no permite cambiar si es nervioso o no
		}
		this.esNervioso = esNervioso;
	}

	public void setNivelHabilidad(Integer nivelHabilidad) {
		this.nivelHabilidad = nivelHabilidad;
	}

	public void habilidadIntimada(Integer descuento) {
		if(this.nivelHabilidad<descuento) {
			this.nivelHabilidad=0;
		}else
		this.nivelHabilidad-=descuento;
		
	}
	public void inocenciaIntimada(Integer descuento) {
		if(this.nivelInocencia<descuento) {
			this.nivelInocencia=0;
		}else {
		this.nivelInocencia-=descuento;
		}
		
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

	public void entrenarArtesMarciales() {
		new EntrenamientoArtesMarciales().entrenar(this);
	}

	public void entrenarElite() {
		new EntrenamientoElite().entrenar(this);
	}

	public void bloquearNerviosismo() {
		this.nerviosismoBloqueado = true;
	}

	public void entrenarProteccionLegal() {
		new EntrenamientoProteccionLegal().entrenar(this);
	}

	public void bloquearReduccionDeInocenciaDebajoDe40() {
		this.inocenciaMinima40 = true;
	}

	public void reducirNivelInocencia(Integer cantidad) {
		Integer nueva = this.nivelInocencia - cantidad;
		if (inocenciaMinima40) {
			nueva = Math.max(40, nueva);
		} else {
			nueva = Math.max(0, nueva);
		}
		this.nivelInocencia = nueva;
	}

	

}
