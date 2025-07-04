package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class ZonaTest {
	
	private Zona zona = new Zona("Lanus");
	
	@Test
	public void queSePuedacrearUnaZona() {		
		assertNotNull(zona);
	}
	@Test
	public void queSePuedacrearUnaZonaYSaberSuNombre() {		
		assertEquals(zona.getNombre(),"Lanus");
	}
	@Test
	public void queSePuedacrearUnaZonaYSQueDevuelvaLaListaDeProfugos() {		
		Profugo profugo1 = new Profugo("Pablo", 10, 10, true);
		Profugo profugo2 = new Profugo("Jorge", 50, 30, false);
		zona.agregarProfugo(profugo1);
		zona.agregarProfugo(profugo2);
		HashSet<Profugo> esperado=new HashSet<Profugo>();
		esperado.add(profugo1);
		esperado.add(profugo2);
		HashSet<Profugo> obtenido=zona.getProfugos();
		assertEquals(obtenido,esperado);
	}
	@Test
	public void queSePuedacrearUnaZonaYAgregarProfugos() {		
		agregarProfugosALaZona(zona);
		assertEquals(Integer.valueOf(12),zona.cantidadDeProfugos());
	}
	@Test
	public void queSePuedaBuscarProfugos() {		
		Profugo profugo1 = new Profugo("Pablo", 10, 10, true);		
		zona.agregarProfugo(profugo1);
		assertEquals(profugo1, zona.buscarProfugo(profugo1));
		
	}
	@Test(expected = ObjetoNoEncontradoException.class)
	public void queancaUnaExcepcionSiElProfugoNoEstaEnaLaZona() {		
		Profugo profugo1 = new Profugo("Pablo", 10, 10, true);		
		zona.buscarProfugo(profugo1);
		
	}
	@Test
	public void queSePuedaRemoverProfugosDeLaZona() {		
		agregarProfugosALaZona(zona);
		Profugo profugo1 = new Profugo("Pablo", 10, 10, true);
		Profugo profugo2 = new Profugo("Jorge", 50, 30, false);
		zona.removerProfugo(profugo1);
		zona.removerProfugo(profugo2);
		assertEquals(Integer.valueOf(10),zona.cantidadDeProfugos());
	}
	@Test(expected = ObjetoNoEncontradoException.class)
	public void queNoSePuedaRemoverUnProfugoDosVeces() {		
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
