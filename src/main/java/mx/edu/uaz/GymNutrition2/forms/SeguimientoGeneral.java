package mx.edu.uaz.GymNutrition2.forms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.vaadin.dialogs.ConfirmDialog;

import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.event.selection.SelectionListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid.SelectionMode;

import mx.edu.uaz.GymNutrition2.accesodatos.ADSeguimiento;
import mx.edu.uaz.GymNutrition2.modelos.Seguimiento;





public class SeguimientoGeneral extends CssLayout{
	private Grid<Seguimiento> grid;
	
	private ADSeguimiento adSeguimiento;
	private Seguimiento seguimiento;
	private Button btnEliminar;
	
	public SeguimientoGeneral (){
		setSizeFull();
		grid = new Grid<Seguimiento>(Seguimiento.class);
		grid.setStyleName("mi-grid");
		adSeguimiento = new ADSeguimiento();
		grid.setItems(adSeguimiento.obtenerTodos());
		grid.setSelectionMode(SelectionMode.MULTI);
		grid.setColumns("pecho","triceps","abdomen","espalda","biceps","cuadriceps","gemelos","cadera","peso","talla","edad","fecha");
		grid.addColumn(Seguimiento::getIdUsuario).setCaption("Nombre");
		
		grid.setResponsive(true);
		grid.setWidth("100%");
		grid.addSelectionListener(new SelectionListener<Seguimiento>() {
			
			@Override
			public void selectionChange(SelectionEvent<Seguimiento> event) {
				
				if (!event.getAllSelectedItems().isEmpty()){
					seguimiento = event.getFirstSelectedItem().get();
					
				}
			}
		});
		
		btnEliminar= new Button("Eliminar", VaadinIcons.DEL);
		btnEliminar.addClickListener(new EliminarSeguimiento());
		addComponents(grid,btnEliminar);
		
		
		}
		
		public void llenaGrid(){
			grid.setItems(adSeguimiento.obtenerTodos());
		}
		
		class EliminarSeguimiento implements ClickListener{

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
				                	Set<Seguimiento> usuarios = grid.getSelectedItems();
									List<Seguimiento> seg = new ArrayList<Seguimiento>();
									seg.addAll(usuarios);
									ADSeguimiento adSegumiento = new ADSeguimiento();
									boolean ok = adSegumiento.eliminarMultiple(seg);
									if (ok){
										grid.setItems(adSegumiento.obtenerTodos());
										Notification.show("Registros eliminados...",Notification.Type.WARNING_MESSAGE);
									}
					              } 
					            }
					        });
				}
				else
					Notification.show("Selecciona al menos un registro para eliminar",Notification.Type.WARNING_MESSAGE);
			}
				
		}
		
}
		
	
