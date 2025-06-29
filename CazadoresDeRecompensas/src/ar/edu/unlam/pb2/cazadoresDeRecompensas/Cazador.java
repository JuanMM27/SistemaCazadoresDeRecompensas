package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.ArrayList;
import java.util.List;

public class Cazador {

	private String nombre;
	private List <Profugo> capturados=new ArrayList<Profugo>(); 

	public Cazador(String nombre) {
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public Boolean capturarprofugo(Profugo profugo) {
		return capturados.add(profugo);
		
	}
	

	
	

}
