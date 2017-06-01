package mx.edu.uaz.GymNutrition2.forms;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import mx.edu.uaz.GymNutrition2.Principal;

public class PrincipalForm extends Principal{
	
	public PrincipalForm(){
		content.setId("miContenido");
		
		btnUsuarios.addClickListener(new ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				content.removeAllComponents();
				//content.addComponent(new RegistroUserForms());
				content.addComponent(new UsuariosTab());
			}
			
		});
		
		btnRutinas.addClickListener(new ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				content.removeAllComponents();
				content.addComponent(new SubirRutinaForms());
				//content.addComponent(new ViewPdf());
			}
			
		});
		
		btnSeguimiento.addClickListener(new ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				content.removeAllComponents();
				content.addComponent(new SeguimientoTabs());
				
				
			}
			
		});

	}
	

}
