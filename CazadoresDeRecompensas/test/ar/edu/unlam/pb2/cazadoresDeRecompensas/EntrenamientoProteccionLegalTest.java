package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class EntrenamientoProteccionLegalTest {

	@Test
	public void queUnProfugoNoPuedeTenerMenosDe40DeNivelDeInocenciaConProteccionLegal() {
		Profugo p1 = new Profugo("Jorge", 45, 100, true);
		p1.entrenarProteccionLegal();//Esto lo entrenaria y lo subiria a 105, pero si el metodo esta bien hecho, deberia limitarse en 100
		p1.setNivelHabilidad(20);
		assertEquals(Integer.valueOf(45), p1.getNivelInocencia());
	}

}
