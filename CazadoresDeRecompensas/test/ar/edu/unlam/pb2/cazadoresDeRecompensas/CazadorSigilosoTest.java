package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CazadorSigilosoTest {

	@Test
	public void seCreaUnCazadorSigilosoQueNoPuedeCapturarPorHabilidadMayorA50() {
		Profugo profugo1 = new Profugo("Pablo", 30, 55, true);
		Zona zona = new Zona("Paris");
		Cazador cazadorSigiloso = new CazadorSigiloso("Marcos", 60);
		zona.agregarProfugo(profugo1);
		cazadorSigiloso.asignarZona(zona);
		Integer cantidadCapturados = cazadorSigiloso.intentarCapturaEnZonaAsignada(zona).size();
		assertEquals(0, cantidadCapturados, 0.0);
	}
	
	@Test
	public void seCreaUnCazadorSigilosoQueIntentaCapturarUnProfugoConHabilidadMenorA50YPuede() {
		Profugo profugo1 = new Profugo("Pacochi", 30, 40, false);
		Zona zona = new Zona("Paris");
		Cazador cazadorSigiloso = new CazadorSigiloso("Jaime", 60);
		zona.agregarProfugo(profugo1);
		cazadorSigiloso.asignarZona(zona);
		Integer cantidadCapturados = cazadorSigiloso.intentarCapturaEnZonaAsignada(zona).size();
		assertEquals(1, cantidadCapturados, 0.0);
	}
	
	@Test
	public void cazadorSigilosoCapturaProfugosEIntimidaSeValidaElCalcularExperienciaGanada() {
		Profugo profugo1 = new Profugo("Pablo", 20, 80, true);
		Profugo profugo2 = new Profugo("Nacho", 30, 49, true);
		Profugo profugo3 = new Profugo("Matias", 40, 40, false);
		Zona zona = new Zona("Paris");
		Cazador cazadorSigiloso = new CazadorSigiloso("Jaime", 60);
		zona.agregarProfugo(profugo1);
		zona.agregarProfugo(profugo2);
		zona.agregarProfugo(profugo3);
		cazadorSigiloso.asignarZona(zona);
		cazadorSigiloso.intentarCapturaEnZonaAsignada(zona);
		assertEquals(139, cazadorSigiloso.getExperiencia(), 0.0);//80 (habilidadMinima) + 2 * 2 (profugos capturados) + 60 (exp base) = 104
	}
	
	@Test
	public void cazadorSigilosoNoPuedeCapturarAUnProfugoYLoIntimida() {
		Profugo profugo1 = new Profugo("Pedro", 60, 80, true);
		Cazador cazadorSigiloso = new CazadorSigiloso("Jorge", 40);
		Zona zona = new Zona("Irlanda");
		zona.agregarProfugo(profugo1);
		cazadorSigiloso.asignarZona(zona);
		cazadorSigiloso.intentarCapturaEnZonaAsignada(zona);
		Integer nivelHabilidadEsperado = 75;//80 de base - 5 por la intimidacion
		assertEquals(nivelHabilidadEsperado, profugo1.getNivelHabilidad());
	}
	@Test
	public void noPuedeCapturarPorAumentoEnArtesMarciales() {
		Profugo p = new Profugo("Luis", 20, 45, false); //Experiencia 45
		p.entrenarArtesMarciales(); //Sube experiencia a 55
		Cazador c = new CazadorSigiloso("Raul", 60); 
		Zona z = new Zona("Cordoba");
		z.agregarProfugo(p);
		c.asignarZona(z);
		assertFalse(c.intentarCapturaEnZonaAsignada(z).contains(p)); // Lo captura sin problema
	}
	@Test
	public void elCazadorIntimidaPeroNoBajaPorLaProteccionLegal() {
		Profugo profugo1 = new Profugo("Pablo", 40, 40, true);
		Cazador cazadorSigiloso = new CazadorSigiloso("Jorge", 20);
		Zona zona = new Zona("Brasil");
		profugo1.entrenarProteccionLegal();
		zona.agregarProfugo(profugo1);
		cazadorSigiloso.asignarZona(zona);
		assertEquals(40, profugo1.getNivelHabilidad(), 0.0);//Se mantiene en 40 porque tiene proteccion legal
	}

}
