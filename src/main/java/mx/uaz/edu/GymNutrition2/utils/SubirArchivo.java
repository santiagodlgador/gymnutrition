package mx.uaz.edu.GymNutrition2.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

import mx.edu.uaz.GymNutrition2.modelos.Usuario;

public class SubirArchivo implements Receiver, SucceededListener{
	

	public File file;
	private File arch;
	//private Image arch;
	private String ruta, userFile;
	private Usuario user;
	private List<String> lista=new ArrayList<String>();
	
	public SubirArchivo(){
		//userFile=user.getNombre()
		 ruta= VaadinService.getCurrent()
 		.getBaseDirectory().getAbsolutePath()+"/WEB-INF/classes/RutinasFiles/";
		 //.getBaseDirectory().getAbsolutePath()+"/src/main/resources/RutinasFiles/";
				 //arch=farchivo;
		 file=null;
	}
	@Override
	public void uploadSucceeded(SucceededEvent event) {
		// TODO Auto-generated method stub
		if(file!=null){
			Notification.show("subió exitoso", Notification.Type.ERROR_MESSAGE);
			//arch.setSource(new FileResource(file));
			
			//arch.isFile();
			//file.setSource(new FileResource(arch));
			//file.set
		}
		
	}

	@Override
	public OutputStream receiveUpload(String filename, String mimeType) {
		// TODO Auto-generated method stub
		
		FileOutputStream fos= null;
		
		if(!filename.equals("")){
			String ext,fileR;
			List fileRut;
			int dot= filename.lastIndexOf('.');
			ext =filename.substring(dot + 1).toLowerCase();
			
			if( ext.equals("pdf") ){
				/*fileR=searchFile();
				if(!fileR.equals("")){
					file = new File(ruta +fileR);
					file.delete();
				}*/
				
				try{
					file=new File(ruta+filename+'.'+ext);
					fos=new FileOutputStream(file);
					
				}catch(final Exception e){
					Notification.show("No se pudo cargar el archivo " + e.getMessage(), Notification.Type.ERROR_MESSAGE);
					
				}
			}else{
				Notification.show("Archivo incompatible ",filename+" no es un formato valido ", Notification.Type.ERROR_MESSAGE);
			}
		}else{
			Notification.show("Selecciona un archivo", Notification.Type.ERROR_MESSAGE);
			
		}
		
		return fos;
	}
	
	public List searchFile(){
		String files[];
		String f="";
		String archivo;
		File dir = new File(ruta);
		//lista=new List();
		//List archivos=new List;
		files=dir.list();
		System.out.println(files.length);
		for (int i = 0; i < files.length; i++) {
			System.out.println(i);
			//int dot = files[i].lastIndexOf('.');
			//archivo=files[i].substring(0,dot);
			
			lista.add(files[i]);
			f=files[i];
			
		}
		return lista;
	}
	
	


}
