package mx.edu.uaz.GymNutrition2.forms;
import java.util.Optional;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import mx.uaz.edu.GymNutrition2.utils.SubirArchivo;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;

public class VerArchivoForm extends FormLayout{
	
	private Button btnAceptar;
	private Button btnVer;
	private Window winPDF;
	private ComboBox<String> combo;
	
	public VerArchivoForm() {
		SubirArchivo subir= new SubirArchivo();
		//combo.setItems(subir.searchFile());

	
		btnAceptar = new Button("Ver Archivo");
		btnVer = new Button("Mostrar");
		
		//addComponent(tfNombre);
		addComponent(btnAceptar);
		addComponent(btnVer);
	//	addComponent(combo);
		
		btnAceptar.addClickListener(new ClickListener() {
			Optional<String> seleccionado=combo.getSelectedItem();
			
			@Override
			public void buttonClick(ClickEvent event) {
				BrowserFrame bf = new BrowserFrame("", 
		        		//new ExternalResource("http://148.217.200.108:8082/birt/preview?__report=reportes/gymnutrition/graficaUser_Seguimiento.rptdesign&__format=PDF", "application/pdf"));
						//new ExternalResource("http://127.0.0.1:8080/birt/preview?_report=reportes/gymnutrition/graficaUser_Seguimiento.rptdesign&__format=PDF", "application/pdf"));
						//new ExternalResource(VaadinService.getCurrent().getBaseDirectory().getAbsolutePath()+"/WEB-INF/classes/RutinasFiles/"));
						new ExternalResource(VaadinService.getCurrent().getBaseDirectory().getAbsolutePath()+"preview?__report=WEB-INF/classes/RutinasFiles/"+seleccionado+"&__format=PDF", "application/pdf"));
						bf.setSizeFull();
				
				winPDF = new Window("Archivos");
				winPDF.setWidth("500px");
				winPDF.setHeight("400px");
				winPDF.center();
				winPDF.setContent(bf);
				UI.getCurrent().addWindow(winPDF);
				
			//	UI.getCurrent().add
				
			}
			
			
		});
		/*
		Optional<String> seleccionado= cboList.getSelectedItem();
		BrowserFrame bf = new BrowserFrame("", 
        		//new ExternalResource("http://148.217.200.108:8082/birt/preview?__report=reportes/gymnutrition/ListaUsuarios.rptdesign&__format=PDF", "application/pdf"+ seleccionado));
				//new ExternalResource("http://127.0.0.1:8080/birt/preview?_report=reportes/gymnutrition/graficaUser_Seguimiento.rptdesign&__format=PDF", "application/pdf"));
				new ExternalResource(VaadinService.getCurrent().getBaseDirectory().getAbsolutePath()+"preview?__report=WEB-INF/classes/RutinasFiles/"+seleccionado+"&__format=PDF", "application/pdf"));
				
				bf.setSizeFull();
		
		winPDF = new Window("Grafica");
		winPDF.setWidth("500px");
		winPDF.setHeight("400px");
		winPDF.center();
		winPDF.setContent(bf);
		UI.getCurrent().addWindow(winPDF);*/
	}

}
