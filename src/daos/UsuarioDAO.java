package daos;

import java.util.List;

import org.hibernate.Session;

import entities.MedicoEntity;
import entities.UsuarioEntity;
import hibernate.HibernateUtil;
import modelo.Rol;
import modelo.Usuario;
import views.UsuarioView;

public class UsuarioDAO {
	
	public Usuario getUsuarioByUsername(String username) {
		Usuario usr = null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		UsuarioEntity seleccion = (UsuarioEntity) s.createQuery("from UsuarioEntity u where u.username = ?0").setString(0, username).uniqueResult();
		s.getTransaction().commit();
		s.close();
		usr = toNegocio(seleccion);
		return usr;
	}
	
//	public Usuario getUsuarioByID(int id) {
//		Usuario usr = null;
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		s.beginTransaction();
//		UsuarioEntity seleccion = (UsuarioEntity) s.createQuery("from UsuarioEntity u where u.id = ?0").setInteger(0, id).uniqueResult();
//		s.getTransaction().commit();
//		s.close();
//		usr = toNegocio(seleccion);
//		return usr;
//	}
	
	public Usuario getUsuarioByID(int id) {
		Usuario usr = null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		UsuarioEntity seleccion = (UsuarioEntity) s.createQuery("from UsuarioEntity u where u.id = ?0").setInteger(0, id).uniqueResult();
		List<Rol> lr = new RolDAO().getRolesByIdUsr(id);
		s.getTransaction().commit();
		s.close();
		usr = toNegocio(seleccion, lr);
		return usr;
	}

	
	public void save(Usuario usr) {
		UsuarioEntity nuevo = toEntity(usr);
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.save(nuevo);
		s.getTransaction().commit();
		s.close();
	}
	
	UsuarioEntity toEntity(Usuario usr) {
		return new UsuarioEntity(usr.getId(), usr.getUsername(), usr.getPassword(), usr.getNombre(), usr.getApellido(), usr.getFechaDeNacimiento(), usr.getDni(), usr.getSexo());
	}

	Usuario toNegocio(UsuarioEntity usr) {
		return new Usuario(usr.getId(), usr.getUsername(), usr.getPassword(), usr.getNombre(), usr.getApellido(), usr.getFechaDeNacimiento().toString(), usr.getDni(), usr.getSexo());
	}
	
	Usuario toNegocio(UsuarioEntity usr, List<Rol> lr) {
		return new Usuario(usr.getId(), usr.getUsername(), usr.getPassword(), usr.getNombre(), usr.getApellido(), usr.getFechaDeNacimiento().toString(), usr.getDni(), usr.getSexo(), lr);
	}

	

}
