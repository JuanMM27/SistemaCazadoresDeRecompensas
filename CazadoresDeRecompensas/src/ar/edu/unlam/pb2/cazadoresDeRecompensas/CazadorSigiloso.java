package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.HashSet;
import java.util.Set;

public class CazadorSigiloso extends Cazador {

	public CazadorSigiloso(String nombre, Integer experiencia) {
		super(nombre, experiencia);
	}

	@Override
	public Boolean intentarCaptura(Profugo p) {
		// Condicion 1 el nivel de experiencia del cazadpr debe ser mayor a la inocencia
		// del profugo
		// Condicion del cazador sigiloso: Habilidad menor a 50
		if (this.experiencia > p.getNivelInocencia() && p.getNivelHabilidad() < 50) {
			this.capturados.add(p);
			this.zona.removerProfugo(p);
			return true;
		} else {
			p.habilidadIntimada(5);
			return false;
		}
	}

	@Override
	public Boolean asignarZona(Zona zona) {
		if(!zona.getProfugos().isEmpty()) {
			this.zona=zona;
			return true;
		}
		return false;
		
	}
	@Override
	public Set<Profugo> intentarCapturaEnZonaAsignada(Zona zona) {
		Set <Profugo> profugosCapturados = new HashSet<>();
		HashSet<Profugo> profugoEnLaZona=new HashSet<Profugo>(zona.getProfugos());
		Integer habilidadMinimaProfugo = Integer.MAX_VALUE;//Lo inicializamos con el valor mas grande para que entre al if una vez aunque sea
		Boolean huboIntimidados = false;
		
		for (Profugo p : profugoEnLaZona) {
			if(intentarCaptura(p)) {
				profugosCapturados.add(p);
			}else {
				huboIntimidados = true;
				if(p.getNivelHabilidad() < habilidadMinimaProfugo) {//Si el nivel de habilidad del profugo es menor que el obtenido antes, lo actualizamos
					habilidadMinimaProfugo = p.getNivelHabilidad();
				}
			}
		}
		
		Integer experienciaGanada = 2 * profugosCapturados.size();
		if(huboIntimidados) {//Si hay intimidados, lo sumamos, por si no llega a haber intimidados
			experienciaGanada += habilidadMinimaProfugo;
		}
		
		this.experiencia += experienciaGanada;
		
		return profugosCapturados;
	}
}
