package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Medicos")
public class MedicoEntity {
	@Id
	@Column (name = "idUsr")
	private int idUsr;
	@Column (name = "especialidad")
	private String especialidad;
	
	public MedicoEntity() {
	}
	
	public MedicoEntity(int idUsr, String especialidad) {
		this.idUsr = idUsr;
		this.especialidad = especialidad;
	}

	public int getIdUsr() {
		return idUsr;
	}

	public void setIdUsr(int idUsr) {
		this.idUsr = idUsr;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
		
}
