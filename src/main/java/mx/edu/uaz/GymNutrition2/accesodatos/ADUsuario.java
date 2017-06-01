package mx.edu.uaz.GymNutrition2.accesodatos;

import mx.edu.uaz.GymNutrition2.config.PersistenciaSesion;
import mx.edu.uaz.GymNutrition2.modelos.Usuario;
import mx.uaz.edu.GymNutrition2.utils.Hash;

import java.io.Serializable;
import java.util.List;



import org.apache.ibatis.session.SqlSession;

import com.vaadin.ui.Notification;

public class ADUsuario extends Object implements Serializable{
	
	public ADUsuario(){
		
	}
	
	public boolean guardar(Usuario usuario)
	{
		boolean ok= false;
		SqlSession sesion= PersistenciaSesion.getSqlMapper().openSession();
		try{
			Hash h= new Hash();
			String passwd= h.getHash(usuario.getPassword());
			usuario.setPassword(passwd);
			sesion.insert("guardarUsuario",usuario);
			sesion.commit();
			ok=true;
		}catch (Exception e){
			Notification.show("Error al guardar el usuario ", e.getCause().getMessage(),Notification.Type.ERROR_MESSAGE);
			System.out.println(usuario+"\n"+e.getCause().getMessage());
		}
		finally {
			sesion.close();
		}
		return ok;
		
	}//guardar
	
	public List<Usuario> obtenerTodos(){
		List<Usuario> usuarios= null;
		SqlSession sesion = PersistenciaSesion.getSqlMapper().openSession();
		try{
			usuarios= sesion.selectList("todosUsuarios");
		}	
	
		catch (Exception e) {
			Notification.show("Error al recuperar la lista de usuarios ", e.getCause().getMessage(),Notification.Type.ERROR_MESSAGE);
		}
		finally {
			sesion.close();
		}
		return usuarios;
	}
	
	public boolean eliminarMultiple(List<Usuario> users){
		boolean ok=false;
		
		SqlSession sesion = PersistenciaSesion.getSqlMapper().openSession();
		try{
		
			sesion.delete("eliminarUsuarios",users);
			sesion.commit();
			
		}catch (Exception e){
			Notification.show("Error al eliminar los usuarios ", e.getCause().getMessage(),Notification.Type.ERROR_MESSAGE);
		}finally {
			sesion.close();
		}return ok;
		
	}

	public boolean actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
