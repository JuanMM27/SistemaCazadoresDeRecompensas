package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class CazadorUrbano extends Cazador {

	public CazadorUrbano(String nombre, Integer experiencia) {
		super(nombre, experiencia);
	}

	@Override
	public Boolean intentarCaptura(Profugo p) {
		// Condicion 1 el nivel de experiencia del cazadpr debe ser mayor a la inocencia
		// del profugo
		// Condicion del cazador urbano: que el profugo no sea nervioso
		if (this.experiencia > p.getNivelInocencia() && p.getEsNervioso() == false) {
			this.capturados.add(p);
			this.zona.removerProfugo(p);
			return true;
		} else {
			p.habilidadIntimada(2);
			p.setEsNervioso(false);
			return false;
		}

	}
	@Override
	public Boolean asignarZona(Zona zona) {
		if (zona.getTipoDeZona() == TipoDeZona.URBANO) {
			this.zona = zona;
			return true;
		}
		return false;
	}

}
