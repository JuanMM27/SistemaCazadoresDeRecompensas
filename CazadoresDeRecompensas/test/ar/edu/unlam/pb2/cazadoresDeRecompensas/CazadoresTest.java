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
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Jose", 40);
		Zona zona = new Zona("San justo", TipoDeZona.URBANO);
		zona.agregarProfugo(p1);
		cazadorUrbano.asignarZona(zona);
		assertTrue(cazadorUrbano.intentarCaptura(p1));
		assertEquals(Integer.valueOf(1),cazadorUrbano.cantidadDeProfugosCapturados());		
	}
	@Test
	public void cazadorUrbanoSeLePuedaAsignarUnaZona() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Jose", 40);
		Zona zona = new Zona("San justo", TipoDeZona.URBANO);		
		assertTrue(cazadorUrbano.asignarZona(zona));
	}
	@Test
	public void queelProfugoSeaRemovidoDeLaZona() {
		Profugo p1 = new Profugo("Pablo", 10, 10, false);
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Jose", 40);
		Zona zona = new Zona("San justo", TipoDeZona.URBANO);
		agregarProfugosALaZona(zona);
		cazadorUrbano.asignarZona(zona);
		assertTrue(cazadorUrbano.intentarCaptura(p1));		
		assertEquals(Integer.valueOf(11),zona.cantidadDeProfugos());
	}
	private void agregarProfugosALaZona(Zona zona) {
		Profugo profugo1 = new Profugo("Pablo", 10, 10, true);
		Profugo profugo2 = new Profugo("Jorge", 50, 30, false);
		Profugo profugo3 = new Profugo("Ramon", 40, 40, false);
		Profugo profugo4 = new Profugo("Leo", 60, 30, true);
		Profugo profugo5 = new Profugo("Raul", 10, 10, true);
		Profugo profugo6 = new Profugo("Martin", 50, 30, false);
		Profugo profugo7 = new Profugo("Oscar", 40, 40, false);
		Profugo profugo8 = new Profugo("Noe", 60, 30, true);
		Profugo profugo9 = new Profugo("Juan", 10, 30, true);
		Profugo profugo10 = new Profugo("Gabi", 50, 80, false);
		Profugo profugo11 = new Profugo("Mauri", 40, 10, false);
		Profugo profugo12 = new Profugo("Fer", 70, 60, true);
		Profugo[] profugos = { profugo1, profugo2, profugo3, profugo4, profugo5, profugo6, profugo7, profugo8, profugo9,
				profugo10, profugo11, profugo12 };
		for (Profugo i : profugos) {
			zona.agregarProfugo(i);
		}

	}
}
