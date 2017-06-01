package mx.edu.uaz.GymNutrition2.forms;

import java.io.File;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import pl.pdfviewer.PdfViewer;

public class ViewPdf extends FormLayout{
	
	private Button btnVer;
	
	
	public ViewPdf(){
		btnVer = new Button("Ver Archivo");
		
		addComponent(btnVer);
		
		btnVer.addClickListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String ruta,ext;
				ext="pdf";
				ruta = VaadinService.getCurrent()
		        		.getBaseDirectory().getAbsolutePath()+"/WEB-INF/classes/RutinasFiles/rutina.pdf";
				HorizontalLayout h1= new HorizontalLayout();
				File file=new File(ruta+'.'+ext);
				//PdfViewer c = new PdfViewer("RutinasFiles/rutina.pdf");
				PdfViewer c = new PdfViewer(file);
				h1.addComponent(c);
			}
		});
		
		
		
	}

}
