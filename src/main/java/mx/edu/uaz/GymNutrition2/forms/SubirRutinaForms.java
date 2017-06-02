package mx.edu.uaz.GymNutrition2.forms;

import java.io.File;

import com.vaadin.ui.Image;
import com.vaadin.ui.UI;

import mx.edu.uaz.GymNutrition2.vistas.SubirRutina;
import mx.uaz.edu.GymNutrition2.utils.BuscaComponentes;
import mx.uaz.edu.GymNutrition2.utils.SubirArchivo;
import pl.pdfviewer.PdfViewer;

public class SubirRutinaForms extends SubirRutina{
	
	public SubirRutinaForms() {
		enlazarDatos();
		//pdfView();
	}
	
	public void enlazarDatos(){
		//Image file= (Image) BuscaComponentes.findComponentById(UI.getCurrent(),"file");
		
		SubirArchivo receiver = new SubirArchivo();
		//btnSubirRutina.setReceiver(receiver);
		
		btnSubirRutina.setReceiver(receiver);
		btnSubirRutina.addSucceededListener(receiver);
	}
	

	
	

}
