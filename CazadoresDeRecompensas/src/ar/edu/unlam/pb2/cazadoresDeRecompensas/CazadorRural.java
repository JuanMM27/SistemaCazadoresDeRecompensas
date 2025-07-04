package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.HashSet;
import java.util.Set;


public class CazadorRural extends Cazador{

	public CazadorRural(String nombre, Integer experiencia) {
		super(nombre, experiencia);
	}

	@Override
	public Boolean intentarCaptura(Profugo p) {
		//Condicion 1 el nivel de experiencia del cazadpr debe ser mayor a la inocencia del profugo
		//Condicion del cazador rural: El profugo debe ser nervioso
		if (this.experiencia > p.getNivelInocencia() && p.getEsNervioso() == true) {
			this.capturados.add(p);
			this.zona.removerProfugo(p);
			return true;
		} else {
			p.inocenciaIntimada(2);
			p.setEsNervioso(true);
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
		for (Profugo p : profugoEnLaZona) {
			if(intentarCaptura(p)) {
				profugosCapturados.add(p);
			}
		}
		return profugosCapturados;
	}

}
