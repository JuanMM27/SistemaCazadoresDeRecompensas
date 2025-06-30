package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfugoTest {

	@Test(expected = NivelesNoPermitidosException.class)
	public void noSePuedeCrearElProfugoConNivelInocenciaMenorA1() {
		Profugo p1 = new Profugo("Matias",-2, 60, true);
	}
	@Test(expected = NivelesNoPermitidosException.class)
	public void noSePuedeCrearElProfugoPorNivelHabilidadMayorA100() {
		Profugo p1 = new Profugo("Matias",20, 120, true);
	}
	@Test
	public void seCreaUnProfugoYVerificaElToString() {
		Profugo p1 = new Profugo("Matias",20, 80, true);
		assertNotNull(p1);
		System.out.println(p1.toString());
	}

}
