package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class EntrenamientoElite implements Entrenamiento{

	@Override
	public void entrenar(Profugo p) {
		p.setEsNervioso(false);
		p.bloquearNerviosismo();
	}

}
