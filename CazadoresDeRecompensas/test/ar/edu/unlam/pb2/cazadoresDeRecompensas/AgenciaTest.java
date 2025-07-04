package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class AgenciaTest {

	public Agencia cazadoresDeRecompensas = new Agencia();

	@Test
	public void queSePuedaAgregarUnCazadorALaAgencia() {
		Cazador cazador1 = new CazadorUrbano("Carlos", 60);
		assertEquals(cazador1.getNombre(),"Carlos");
		assertTrue(cazadoresDeRecompensas.agregarCazador(cazador1));
	}
	@Test
	public void queSePuedaCrearUnaAgenciaYSePuedanAgregarCazadores() {
		agregarCazadoresALaZona();
		assertEquals(Integer.valueOf(6), cazadoresDeRecompensas.cantidadDeCazadores());
	}

	@Test
	public void queSePuedanAgregarZonasConProfugosALaAgencia() {
		agregarZonasALaAgencia();
		assertEquals(Integer.valueOf(4), cazadoresDeRecompensas.cantidadDeZonas());
		assertEquals(Integer.valueOf(4), cazadoresDeRecompensas.cantidadDeZonas());

	}
	@Test
	public void queSePuedaConsultarCuantosProfugosHayPorZona() {
		agregarZonasALaAgencia();
		Zona zona=cazadoresDeRecompensas.obtenerZona("San justo");
		HashSet <Profugo> esperado=new HashSet <Profugo>();
		Profugo profugo1 = new Profugo("Pablo", 10, 10, true);
		Profugo profugo2 = new Profugo("Jorge", 50, 30, false);
		Profugo profugo3 = new Profugo("Ramon", 40, 40, false);
		esperado.add(profugo1);
		esperado.add(profugo2);
		esperado.add(profugo3);		
		HashSet <Profugo> obtenido=cazadoresDeRecompensas.profugosPorZona(zona);
		assertEquals(obtenido, esperado);	

	}
	@Test(expected = ObjetoNoEncontradoException.class)
	public void queoSePuedaAsignarUnaZonaVacia() {
		Zona zona1 = new Zona("San justo");
		assertEquals(zona1.getProfugos(),cazadoresDeRecompensas.profugosPorZona(zona1));
	}
	@Test(expected = ObjetoNoEncontradoException.class)
	public void queLanceUnaExcepcionSiNoEncuentraLaZona() {
		Zona zona1 = new Zona("San justo");
		agregarZonasALaAgencia();
		cazadoresDeRecompensas.obtenerZona("Matederos");
	}
	
	@Test
	public void queSeObtengaLaListaDeTodosLosProfugosCapturadosPorCazadores() {
		agregarZonasALaAgencia();
		Zona zonaDePruebas = cazadoresDeRecompensas.obtenerZona("Lomas");
		Cazador cazador1 = new CazadorRural("Hector", 80);
		cazador1.asignarZona(zonaDePruebas);
		for(Profugo p : cazador1.intentarCapturaEnZonaAsignada(zonaDePruebas)){
			System.out.println(p);
		}
	}
	
	private void agregarProfugosALaZona(Zona zona) {
		Profugo profugo1 = new Profugo("Pablo", 90, 50, true);
		Profugo profugo2 = new Profugo("Jorge", 90, 30, false);
		Profugo profugo3 = new Profugo("Ramon", 90, 30, false);
		Profugo[] profugos = { profugo1, profugo2, profugo3};
		for (Profugo i : profugos) {
			zona.agregarProfugo(i);
		}

	}


	
	private void agregarCazadoresALaZona() {
		Cazador cazador1 = new CazadorUrbano("Carlos", 60);
		Cazador cazador2 = new CazadorUrbano("Hector", 40);
		Cazador cazador3 = new CazadorRural("Diego", 20);
		Cazador cazador4 = new CazadorRural("Leonel", 15);
		Cazador cazador5 = new CazadorSigiloso("Rodri", 80);
		Cazador cazador6 = new CazadorSigiloso("Ronaldo", 90);
		Cazador[] cazadores = { cazador1, cazador2, cazador3, cazador4, cazador5, cazador6 };
		for (Cazador i : cazadores) {
			cazadoresDeRecompensas.agregarCazador(i);
		}

	}
	
	
	
	private void agregarZonasALaAgencia() {
		Zona zona1 = new Zona("San justo");
		agregarProfugosALaZona(zona1);
		Zona zona2 = new Zona("Lomas");
		agregarProfugosALaZona(zona2);
		Zona zona3 = new Zona("Capital");
		agregarProfugosALaZona(zona3);
		Zona zona4 = new Zona("San isidro");
		agregarProfugosALaZona(zona4);
		Zona [] zonas= {zona1, zona2, zona3, zona4};
		for(Zona i:zonas) {
			cazadoresDeRecompensas.agregarZona(i);
		}
	}
	
}
