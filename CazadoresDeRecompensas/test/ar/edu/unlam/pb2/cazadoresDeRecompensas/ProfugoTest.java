package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfugoTest {

	@Test(expected = NivelesNoPermitidosException.class)
	public void noSePuedeCrearElProfugoConNivelInocenciaMenorA1() {
		Profugo p1 = new Profugo("Matias",-2, 60, true);
		assertNull(p1);
	}
	@Test(expected = NivelesNoPermitidosException.class)
	public void noSePuedeCrearElProfugoPorNivelHabilidadMayorA100() {
		Profugo p1 = new Profugo("Matias",20, 120, true);
		assertNull(p1);
	}
	@Test
	public void seCreaUnProfugo() {
		Profugo p1 = new Profugo("Matias",20, 80, true);
		assertNotNull(p1);
	}

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
	public void queUnProfugoPuedeRealizarEntrenamientoDeElite() {
		Profugo p1 = new Profugo("Jorge", 20, 100, true);
		p1.entrenarElite();//Esto lo entrenaria y lo subiria a 105, pero si el metodo esta bien hecho, deberia limitarse en 100
		assertFalse(p1.getEsNervioso());
	}
	
	@Test
	public void queNoSePuedaCambiarSiEsNerviosoPorEntrenamientoDeElite() {
		Profugo p1 = new Profugo("Jorge", 20, 100, true);
		p1.entrenarElite();//Esto lo entrenaria y lo subiria a 105, pero si el metodo esta bien hecho, deberia limitarse en 100
		p1.setEsNervioso(true);
		assertFalse(p1.getEsNervioso());
	}
	
	@Test
	public void queUnProfugoNoPuedeTenerMenosDe40DeNivelDeInocenciaConProteccionLegal() {
		Profugo p1 = new Profugo("Jorge", 45, 100, true);
		p1.entrenarProteccionLegal();//Esto lo entrenaria y lo subiria a 105, pero si el metodo esta bien hecho, deberia limitarse en 100
		p1.setNivelHabilidad(20);
		assertEquals(Integer.valueOf(45), p1.getNivelInocencia());
	}
}
