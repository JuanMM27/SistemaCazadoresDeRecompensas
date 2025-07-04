package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class ObjetoNoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjetoNoEncontradoException(String mensaje) {
		super(mensaje);
	}
	
}
