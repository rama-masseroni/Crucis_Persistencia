package modelo;

import java.io.Serializable;
import daos.RolDAO;
import views.RolView;

public class Rol implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6219529356041815669L;
	private int idUsr;
	private String nombreRol;
	
	public Rol() {
	}
	
	public Rol(int idUsr, String nombreRol) {
		this.idUsr = idUsr;
		this.nombreRol = nombreRol;
	}

	public int getIdUsr() {
		return idUsr;
	}

	public void setIdUsr(int idUsr) {
		this.idUsr = idUsr;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	@Override
	public String toString() {
		return "Rol [idUsr=" + idUsr + ", nombreRol=" + nombreRol + "]";
	}
	
	public RolView toView() {
		return new RolView(this.idUsr, this.nombreRol);
	}
	
	public void guardar() {
		RolDAO rd = new RolDAO();
		rd.save(this);
	}
	
}
