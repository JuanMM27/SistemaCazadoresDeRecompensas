package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cazador {

	protected String nombre;
	protected Integer experiencia;
	protected List <Profugo> capturados=new ArrayList<Profugo>(); //Esto se podria cambiar a un HashSet para evitar duplicados

	public Cazador(String nombre, Integer experiencia) {
		this.nombre=nombre;
		this.experiencia = experiencia;
	}

	public String getNombre() {
		return nombre;
	}

	public abstract Boolean intentarCaptura(Profugo p);//Crea la clase abstracta intentar captura, para ser sobreescrita en cada cazador

}
