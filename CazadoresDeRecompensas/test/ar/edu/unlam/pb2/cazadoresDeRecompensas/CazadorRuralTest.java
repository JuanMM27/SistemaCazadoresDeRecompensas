package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CazadorRuralTest {

	@Test
	public void seCreaUnCazadorRuralQueIntentaCapturarUnProfugoNoNerviosoYNoPuede() {
		Profugo profugo1 = new Profugo("Pablo", 30, 50, false);
		Zona zona = new Zona("Paris");
		Cazador cazadorRural = new CazadorRural("Jaime", 60);
		zona.agregarProfugo(profugo1);
		cazadorRural.asignarZona(zona);
		Integer cantidadCapturados = cazadorRural.intentarCapturaEnZonaAsignada(zona).size();
		assertEquals(0, cantidadCapturados, 0.0);
	}
	
	@Test
	public void seCreaUnCazadorRuralQueIntentaCapturarUnProfugoNerviosoYPuede() {
		Profugo profugo1 = new Profugo("Pablo", 30, 50, true);
		Zona zona = new Zona("Paris");
		Cazador cazadorRural = new CazadorRural("Jaime", 60);
		zona.agregarProfugo(profugo1);
		cazadorRural.asignarZona(zona);
		Integer cantidadCapturados = cazadorRural.intentarCapturaEnZonaAsignada(zona).size();
		assertEquals(1, cantidadCapturados, 0.0);
	}
	
	@Test
	public void cazadorRuralCapturaProfugosEIntimidaSeValidaElCalcularExperienciaGanada() {
		Profugo profugo1 = new Profugo("Pablo", 20, 80, true);
		Profugo profugo2 = new Profugo("Nacho", 30, 50, true);
		Profugo profugo3 = new Profugo("Matias", 40, 40, false);
		Zona zona = new Zona("Paris");
		Cazador cazadorRural = new CazadorRural("Jaime", 60);
		zona.agregarProfugo(profugo1);
		zona.agregarProfugo(profugo2);
		zona.agregarProfugo(profugo3);
		cazadorRural.asignarZona(zona);
		cazadorRural.intentarCapturaEnZonaAsignada(zona);
		assertEquals(104, cazadorRural.getExperiencia(), 0.0);//40 (habilidadMinima) + 2 * 2 (profugos capturados) + 60 (exp base) = 104
	}
	
	@Test
	public void cazadorRuralNoPuedeCapturarAUnProfugoYLoIntimida() {
		Profugo profugo1 = new Profugo("Pablo", 60, 80, true);
		Cazador cazadorRural = new CazadorRural("Jorge", 40);
		Zona zona = new Zona("Irlanda");
		zona.agregarProfugo(profugo1);
		cazadorRural.asignarZona(zona);
		cazadorRural.intentarCapturaEnZonaAsignada(zona);
		Integer nivelInocenciaEsperado = 58;//60 de base - 2 por la intimidacion
		assertEquals(nivelInocenciaEsperado, profugo1.getNivelInocencia());
	}
	@Test
	public void puedeCapturarAunqueAumenteHabilidadPorArtesMarciales() {
		Profugo p = new Profugo("Luis", 20, 45, true); // nervioso y con inocencia baja
		p.entrenarArtesMarciales(); // Sube habilidad a 55, pero eso no afecta al rural
		Cazador c = new CazadorRural("Raul", 60); // experiencia mayor a inocencia
		Zona z = new Zona("Cordoba");
		z.agregarProfugo(p);
		c.asignarZona(z);
		assertTrue(c.intentarCapturaEnZonaAsignada(z).contains(p)); // Lo captura sin problema
	}
}
