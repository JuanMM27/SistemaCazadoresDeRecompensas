package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.HashSet;
import java.util.Set;

public class Zona {

	private String nombre;
	private TipoDeZona tipoDeZona;
	private HashSet profugos=new HashSet <Profugo>();

	public Zona(String nombre, TipoDeZona tipoDeZona) {
		this.nombre=nombre;
		this.tipoDeZona=tipoDeZona;
	}

	public Boolean agregarProfugo(Profugo profugo1) {
		return profugos.add(profugo1);
		
	}
	public Integer cantidadDeProfugos() {
		return profugos.size();
	}

	public HashSet getProfugos() {
		return profugos;
	}
	
}
