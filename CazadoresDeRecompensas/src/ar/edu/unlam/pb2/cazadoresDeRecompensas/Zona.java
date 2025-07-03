package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.HashSet;
import java.util.Set;

public class Zona {

	private String nombre;
	private HashSet<Profugo> profugos = new HashSet<Profugo>();

	public Zona(String nombre) {
		this.nombre = nombre;

	}

	public Boolean agregarProfugo(Profugo profugo1) {
		return profugos.add(profugo1);

	}

	public Integer cantidadDeProfugos() {
		return profugos.size();
	}

	public HashSet<Profugo> getProfugos() {
		return profugos;
	}

	public String getNombre() {
		return nombre;
	}

	public void removerProfugo(Profugo p) {
		if (this.profugos.contains(p)) {
			this.profugos.remove(p);
		} else
			throw new ObjetoNoEncontradoException("El profugo ya fue capturado o no se encuentra en la zona");

	}

	public Profugo buscarProfugo(Profugo p1) {
		if (this.profugos.contains(p1)) {
			return p1;
		} else
			throw new ObjetoNoEncontradoException("No existe el profugo");
	}

}
