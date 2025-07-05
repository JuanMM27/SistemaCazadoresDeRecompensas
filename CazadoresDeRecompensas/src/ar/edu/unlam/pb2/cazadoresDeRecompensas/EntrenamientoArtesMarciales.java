package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class EntrenamientoArtesMarciales implements Entrenamiento{

	@Override
	public void entrenar(Profugo p) {
		Integer nuevoNivelHabilidad = Math.min(100, p.getNivelHabilidad() + 5);
		p.setNivelHabilidad(nuevoNivelHabilidad);		
	}
	
	
}
