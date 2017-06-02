import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;

public class VerArchivoForm extends FormLayout{
	
	private Button btnAceptar;
	private Window winPDF;
	
	public VerArchivoForm() {

	
		btnAceptar = new Button("Ver Archivo");
		
		//addComponent(tfNombre);
		addComponent(btnAceptar);
		
		btnAceptar.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				BrowserFrame bf = new BrowserFrame("", 
		        		//new ExternalResource("http://148.217.200.108:8082/birt/preview?__report=reportes/gymnutrition/graficaUser_Seguimiento.rptdesign&__format=PDF", "application/pdf"));
						//new ExternalResource("http://127.0.0.1:8080/birt/preview?_report=reportes/gymnutrition/graficaUser_Seguimiento.rptdesign&__format=PDF", "application/pdf"));
						new ExternalResource(VaadinService.getCurrent().getBaseDirectory().getAbsolutePath()+"/WEB-INF/classes/RutinasFiles/rutina.pdf"));
						bf.setSizeFull();
				
				winPDF = new Window("Grafica");
				winPDF.setWidth("500px");
				winPDF.setHeight("400px");
				winPDF.center();
				winPDF.setContent(bf);
				UI.getCurrent().addWindow(winPDF);
				
			}
		});
	}

}
