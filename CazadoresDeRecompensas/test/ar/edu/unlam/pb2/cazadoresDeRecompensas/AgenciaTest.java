package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class AgenciaTest {

	public Agencia cazadoresDeReconpenza = new Agencia();

	@Test
	public void queSePuedaCrearUnaAgenciaYSePuedanAgregarCazadores() {
		agregarCazadoresALaZona();
		assertEquals(Integer.valueOf(6), cazadoresDeReconpenza.cantidadDeCazadores());
	}

	@Test
	public void queSePuedanAgregarZonasConProfugosALaAgencia() {
		agregarZonasALaAgencia();
		assertEquals(Integer.valueOf(9), cazadoresDeReconpenza.cantidadDeZonas());
		assertEquals(Integer.valueOf(9), cazadoresDeReconpenza.cantidadDeZonas());

	}
	@Test
	public void queSePuedaConsultarCuantosProfugosHayPorZona() {
		agregarZonasALaAgencia();
		Zona zona=cazadoresDeReconpenza.obtenerZona("San justo");
		HashSet<Profugo> esperado = arrayDeProfugosParaprueba();		
		HashSet <Profugo> obtenido=cazadoresDeReconpenza.profugosPorZona(zona);
		assertEquals(obtenido, esperado);
		

	}
	
	private HashSet<Profugo> arrayDeProfugosParaprueba() {
		HashSet <Profugo> esperado=new HashSet <Profugo>();
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
		esperado.add(profugo1);
		esperado.add(profugo2);
		esperado.add(profugo3);
		esperado.add(profugo4);
		esperado.add(profugo5);
		esperado.add(profugo6);
		esperado.add(profugo7);
		esperado.add(profugo8);
		esperado.add(profugo9);
		esperado.add(profugo10);
		esperado.add(profugo11);
		esperado.add(profugo12);
		return esperado;
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
			cazadoresDeReconpenza.agregarCazador(i);
		}

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
	
	private void agregarZonasALaAgencia() {
		Zona zona1 = new Zona("San justo", TipoDeZona.URBANO);
		agregarProfugosALaZona(zona1);
		Zona zona2 = new Zona("Lomas", TipoDeZona.URBANO);
		agregarProfugosALaZona(zona2);
		Zona zona3 = new Zona("Capital", TipoDeZona.URBANO);
		agregarProfugosALaZona(zona3);
		Zona zona4 = new Zona("San isidro", TipoDeZona.URBANO);
		agregarProfugosALaZona(zona4);
		Zona zona5 = new Zona("El talar", TipoDeZona.URBANO);
		agregarProfugosALaZona(zona5);
		Zona zona6 = new Zona("Chascomus", TipoDeZona.RURAL);
		agregarProfugosALaZona(zona6);
		Zona zona7 = new Zona("Dolores", TipoDeZona.RURAL);
		agregarProfugosALaZona(zona7);
		Zona zona8 = new Zona("Ensenada", TipoDeZona.RURAL);
		agregarProfugosALaZona(zona8);
		Zona zona9 = new Zona("San pedro", TipoDeZona.RURAL);
		agregarProfugosALaZona(zona9);
		Zona [] zonas= {zona1, zona2, zona3, zona4, zona5, zona6, zona7, zona8, zona9};
		for(Zona i:zonas) {
			cazadoresDeReconpenza.agregarZona(i);
		}
	}
	
}
