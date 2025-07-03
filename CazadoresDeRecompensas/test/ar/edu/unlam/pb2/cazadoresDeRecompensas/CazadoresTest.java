package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;


import org.junit.Test;

public class CazadoresTest {

	@Test
	public void queAlCazadorSeLePuedaAsignarUnaZona() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Jose", 40);
		Zona zona = new Zona("San justo");
		agregarProfugosALaZona(zona);
		CazadorRural cazadorRural = new CazadorRural("Marco", 50);
		Zona zona1 = new Zona("Chascomus");
		agregarProfugosALaZona(zona1);
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Juanjo", 80);
		Zona zona2 = new Zona("Chascomus");
		agregarProfugosALaZona(zona2);
		assertTrue(cazadorUrbano.asignarZona(zona));
		assertTrue(cazadorRural.asignarZona(zona1));
		assertTrue(cazadorSigiloso.asignarZona(zona2));
	}

	@Test
	public void queAlCazadorNoSeLePuedaAsignarUnaZonaVacia() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Jose", 40);
		Zona zona = new Zona("San justo");
		assertFalse(cazadorUrbano.asignarZona(zona));

	}

	@Test
	public void crearUnCazadorSigilosoQueIntentaCapturarUnProfugoConHabildadMayorACincuenta() {
		Profugo p1 = new Profugo("Pablo", 10, 60, false);
		CazadorSigiloso cazador = new CazadorSigiloso("Juanjo", 80);
		Zona zona = new Zona("Chascomus");
		zona.agregarProfugo(p1);
		cazador.asignarZona(zona);
		assertTrue(cazador.intentarCaptura(p1));
	}

	@Test
	public void crearUnCazadorSigilosoQueIntentaCapturarUnProfugoEnUnaZonaYSiNoLoCapturaLosIntimida() {
		Profugo p1 = new Profugo("Pablo", 50, 60, false);
		CazadorSigiloso cazador = new CazadorSigiloso("Juanjo", 40);
		Zona zona = new Zona("Chascomus");
		zona.agregarProfugo(p1);
		cazador.asignarZona(zona);
		cazador.intentarCaptura(p1);
		assertEquals(Integer.valueOf(55), p1.getNivelHabilidad());
	}

	@Test
	public void crearUnCazadorRuralQueIntentaCapturarUnProfugoNoNervioso() {
		Profugo p1 = new Profugo("Pablo", 10, 10, true);
		CazadorRural cazador = new CazadorRural("Marco", 50);
		Zona zona = new Zona("Chascomus");
		zona.agregarProfugo(p1);
		cazador.asignarZona(zona);
		assertTrue(cazador.intentarCaptura(p1));
	}
	@Test
	public void crearUnCazadorRuralQueIntentaCapturarProfugosEnUnaZona() {
		CazadorRural cazador = new CazadorRural("Marco", 50);
		Zona zona = new Zona("Chascomus");
		agregarProfugosALaZona(zona);
		cazador.asignarZona(zona);
		cazador.intentarCapturaEnZonaAsignada(zona);
		assertEquals(Integer.valueOf(3),cazador.cantidadDeProfugosCapturados());
	}

	@Test
	public void cazadorUrbanoIntentaCapturarUnProfugoNoNervioso() {
		Profugo p1 = new Profugo("Pablo", 10, 10, false);
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Jose", 40);
		Zona zona = new Zona("San justo");
		zona.agregarProfugo(p1);
		cazadorUrbano.asignarZona(zona);
		assertTrue(cazadorUrbano.intentarCaptura(p1));
		assertEquals(Integer.valueOf(1), cazadorUrbano.cantidadDeProfugosCapturados());
	}

	
	@Test
	public void queElProfugoSeaRemovidoDeLaZona() {
		Profugo p1 = new Profugo("Pablo", 10, 10, false);
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Jose", 40);
		Zona zona = new Zona("San justo");
		agregarProfugosALaZona(zona);
		cazadorUrbano.asignarZona(zona);
		assertTrue(cazadorUrbano.intentarCaptura(p1));
		assertEquals(Integer.valueOf(11), zona.cantidadDeProfugos());
	}

	@Test
	public void queElProfugoSeanIntimidados() {
		Profugo p1 = new Profugo("Pablo", 10, 10, true);
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Jose", 40);
		Zona zona = new Zona("San justo");
		zona.agregarProfugo(p1);
		cazadorUrbano.asignarZona(zona);
		Profugo profugo = zona.buscarProfugo(p1);
		cazadorUrbano.intentarCaptura(p1);
		assertFalse(profugo.getEsNervioso());
		assertEquals(Integer.valueOf(8), profugo.getNivelInocencia());
	}

	@Test(expected = ObjetoNoEncontradoException.class)
	public void queElProfugoBuscadoSeaNuloYLanceUnaExcepcion() {
		Profugo p1 = new Profugo("Pablo", 10, 10, true);
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Jose", 40);
		Zona zona = new Zona("San justo");
		cazadorUrbano.asignarZona(zona);
		Profugo profugo = zona.buscarProfugo(p1);
		cazadorUrbano.intentarCaptura(p1);
		assertFalse(profugo.getEsNervioso());
		assertEquals(Integer.valueOf(8), profugo.getNivelHabilidad());
	}

	@Test
	public void queElProfugoSeanIntimidadosYQueLaIntimaionNoDejeSuHabilidadMenorACero() {
		Profugo p1 = new Profugo("Pablo", 1, 1, true);
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Jose", 40);
		Zona zona = new Zona("San justo");
		zona.agregarProfugo(p1);
		cazadorUrbano.asignarZona(zona);
		Profugo profugo = zona.buscarProfugo(p1);
		cazadorUrbano.intentarCaptura(p1);
		assertFalse(profugo.getEsNervioso());
		assertEquals(Integer.valueOf(0), profugo.getNivelInocencia());
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
