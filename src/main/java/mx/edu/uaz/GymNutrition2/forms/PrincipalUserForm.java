package mx.edu.uaz.GymNutrition2.forms;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import mx.edu.uaz.GymNutrition2.vistas.PrincipalUser;
import mx.edu.uaz.GymNutrition2.vistas.SubirRutina;



public class PrincipalUserForm extends PrincipalUser{
	
	 public PrincipalUserForm() {
		// TODO Auto-generated constructor stub
	
		contentUser.setId("contenidouser");
		
		btnRutinas.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				content.removeAllComponents();
				content.addComponent(new SubirRutina());
				
			}
		});
	}
	

}
