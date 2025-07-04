package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZonaTest {

	@Test
	public void queSePuedacrearUnaZona() {
		Zona zona = new Zona("Lanus");
		assertNotNull(zona);
	}
	@Test
	public void queSePuedacrearUnaZonaYAgregarProfugos() {
		Zona zona = new Zona("Lanus");
		agregarProfugosALaZona(zona);
		assertEquals(Integer.valueOf(12),zona.cantidadDeProfugos());
	}
	@Test
	public void queSePuedaRemoverProfugosDeLaZona() {
		Zona zona = new Zona("Lanus");
		agregarProfugosALaZona(zona);
		Profugo profugo1 = new Profugo("Pablo", 10, 10, true);
		Profugo profugo2 = new Profugo("Jorge", 50, 30, false);
		zona.removerProfugo(profugo1);
		zona.removerProfugo(profugo2);
		assertEquals(Integer.valueOf(10),zona.cantidadDeProfugos());
	}
	@Test(expected = ObjetoNoEncontradoException.class)
	public void queNoSePuedaRemoverUnProfugoDosVeces() {
		Zona zona = new Zona("Lanus");
		agregarProfugosALaZona(zona);
		Profugo profugo1 = new Profugo("Pablo", 10, 10, true);
		zona.removerProfugo(profugo1);
		zona.removerProfugo(profugo1);
		assertEquals(Integer.valueOf(10),zona.cantidadDeProfugos());
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
