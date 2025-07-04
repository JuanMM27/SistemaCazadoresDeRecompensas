package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class EntrenamientoProteccionLegal implements Entrenamiento{

	@Override
	public void entrenar(Profugo p) {
		p.bloquearReduccionDeInocenciaDebajoDe40();
	}

}
