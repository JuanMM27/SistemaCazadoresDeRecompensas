package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.HashSet;
import java.util.Set;

public class Zona {

	private String nombre;
	private TipoDeZona tipoDeZona;
	private HashSet<Profugo> profugos=new HashSet <Profugo>();

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

	public String getNombre() {
		return nombre;
	}

	public TipoDeZona getTipoDeZona() {
		return tipoDeZona;
	}

	public void removerProfugo(Profugo p) {
		this.profugos.remove(p);
		
	}
	
	
}
