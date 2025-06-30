package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class CazadoresTest {

	@Test
	public void crearUnCazadorSigilosoQueIntentaCapturarUnProfugoNoNervioso() {
		Profugo p1 = new Profugo("Pablo", 10, 10, false);
		CazadorSigiloso cs1 = new CazadorSigiloso("Juanjo", 80);
		assertTrue(cs1.intentarCaptura(p1));
	}
	
	@Test
	public void crearUnCazadorRuralQueIntentaCapturarUnProfugoNoNervioso() {
		Profugo p1 = new Profugo("Pablo", 10, 10, false);
		CazadorRural cr1 = new CazadorRural("Marco", 50);
		assertTrue(cr1.intentarCaptura(p1));
	}
	
	@Test
	public void cazadorUrbanoIntentaCapturarUnProfugoNoNervioso() {
		Profugo p1 = new Profugo("Pablo", 10, 10, false);
		CazadorUrbano cu1 = new CazadorUrbano("Jose", 40);
		assertTrue(cu1.intentarCaptura(p1));
	}
}
