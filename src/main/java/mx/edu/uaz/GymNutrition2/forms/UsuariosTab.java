package mx.edu.uaz.GymNutrition2.forms;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.TabSheet;



public class UsuariosTab extends TabSheet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuariosTab(){
		addTab(new RegistroUserForms(),"Registro", VaadinIcons.ADD_DOCK);
		addTab(new ListaUsuariosForm(), "Usuarios", VaadinIcons.LIST);
		addTab(new ListaRptUsersForm(), "Reporte", VaadinIcons.LIST);
	}

}
