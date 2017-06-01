package mx.edu.uaz.GymNutrition2.forms;

import com.vaadin.data.Binder;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

import mx.edu.uaz.GymNutrition2.accesodatos.ADUsuario;
import mx.edu.uaz.GymNutrition2.modelos.Usuario;
import mx.edu.uaz.GymNutrition2.vistas.RegistroUserForm;
import mx.uaz.edu.GymNutrition2.utils.Hash;


public class RegistroUserForms extends RegistroUserForm{
	
	private Binder<Usuario> binder;
	private Usuario usuario;
	private ADUsuario adUsuario;
	private boolean edicion=false;
	
	public RegistroUserForms(){
		usuario=new Usuario();
		binder= new Binder<Usuario>(Usuario.class);
		
		binder.setBean(usuario);
		enlazarDatos();
		
	}
	
	public void enlazarExterno (Usuario usuario){
		this.usuario=usuario;
		binder.setBean(usuario);
		btnGuardar.setCaption("Actualizar");
		edicion=true;
	}
	
	public void enlazarDatos(){
		binder.setBean(usuario);
		binder.forField(tfNombre)
			.asRequired("El nombre es requerido")
			.withValidator(nombre -> nombre.length() >=3, "El nombre debe contener al menos 3 caracteres")
			.bind(Usuario::getNombre,Usuario::setNombre);
		
		binder.forField(tfApellidos)
			.asRequired("Los apellidos son requeridos")
			.withValidator(apellidos ->apellidos.length() >=4, "Los apellidos deben de contener al menos 4 caracteres")
			.bind(Usuario::getApellidos, Usuario::setApellidos);
		

		binder.forField(tfEmail)
		.asRequired("El e-mail es requerido")
		.withValidator(new EmailValidator("El correo {0} no tiene el formato correcto"))
		.bind(Usuario::getCorreo,Usuario::setCorreo);
		//.bind("correo");
		
		//binder.forField(tfPassword)
		String passSha1=Hash.getHash(pfPassword.getValue().toString());
		binder.forField(pfPassword)
		.asRequired("La contraseña es requerida")
		.withValidator(password ->password.length() >=4, "La contraseña debe tener al menos 4 caracteres")
		//.bind(Hash.getHash((Usuario::getPassword,Usuario::setPassword)));
		//.bind(Hash.getHash(passSha1));
		.bind(Usuario::getPassword,Usuario::setPassword);
		
		binder.forField(dtfFecha)
		.asRequired("La fecha es requerida")
		.bind("fecha");
		
		binder.forField(tfTelefono)
		.withValidator(new RegexpValidator("El teléfono {0} tiene un formato inválido", "^([0-9]{3})-? ?([0-9]{3})-? ?([0-9]{2})-? ?([0-9]{2})$"))
		.bind("telefono");
		
		binder.forField(tfPeso)
		//.withValidator(new RegexpValidator("El peso {0} tiene un formato inválido", "^([0-9]{3})-? ?([0-9]{3})-? ?([0-9]{2})-? ?([0-9]{2})$"))
		.bind("peso".toString());
		
		binder.forField(tfAltura)
		//.withValidator(new RegexpValidator("La altura {0} tiene un formato inválido", "^([0-9]{3})-? ?([0-9]{3})-? ?([0-9]{2})-? ?([0-9]{2})$"))
		.bind("altura");
		
		binder.forField(tfTipoUser)
		.bind(Usuario::getTipoUser,Usuario::setTipoUser);
		
		
		btnGuardar.addClickListener(new CrudUsuario());
		
	}
	class CrudUsuario implements ClickListener{

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
			if(binder.validate().isOk()){
				adUsuario= new ADUsuario();
				boolean ok=false;
				if(edicion){
					ok= adUsuario.actualizarUsuario(usuario);
					btnGuardar.setCaption("Guardar");
				}
				else{
					ok= adUsuario.guardar(usuario);
					((ListaUsuariosForm)((TabSheet)RegistroUserForms.this.getParent()).getTab(1).getComponent()).llenaGrid();

				}
				if(ok){
					Notification.show("El usuario "+usuario.getNombre()+" se "+((edicion)?"acualizó":"agregó")+" correctamente", Notification.Type.TRAY_NOTIFICATION);
				}
			}else{
				Notification.show("Favor de verificar los datos", Notification.Type.WARNING_MESSAGE);
			}
			
		}
		
	}
	
}
