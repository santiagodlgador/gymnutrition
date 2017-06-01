package mx.edu.uaz.GymNutrition2.forms;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.TabSheet;

public class SeguimientoTabs extends TabSheet{
	
	private static final long serialVersionUID=1L;
	
	public SeguimientoTabs(){
		addTab(new SeguimientoForms(),"Realizar Seguimiento", VaadinIcons.ADD_DOCK);
		addTab(new SeguimientoGeneral(),"Seguimiento General");
		addTab(new GraficaForm(),"Grafica");
		addTab(new ViewPdf(),"PDF");
	}

}
