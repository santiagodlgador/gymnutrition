package mx.edu.uaz.GymNutrition2.forms;

import com.vaadin.data.Binder;
import com.vaadin.data.Converter;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;

import mx.edu.uaz.GymNutrition2.accesodatos.ADSeguimiento;
import mx.edu.uaz.GymNutrition2.accesodatos.ADUsuario;
import mx.edu.uaz.GymNutrition2.modelos.*;
import mx.edu.uaz.GymNutrition2.vistas.SeguimientoUserForm;


public class SeguimientoForms extends SeguimientoUserForm{
	
	private Binder<Seguimiento> binder;
	private Seguimiento seguimiento;
	private ADSeguimiento adSeguimiento;
	private boolean edicion=false;
	
	
	public SeguimientoForms(){
		this.seguimiento=new Seguimiento();
		binder=new Binder<Seguimiento>(Seguimiento.class);
		
		binder.setBean(seguimiento);
		crearFormulario();
	}
	
	public void crearFormulario(){
		
		//cbUsers=new ComboBox<Usuario>("Usuario");
		//cbUsers.setEmptySelectionAllowed(false);
		//cbUsers.setRequiredIndicatorVisible(true);
		
		
		
		
		binder= new Binder<Seguimiento>(Seguimiento.class);
		binder.setBean(seguimiento);
		ADUsuario adUsuarios= new ADUsuario();
		cbUsers.setItems(adUsuarios.obtenerTodos());
		
		binder.forField(tfPecho)
		.asRequired("Pecho es requerido")
		.bind("pecho");
		
		binder.forField(tfBiceps)
			.asRequired("Biceps es requerido")
			.bind("biceps");
		binder.forField(tfTriceps)
			.asRequired("Triceps es requerido")
			.bind("triceps");
		
		binder.forField(tfEspalda)
			.asRequired("Espalda es requerido")
			.bind("espalda");
		
		binder.forField(tfCintura)
			.asRequired("Cintura requerida")
			.bind("abdomen");
		
		binder.forField(tfCadera)
		.asRequired("Cadera requerida")
		.bind("cadera");
		
		binder.forField(tfCuadriceps)
		.asRequired("Cuadriceps requeridos")
		.bind("cuadriceps");
		
		binder.forField(tfGemelos)
		.asRequired("Los gemelos son requeridos")
		.bind("gemelos");
		
		binder.forField(tfPeso)
		.asRequired("El peso es requerido")
		.bind("peso");
		
		binder.forField(tfTalla)
		.asRequired("La talla es requerido")
		.bind("talla");
		
		binder.forField(tfEdad)
		.asRequired("La edad es requerida")
		.bind("edad");
		
		binder.forField(dfFecha)
		.asRequired("La fecha es requerida")
		//.withConverter(new LocalDateTimeToDateConverter())
		.bind("fecha");
		
		binder.forField(cbUsers)
		.asRequired("Debes seleccionar un usuario")
		.bind("idUsuario");
		
		btnGuardar.addClickListener(new CrudSeguimiento());
		
	}
	
	class CrudSeguimiento implements ClickListener{

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			try{
				if(binder.validate().isOk()){
					adSeguimiento=new ADSeguimiento();
					System.out.println("isOk");
					boolean ok=false;
					ok=adSeguimiento.guardar(seguimiento);
					if(edicion){
						ok= adSeguimiento.guardar(seguimiento);
						
					}
					if(ok){
						System.out.println("oki");
						Notification.show("El seguimiento se "+((edicion)?"actualizó":"agregó")+" correctamente");
						System.out.println("seguimiento ok");
						seguimiento=new Seguimiento();
						binder.setBean(seguimiento);
						System.out.println("ok");
					}
				}else{
					Notification.show("Verifica tus datos", Notification.Type.WARNING_MESSAGE);
					System.out.println("seguimiento else");
				}
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
		
	}

}
