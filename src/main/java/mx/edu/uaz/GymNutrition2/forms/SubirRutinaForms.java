package mx.edu.uaz.GymNutrition2.forms;

import java.io.File;
import java.util.Collection;
import java.util.Optional;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import mx.edu.uaz.GymNutrition2.vistas.SubirRutina;
import mx.uaz.edu.GymNutrition2.utils.BuscaComponentes;
import mx.uaz.edu.GymNutrition2.utils.SubirArchivo;
import pl.pdfviewer.PdfViewer;

public class SubirRutinaForms extends SubirRutina{
	
	private Window winPDF;
	public SubirRutinaForms() {
		enlazarDatos();
		//VerArchivo();
		//pdfView();
	}
	
	public void enlazarDatos(){
		//Image file= (Image) BuscaComponentes.findComponentById(UI.getCurrent(),"file");
		
		SubirArchivo receiver = new SubirArchivo();
		//btnSubirRutina.setReceiver(receiver);
		
		//ComboBox file= (ComboBox) BuscaComponentes.findComponentById(UI.getCurrent(),"cboList");
		//cboList.setItems((Collection<String>) file);
		//file.setItems(new SubirArchivo());
		cboList.setItems(receiver.searchFile());
		cboList.setItems(receiver.searchFile());
		System.out.println(receiver.searchFile());
		Optional<String> verArchivo= cboList.getSelectedItem();
		btnSubirRutina.setReceiver(receiver);
		btnSubirRutina.addSucceededListener(receiver);
		
		btnVerArchivo.addClickListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				/*Optional<String> seleccionado= cboList.getSelectedItem();
				BrowserFrame bf = new BrowserFrame("", 
		        		//new ExternalResource("http://148.217.200.108:8082/birt/preview?__report=reportes/gymnutrition/ListaUsuarios.rptdesign&__format=PDF", "application/pdf"+ seleccionado));
						//new ExternalResource("http://127.0.0.1:8080/birt/preview?_report=reportes/gymnutrition/graficaUser_Seguimiento.rptdesign&__format=PDF", "application/pdf"));
						//new ExternalResource(VaadinService.getCurrent().getBaseDirectory().getAbsolutePath()+"preview?_report=reportes/gymnutrition/graficaUser_Seguimiento.rptdesign&__format=PDF", "application/pdf"));
						//new ExternalResource(VaadinService.getCurrent().getBaseDirectory().getAbsolutePath()+"preview?__report=WEB-INF/classes/RutinasFiles/"+seleccionado+"&__format=PDF", "application/pdf"));
						new ExternalResource(VaadinService.getCurrent().getBaseDirectory().getAbsolutePath()+"/WEB-INF/classes/RutinasFiles/"+seleccionado+"&__format=PDF", "application/pdf"));
						
						bf.setSizeFull();
				
				winPDF = new Window("Grafica");
				winPDF.setWidth("500px");
				winPDF.setHeight("400px");
				winPDF.center();
				winPDF.setContent(bf);
				UI.getCurrent().addWindow(winPDF);*/
				crear();
			}
		});
	}
	
	public void VerArchivo(){
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
		UI.getCurrent().addWindow(winPDF);
	}
	
	  //public DocumentoForm(){
	    //    crear();
	    //}

	    public void crear(){
	    	
	    	/*//Primero que nada, declaramos las variables.
	        String cadena_a,cadena_b,cadena_c="GeekyTheory";
	        //Borramos los últimos caracteres a partir del sexto carácter.
	        cadena_a = cadena_c.substring(0,5);
	        //Borramos los primeros cinco caracteres.
	        cadena_b = cadena_c.substring(5);
	        //Imprimimos el resultado.
	        System.out.println(cadena_a+"\n"+cadena_b);
	        */
	        
	        //File archivo = new File("/Users/LuisEduardoLeyvaHerrera/Desktop/IntelliJIDEA/EjemploBoostrap-Persistencia/src/main/webapp/VAADIN/themes/estilos/layouts/img/vaadin.pdf");
	    	String pdf2=cboList.getSelectedItem().toString();
	    	pdf2=pdf2.substring(8);
	    	pdf2=pdf2.substring(1,pdf2.length()-1);
	    	
	    	//pdf2=pdf2.substring(pdf2.length()-1);
	    	System.out.println(pdf2);
	    	File archivo = new File(VaadinService.getCurrent()
	  		.getBaseDirectory().getAbsolutePath()+"/WEB-INF/classes/RutinasFiles/"+pdf2);
	    	//File archivo= new File("192.168.1.148/classes/RutinasFiles/"+cboList.getSelectedItem().toString());
	    	PdfViewer pdf = new PdfViewer(archivo);
	        pdf.setSizeFull();
	        addComponent(pdf);
	    }
	

	
	

}
