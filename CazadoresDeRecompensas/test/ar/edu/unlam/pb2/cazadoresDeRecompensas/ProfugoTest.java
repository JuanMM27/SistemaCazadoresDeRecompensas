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
	public void seCreaUnProfugoYSaberSuNombre() {
		Profugo p1 = new Profugo("Matias",20, 80, true);
		assertEquals("Matias",p1.getNombre());
	}
	@Test
	public void seCreaUnProfugoYSaberSuNivelDeInocencia() {
		Profugo p1 = new Profugo("Matias",20, 80, true);
		assertEquals(Integer.valueOf(20),p1.getNivelInocencia());
	}
	@Test
	public void seCreaUnProfugoYSaberSuNivelDeHabilidad() {
		Profugo p1 = new Profugo("Matias",20, 80, true);
		assertEquals(Integer.valueOf(80),p1.getNivelHabilidad());
	}
	@Test
	public void seCreaUnProfugoYSaberSiEsNerviosoONo() {
		Profugo p1 = new Profugo("Matias",20, 80, true);
		assertTrue(p1.getEsNervioso());
	}
	@Test
	public void queSePuedaCrearUnProfugoYSePuedaIntimidar() {
		Profugo p1 = new Profugo("Matias",20, 80, true);
		
		assertEquals(Integer.valueOf(80),p1.getNivelHabilidad());
	}
	
}
