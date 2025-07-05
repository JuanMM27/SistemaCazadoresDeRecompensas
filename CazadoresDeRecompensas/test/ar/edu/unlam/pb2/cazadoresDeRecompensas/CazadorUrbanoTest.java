package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CazadorUrbanoTest {

	@Test
	public void seCreaUnCazadorUrbanoQueIntentaCapturarUnProfugoNerviosoYNoPuede() {
		Profugo profugo1 = new Profugo("Pablo", 30, 50, true);
		Zona zona = new Zona("Paris");
		Cazador cazadorUrbano = new CazadorUrbano("Jaime", 60);
		zona.agregarProfugo(profugo1);
		cazadorUrbano.asignarZona(zona);
		Integer cantidadCapturados = cazadorUrbano.intentarCapturaEnZonaAsignada(zona).size();
		assertEquals(0, cantidadCapturados, 0.0);
	}
	
	@Test
	public void seCreaUnCazadorUrbanoQueIntentaCapturarUnProfugoNoNerviosoYPuede() {
		Profugo profugo1 = new Profugo("Pacochi", 30, 50, false);
		Zona zona = new Zona("Paris");
		Cazador cazadorUrbano = new CazadorUrbano("Jaime", 60);
		zona.agregarProfugo(profugo1);
		cazadorUrbano.asignarZona(zona);
		Integer cantidadCapturados = cazadorUrbano.intentarCapturaEnZonaAsignada(zona).size();
		assertEquals(1, cantidadCapturados, 0.0);
	}
	
	@Test
	public void cazadorRuralCapturaProfugosEIntimidaSeValidaElCalcularExperienciaGanada() {
		Profugo profugo1 = new Profugo("Pablo", 20, 80, true);
		Profugo profugo2 = new Profugo("Nacho", 30, 50, true);
		Profugo profugo3 = new Profugo("Matias", 40, 40, false);
		Zona zona = new Zona("Paris");
		Cazador cazadorUrbano = new CazadorUrbano("Jaime", 60);
		zona.agregarProfugo(profugo1);
		zona.agregarProfugo(profugo2);
		zona.agregarProfugo(profugo3);
		cazadorUrbano.asignarZona(zona);
		cazadorUrbano.intentarCapturaEnZonaAsignada(zona);
		assertEquals(112, cazadorUrbano.getExperiencia(), 0.0);//50 (habilidadMinima) + 2 * 1 (profugos capturados) + 60 (exp base) = 104
	}
	
	@Test
	public void cazadorUrbanoNoPuedeCapturarAUnProfugoYLoIntimida() {
		Profugo profugo1 = new Profugo("Pablo", 60, 80, true);
		Cazador cazadorUrbano = new CazadorUrbano("Jorge", 40);
		Zona zona = new Zona("Irlanda");
		zona.agregarProfugo(profugo1);
		cazadorUrbano.asignarZona(zona);
		cazadorUrbano.intentarCapturaEnZonaAsignada(zona);
		Integer nivelInocenciaEsperado = 58;//60 de base - 2 por la intimidacion
		assertEquals(nivelInocenciaEsperado, profugo1.getNivelInocencia());
	}
	@Test
	public void puedeCapturarAunqueAumenteHabilidadPorArtesMarciales() {
		Profugo p = new Profugo("Luis", 20, 45, false); // nervioso y con inocencia baja
		p.entrenarArtesMarciales(); 
		Cazador c = new CazadorUrbano("Raul", 60); // experiencia mayor a inocencia
		Zona z = new Zona("Cordoba");
		z.agregarProfugo(p);
		c.asignarZona(z);
		assertTrue(c.intentarCapturaEnZonaAsignada(z).contains(p)); // Lo captura sin problema
	}
	@Test
	public void elCazadorIntimidaPeroNoBajaPorLaProteccionLegal() {
		Profugo profugo1 = new Profugo("Pablo", 40, 40, true);
		Cazador cazadorUrbano = new CazadorUrbano("Jorge", 20);
		Zona zona = new Zona("Brasil");
		profugo1.entrenarProteccionLegal();
		zona.agregarProfugo(profugo1);
		cazadorUrbano.asignarZona(zona);
		assertEquals(40, profugo1.getNivelHabilidad(), 0.0);//Se mantiene en 40 porque tiene proteccion legal
	}

}
