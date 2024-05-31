package modelo;

import daos.TurnoEnEsperaDAO;

public class TurnoEnEspera {
	
	private String especialidad;
	private int idUsrPac, idUsrMed;
	
	public TurnoEnEspera() {
	}
	
	public TurnoEnEspera(String especialidad, int idUsrPac, int idUsrMed) {
		this.especialidad = especialidad;
		this.idUsrPac = idUsrPac;
		this.idUsrMed = idUsrMed;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getIdUsrPac() {
		return idUsrPac;
	}

	public void setIdUsrPac(int idUsrPac) {
		this.idUsrPac = idUsrPac;
	}

	public int getIdUsrMed() {
		return idUsrMed;
	}

	public void setIdUsrMed(int idUsrMed) {
		this.idUsrMed = idUsrMed;
	}
	
	@Override
	public String toString() {
		return "TurnoEnEspera [especialidad=" + especialidad + ", idUsrPac=" + idUsrPac + ", idUsrMed=" + idUsrMed
				+ "]";
	}
	
	public void guardar() {
		TurnoEnEsperaDAO td = new TurnoEnEsperaDAO();
		td.save(this);
	}
	
	public void eliminar() {
		TurnoEnEsperaDAO td = new TurnoEnEsperaDAO();
		td.delete(this);
	}
	
}