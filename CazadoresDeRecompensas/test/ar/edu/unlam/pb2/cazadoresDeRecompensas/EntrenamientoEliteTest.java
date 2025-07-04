package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class EntrenamientoEliteTest {

	@Test
	public void queUnProfugoPuedeRealizarEntrenamientoDeElite() {
		Profugo p1 = new Profugo("Jorge", 20, 100, true);
		p1.entrenarElite();//Esto lo entrenaria y lo subiria a 105, pero si el metodo esta bien hecho, deberia limitarse en 100
		assertFalse(p1.getEsNervioso());
	}
	@Test
	public void queNoSePuedaCambiarSiEsNerviosoPorEntrenamientoDeElite() {
		Profugo p1 = new Profugo("Jorge", 20, 100, true);
		p1.entrenarElite();//Esto lo entrenaria y lo subiria a 105, pero si el metodo esta bien hecho, deberia limitarse en 100
		p1.setEsNervioso(true);
		assertFalse(p1.getEsNervioso());
	}

}
