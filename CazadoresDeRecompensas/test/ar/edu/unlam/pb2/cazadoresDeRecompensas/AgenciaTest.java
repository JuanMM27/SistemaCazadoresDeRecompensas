package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class AgenciaTest {

	public Agencia cazadoresDeRecompensas = new Agencia();

	@Test
	public void queSePuedaAgregarUnCazadorALaAgencia() {
		Cazador cazador1 = new CazadorUrbano("Carlos", 60);
		assertEquals(cazador1.getNombre(),"Carlos");
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
		Profugo profugo2 = new Profugo("Matias", 50, 30, false);
		Profugo profugo3 = new Profugo("Jorge", 40, 40, false);
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
		agregarZonasALaAgencia();
		cazadoresDeRecompensas.obtenerZona("Matederos");
	}
	
	@Test
	public void queSeObtengaMapaDeCapturas() {
	    agregarZonasALaAgencia();

	    Cazador cazador1 = new CazadorRural("Hector Rural", 80);
	    Cazador cazador2 = new CazadorUrbano("Marcos Urbano", 60);
	    Cazador cazador3 = new CazadorSigiloso("Mauro Sigiloso", 40);
	    cazador1.asignarZona(cazadoresDeRecompensas.obtenerZona("Lomas"));
	    cazador2.asignarZona(cazadoresDeRecompensas.obtenerZona("San justo"));
	    cazador3.asignarZona(cazadoresDeRecompensas.obtenerZona("Capital"));
	    cazadoresDeRecompensas.agregarCazador(cazador1);
	    cazadoresDeRecompensas.agregarCazador(cazador2);
	    cazadoresDeRecompensas.agregarCazador(cazador3);
	    Map<Cazador, Set<Profugo>> capturas = cazadoresDeRecompensas.obtenerCapturasDeLosCazadores();

	    Cazador mejorCazador = cazadoresDeRecompensas.getCazadorConMasCapturas();
	    Profugo masHabil = cazadoresDeRecompensas.getProfugoMasHabilCapturado();

	    for (Map.Entry<Cazador, Set<Profugo>> entry : capturas.entrySet()) {
	        System.out.println("Cazador: " + entry.getKey().getNombre());
	        for (Profugo p : entry.getValue()) {
	            System.out.println("  - Capturó a: " + p.getNombre());
	        }
	    }

	    System.out.println(" Cazador con más capturas: " + mejorCazador.getNombre() + " (" + capturas.get(mejorCazador).size() + " capturas)");
	    System.out.println(" Prófugo más hábil capturado: " + masHabil.getNombre() + " (habilidad: " + masHabil.getNivelHabilidad() + ")");
	}
	
	@Test
	public void queSeObtengaMapaDeCapturasDeUnMismoTipoDeCazador() {
	    agregarZonasALaAgencia();

	    Cazador cazador1 = new CazadorRural("Javier Rural", 30);
	    Cazador cazador2 = new CazadorRural("Marcos Urbano", 20);
	    Cazador cazador3 = new CazadorRural("Mauro Rural", 50);
	    cazador1.asignarZona(cazadoresDeRecompensas.obtenerZona("Lomas"));
	    cazador2.asignarZona(cazadoresDeRecompensas.obtenerZona("San isidro"));
	    cazador3.asignarZona(cazadoresDeRecompensas.obtenerZona("Capital"));
	    cazadoresDeRecompensas.agregarCazador(cazador1);
	    cazadoresDeRecompensas.agregarCazador(cazador2);
	    cazadoresDeRecompensas.agregarCazador(cazador3);
	    Map<Cazador, Set<Profugo>> capturas = cazadoresDeRecompensas.obtenerCapturasDeLosCazadores();

	    Cazador mejorCazador = cazadoresDeRecompensas.getCazadorConMasCapturas();
	    Profugo masHabil = cazadoresDeRecompensas.getProfugoMasHabilCapturado();
	    System.out.println("Mapa de capturas: ");
	    for (Map.Entry<Cazador, Set<Profugo>> entry : capturas.entrySet()) {
	        System.out.println("Cazador: " + entry.getKey().getNombre());
	        for (Profugo p : entry.getValue()) {
	            System.out.println("  - Capturó a: " + p.getNombre());
	        }
	    }

	    System.out.println("Cazador con más capturas: " + mejorCazador.getNombre() + " (" + capturas.get(mejorCazador).size() + " capturas)");
	    System.out.println(" Prófugo más hábil capturado: " + masHabil.getNombre() + " (habilidad: " + masHabil.getNivelHabilidad() + ")\n");
	}
	

	
	@Test(expected = NoSeRealizaronCapturasException.class)
	public void queNoSeCaptureANingunProfugo() {
	    agregarZonasALaAgencia();

	    Cazador cazador1 = new CazadorRural("Hector Rural", 10);
	    Cazador cazador2 = new CazadorRural("Marcos Urbano", 10);
	    Cazador cazador3 = new CazadorRural("Mauro Rural", 10);
	    cazador1.asignarZona(cazadoresDeRecompensas.obtenerZona("San isidro"));
	    cazador2.asignarZona(cazadoresDeRecompensas.obtenerZona("San isidro"));
	    cazador3.asignarZona(cazadoresDeRecompensas.obtenerZona("San isidro"));
	    cazadoresDeRecompensas.agregarCazador(cazador1);
	    cazadoresDeRecompensas.agregarCazador(cazador2);
	    cazadoresDeRecompensas.agregarCazador(cazador3);
	    Map<Cazador, Set<Profugo>> capturas = cazadoresDeRecompensas.obtenerCapturasDeLosCazadores();

	    Cazador mejorCazador = cazadoresDeRecompensas.getCazadorConMasCapturas();
	    Profugo masHabil = cazadoresDeRecompensas.getProfugoMasHabilCapturado();

	    for (Map.Entry<Cazador, Set<Profugo>> entry : capturas.entrySet()) {
	        System.out.println("Cazador: " + entry.getKey().getNombre());
	        for (Profugo p : entry.getValue()) {
	            System.out.println("  - Capturó a: " + p.getNombre());
	        }
	    }

	    System.out.println(" Cazador con más capturas: " + mejorCazador.getNombre() + " (" + capturas.get(mejorCazador).size() + " capturas)");
	    System.out.println(" Prófugo más hábil capturado: " + masHabil.getNombre() + " (habilidad: " + masHabil.getNivelHabilidad() + ")");
	}


	
	
	
	private void agregarProfugosALaZona(Zona zona) {
		Profugo profugo1 = new Profugo("Pablo", 30, 50, true);
		Profugo profugo2 = new Profugo("Jorge", 40, 30, false);
		Profugo profugo3 = new Profugo("Matias", 20, 30, true);
		Profugo[] profugos = { profugo1, profugo2, profugo3};
		for (Profugo i : profugos) {
			zona.agregarProfugo(i);
		}

	}
	private void agregarProfugosALaZonaDos(Zona zona) {//Para mayor variedad en reportes
		Profugo profugo1 = new Profugo("Marcos", 40, 70, false);
		Profugo profugo2 = new Profugo("Juan", 20, 30, false);
		Profugo profugo3 = new Profugo("Manuel", 80, 30, true);
		Profugo[] profugos = { profugo1, profugo2, profugo3};
		for (Profugo i : profugos) {
			zona.agregarProfugo(i);
		}

	}
	private void agregarProfugosALaZonaTres(Zona zona) {//Para un ultimo reporte mas grande
		Profugo profugo1 = new Profugo("Pablo", 30, 50, true);
		Profugo profugo2 = new Profugo("Jorge", 40, 30, false);
		Profugo profugo3 = new Profugo("Matias", 25, 38, true);
		Profugo profugo4 = new Profugo("Jeremias", 30, 30, false);
		Profugo profugo5 = new Profugo("Del toro", 90, 30, false);
		Profugo profugo6 = new Profugo("Pancho", 10, 70, false);
		Profugo profugo7 = new Profugo("Hernan", 80, 20, true);
		Profugo[] profugos = { profugo1, profugo2, profugo3, profugo4, profugo5, profugo6, profugo7};
		for (Profugo i : profugos) {
			zona.agregarProfugo(i);
		}

	}
	
	private void agregarZonasALaAgencia() {
		Zona zona1 = new Zona("San justo");
		agregarProfugosALaZona(zona1);
		Zona zona2 = new Zona("Lomas");
		agregarProfugosALaZonaDos(zona2);
		Zona zona3 = new Zona("Capital");
		agregarProfugosALaZonaTres(zona3);
		Zona zona4 = new Zona("San isidro");
		agregarProfugosALaZona(zona4);
		Zona [] zonas= {zona1, zona2, zona3, zona4};
		for(Zona i:zonas) {
			cazadoresDeRecompensas.agregarZona(i);
		}
	}
	
}
