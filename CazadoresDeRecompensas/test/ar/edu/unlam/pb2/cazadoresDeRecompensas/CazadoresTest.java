package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CazadoresTest {
	
	private Agencia cazadoresDeReconpenza=new Agencia();
	@Test
	public void queSePuedaCrearUnaAgenciaYSePuedanAgregarCazadores() {		
		Cazador cazador1=new CazadorUrbano("Carlos");
		Cazador cazador2=new CazadorUrbano("Hector");
		Cazador cazador3=new CazadorRural("Diego");
		Cazador cazador4=new CazadorRural("Leonel");
		Cazador cazador5=new CazadorSigiloso("Rodri");
		Cazador cazador6=new CazadorSigiloso("Ronaldo");
		cazadoresDeReconpenza.agregarCazador(cazador1);
		cazadoresDeReconpenza.agregarCazador(cazador2);
		cazadoresDeReconpenza.agregarCazador(cazador3);
		cazadoresDeReconpenza.agregarCazador(cazador4);
		cazadoresDeReconpenza.agregarCazador(cazador5);
		cazadoresDeReconpenza.agregarCazador(cazador6);
		assertEquals(Integer.valueOf(6),cazadoresDeReconpenza.cantidadDeCazadores());
		
		
	}
	@Test
	public void queSePuedanAgregarZonasALaAencia() {
		Zona zona=new Zona("San justo", TipoDeZona.URBANO);
		Profugo profugo1=new Profugo("Pablo",10,10,true);	
		Profugo profugo2=new Profugo("Jorge",50,30,false);
		Profugo profugo3=new Profugo("Ramon",40,40,false);
		Profugo profugo4=new Profugo("Leo",60,30,true);
		zona.agregarProfugo(profugo1);
		zona.agregarProfugo(profugo2);
		zona.agregarProfugo(profugo3);
		zona.agregarProfugo(profugo4);
		cazadoresDeReconpenza.agregarZona(zona);
		
		
	
		assertEquals(Integer.valueOf(4),zona.cantidadDeProfugos());
		
	}
	@Test
	public void queSePuedaCrearUnCazadorYPuedaCapturarUnProfugo() {
		Cazador cazador=new Cazador("Carlos");
		Profugo profugo=new Profugo("Pablo",10,10,true);
		assertTrue( cazador.capturarprofugo(profugo));
		
	}
	@Test
	public void queSePuedanAgregarProfugosAUnaZona() {
		Cazador cazador=new Cazador("Carlos");
		Profugo profugo1=new Profugo("Pablo",10,10,true);	
		Profugo profugo2=new Profugo("Jorge",50,30,false);
		Profugo profugo3=new Profugo("Ramon",40,40,false);
		Profugo profugo4=new Profugo("Leo",60,30,true);
		Zona zona=new Zona("San justo", TipoDeZona.URBANO);
		zona.agregarProfugo(profugo1);
		zona.agregarProfugo(profugo2);
		zona.agregarProfugo(profugo3);
		zona.agregarProfugo(profugo4);
		assertEquals(Integer.valueOf(4),zona.cantidadDeProfugos());
		
	}

}
