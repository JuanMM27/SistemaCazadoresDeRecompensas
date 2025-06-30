package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class CazadorSigiloso extends Cazador{

	public CazadorSigiloso(String nombre, Integer experiencia) {
		super(nombre, experiencia);
	}
	
	@Override
	public Boolean intentarCaptura(Profugo p) {
		//Condicion 1 el nivel de experiencia del cazadpr debe ser mayor a la inocencia del profugo
		//Condicion del cazador sigiloso: Habilidad menor a 50
		return true;
	}
	@Override
	public Boolean asignarZona(Zona zona) {		
			this.zona=zona;
			return true;
	}
		

}
