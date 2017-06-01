package mx.edu.uaz.GymNutrition2.accesodatos;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.vaadin.ui.Notification;

import mx.edu.uaz.GymNutrition2.config.PersistenciaSesion;
import mx.edu.uaz.GymNutrition2.modelos.Seguimiento;

public class ADSeguimiento extends Object implements Serializable{
	
	public ADSeguimiento(){
		
	}
	
	public boolean guardar(Seguimiento seguimiento){
		boolean ok=false;
		SqlSession sesion= PersistenciaSesion.getSqlMapper().openSession();
		
		try{
			sesion.insert("guardarSeguimiento",seguimiento);
			sesion.commit();
			ok=true;
		}catch(Exception e){
			Notification.show("Error al guardar el seguimiento del usuario ", e.getCause().getMessage(),Notification.Type.ERROR_MESSAGE);
		}
		finally{
			sesion.close();
		}
		return ok;
	}
	
	public List<Seguimiento> obtenerTodos(){
		List<Seguimiento> seguimiento=null;
		SqlSession sesion = PersistenciaSesion.getSqlMapper().openSession();
		try {
			seguimiento = sesion.selectList("todosSeguimientos");
			
		} catch (Exception e) {
			Notification.show("Error al recuperar la lista de usuarios ", e.getCause().getMessage(),Notification.Type.ERROR_MESSAGE);
		}
		finally {
			sesion.close();
		}
		return seguimiento;

	}
	
	public boolean eliminarMultiple(List<Seguimiento> seg){
		boolean ok=false;
		
		SqlSession sesion = PersistenciaSesion.getSqlMapper().openSession();
		try{
		
			sesion.delete("eliminarSeguimientos",seg);
			sesion.commit();
			
		}catch (Exception e){
			Notification.show("Error al eliminar los registros ", e.getCause().getMessage(),Notification.Type.ERROR_MESSAGE);
		}finally {
			sesion.close();
		}return ok;
		
	}
}
