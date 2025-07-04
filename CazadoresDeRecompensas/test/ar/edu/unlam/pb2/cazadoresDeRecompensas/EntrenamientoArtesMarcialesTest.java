package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class EntrenamientoArtesMarcialesTest {

	@Test
	public void queUnProfugoPuedaSerEntrenadoEnArtesMarciales() {
		Profugo p1 = new Profugo("Jorge", 20, 90, true);
		p1.entrenarArtesMarciales();
		assertEquals(Integer.valueOf(95), p1.getNivelHabilidad());
	}
	@Test
	public void queUnProfugoNoPuedaEntrenarseMasAllaDelNivel100DeHabilidad() {
		Profugo p1 = new Profugo("Jorge", 20, 100, true);
		p1.entrenarArtesMarciales();//Esto lo entrenaria y lo subiria a 105, pero si el metodo esta bien hecho, deberia limitarse en 100
		assertEquals(Integer.valueOf(100), p1.getNivelHabilidad());
	}
	@Test
	public void queUnProfugoSePuedaEntrenarseParaNoSerCapturadoPorUnCazadorSigiloso() {
		Profugo p1 = new Profugo("Jorge", 48, 48, true);
		Cazador c1=new CazadorSigiloso("Carlos",80);
		Zona zona=new Zona("San justo");
		zona.agregarProfugo(p1);
		p1.entrenarArtesMarciales();
		assertFalse(c1.intentarCaptura(p1));
		assertEquals(Integer.valueOf(48),p1.getNivelHabilidad());
	}
	@Test
	public void queUnProfugoSePuedaEntrenarseParaNoSerCapturadoPorUnCazadorUrbano() {
		Profugo p1 = new Profugo("Jorge", 48, 48, true);
		Cazador c1=new CazadorUrbano("Carlos",80);
		Zona zona=new Zona("San justo");
		zona.agregarProfugo(p1);
		p1.entrenarArtesMarciales();
		assertFalse(c1.intentarCaptura(p1));
		assertEquals(Integer.valueOf(46),p1.getNivelInocencia());
	}
	

}
