package mx.edu.uaz.GymNutrition2.forms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.vaadin.dialogs.ConfirmDialog;

//import org.vaadin.dialogs.ConfirmDialog;

import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.event.selection.SelectionListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.renderers.ButtonRenderer;

import mx.edu.uaz.GymNutrition2.accesodatos.ADUsuario;
import mx.edu.uaz.GymNutrition2.modelos.Usuario;


public class ListaUsuariosForm extends CssLayout{
	private Grid<Usuario> grid;
	private ADUsuario adUsuario;
	private Usuario usuario;
	private Button btnEliminar;
	
	public ListaUsuariosForm(){
		setSizeFull();
		setResponsive(true);
		
		grid = new Grid <Usuario>(Usuario.class);
		grid.setStyleName("mi-grid");
		adUsuario = new ADUsuario();
		
		grid.setItems(adUsuario.obtenerTodos());
		grid.setSelectionMode(SelectionMode.MULTI);
		grid.setColumns("nombre","apellidos","correo");
		grid.addColumn(person -> "",
			      new ButtonRenderer(clickEvent -> {
			    	  TabSheet tab = (TabSheet) this.getParent();
			    	  RegistroUserForms lu = (RegistroUserForms) tab.getTab(0).getComponent();
			    	  usuario = (Usuario) clickEvent.getItem();
			    	  lu.enlazarExterno(usuario);
			    	  tab.setSelectedTab(0);
			    }));
		grid.setResponsive(true);
		grid.setWidth("100%");
		grid.addSelectionListener(new SelectionListener<Usuario>() {
			
			@Override
			public void selectionChange(SelectionEvent<Usuario> event) {
				
				if (!event.getAllSelectedItems().isEmpty()){
					usuario = event.getFirstSelectedItem().get();
					
				}
			}
		});
		
		btnEliminar = new Button("Eliminar", VaadinIcons.DEL);
		btnEliminar.addClickListener(new EliminarUsuario());
		
		addComponents(grid, btnEliminar);
	
	}
	public void llenaGrid(){
		grid.setItems(adUsuario.obtenerTodos());
	}
	class EliminarUsuario implements ClickListener{

		@Override
		public void buttonClick(ClickEvent event) {
			if (!grid.getSelectedItems().isEmpty()){
				ConfirmDialog.show(
					UI.getCurrent(), 
					"Confirmar eliminación:", 
					"¿Deseas relamente eliminar los registros?",
				    "Eliminar", "Cancelar", 
				    new ConfirmDialog.Listener() {

				        public void onClose(ConfirmDialog dialog) {
			                if (dialog.isConfirmed()) {
			                	Set<Usuario> usuarios = grid.getSelectedItems();
								List<Usuario> users = new ArrayList<Usuario>();
								users.addAll(usuarios);
								ADUsuario adUsuario = new ADUsuario();
								boolean ok = adUsuario.eliminarMultiple(users);
								if (ok){
									grid.setItems(adUsuario.obtenerTodos());
									Notification.show("Registros eliminados...",Notification.Type.WARNING_MESSAGE);
								}
				              } 
				            }
				        });
			}
			else
				Notification.show("Selecciona al menos un usuario para eliminar",Notification.Type.WARNING_MESSAGE);
		}
			
	
	}
	
	

}
