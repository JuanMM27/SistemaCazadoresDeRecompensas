package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class CazadorRural extends Cazador{

	public CazadorRural(String nombre, Integer experiencia) {
		super(nombre, experiencia);
	}

	@Override
	public Boolean intentarCaptura(Profugo p) {
		//Condicion 1 el nivel de experiencia del cazadpr debe ser mayor a la inocencia del profugo
		//Condicion del cazador rural: El profugo debe ser nervioso
		return true;
	}
	@Override
	public Boolean asignarZona(Zona zona) {
		if(zona.getTipoDeZona()==TipoDeZona.RURAL) {
			this.zona=zona;
			return true;
		}
		return false;
	}
}
