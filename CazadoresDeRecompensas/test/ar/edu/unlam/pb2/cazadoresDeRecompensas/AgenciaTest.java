package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class AgenciaTest {

	public Agencia cazadoresDeRecompensas = new Agencia();

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
		HashSet<Profugo> esperado = arrayDeProfugosParaprueba();		
		HashSet <Profugo> obtenido=cazadoresDeRecompensas.profugosPorZona(zona);
		assertEquals(obtenido, esperado);
		

	}
	
	@Test
	public void queSeObtengaMapaDeCapturas() {
	    agregarZonasALaAgencia();

	    Cazador cazador1 = new CazadorRural("Hector R", 80);
	    Cazador cazador2 = new CazadorUrbano("Marcos U", 60);
	    Cazador cazador3 = new CazadorSigiloso("Mauro S", 40);

	    cazador1.asignarZona(cazadoresDeRecompensas.obtenerZona("Lomas"));
	    cazador2.asignarZona(cazadoresDeRecompensas.obtenerZona("San justo"));
	    cazador3.asignarZona(cazadoresDeRecompensas.obtenerZona("Capital"));

	    cazadoresDeRecompensas.agregarCazador(cazador1);
	    cazadoresDeRecompensas.agregarCazador(cazador2);
	    cazadoresDeRecompensas.agregarCazador(cazador3);

	    // ✅ Captura SOLO UNA VEZ
	    Map<Cazador, Set<Profugo>> capturas = cazadoresDeRecompensas.obtenerCapturasDeLosCazadores();

	    // ✅ Pasar el mapa al método
	    Cazador mejorCazador = cazadoresDeRecompensas.getCazadorConMasCapturas();
	    Profugo masHabil = cazadoresDeRecompensas.getProfugoMasHabilCapturado();

	    System.out.println("---- VERIFICACIÓN DEL MAPA DE CAPTURAS ----");
	    for (Map.Entry<Cazador, Set<Profugo>> entry : capturas.entrySet()) {
	        System.out.println("Cazador: " + entry.getKey().getNombre());
	        for (Profugo p : entry.getValue()) {
	            System.out.println("  - Capturó a: " + p.getNombre());
	        }
	    }

	    System.out.println("✅ Cazador con más capturas: " + mejorCazador.getNombre() + " (" + capturas.get(mejorCazador).size() + " capturas)");
	    System.out.println("🎯 Prófugo más hábil capturado: " + masHabil.getNombre() + " (habilidad: " + masHabil.getNivelHabilidad() + ")");
	}
	
	private void agregarProfugosALaZona(Zona zona) {
		Profugo profugo1 = new Profugo("Pablo", 30, 50, true);
		Profugo profugo2 = new Profugo("Jorge", 40, 30, false);
		Profugo profugo3 = new Profugo("Ramon", 20, 30, true);
		Profugo[] profugos = { profugo1, profugo2, profugo3};
		for (Profugo i : profugos) {
			zona.agregarProfugo(i);
		}

	}

	private HashSet<Profugo> arrayDeProfugosParaprueba() {
		HashSet <Profugo> esperado=new HashSet <Profugo>();
		Profugo profugo1 = new Profugo("Pablo", 10, 10, true);
		Profugo profugo2 = new Profugo("Jorge", 50, 30, false);
		Profugo profugo3 = new Profugo("Ramon", 40, 40, false);
		esperado.add(profugo1);
		esperado.add(profugo2);
		esperado.add(profugo3);
		
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
