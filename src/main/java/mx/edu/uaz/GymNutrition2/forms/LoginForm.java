package mx.edu.uaz.GymNutrition2.forms;

/*import java.util.List;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import mx.edu.uaz.GymNutrition2.accesodatos.ADUsuario;
import mx.edu.uaz.GymNutrition2.modelos.Usuario;
import mx.edu.uaz.GymNutrition2.vistas.LoginU;


public class LoginForm extends LoginU{
	
	private Usuario usuario;
	public LoginForm(){
		
		ADUsuario adUser;
		adUser=new ADUsuario();
		
		btnIngresar.addClickListener(new ClickListener(){
			public void buttonClick(ClickEvent event){
				List<Usuario>list=adUser.obtenerTodos();
				for(Usuario component: list){
					if(component.getCorreo().equals(tfUser.getValue())&&component.getPassword().equals(pfPassword.getValue())){
						usuario=component;
					}
				}
				
				if(usuario!=null){
					Notification.show("Bienvenido al sistema","Acceso exitoso al sistema",Notification.Type.TRAY_NOTIFICATION);
					VaadinSession.getCurrent().getSession().setMaxInactiveInterval(300); // 5 minutes
					VaadinSession.getCurrent().setAttribute("usuario", usuario);
					
					if(Integer.valueOf(usuario.getTipoUser())==0){
						UI.getCurrent().setContent(new PrincipalForm());
					}else{
						if(Integer.valueOf(usuario.getTipoUser())==1){
							UI.getCurrent().setContent(new PrincipalUserForm());
						}
					}
				
			}else{
				Notification.show("Datos Incorrectos","Revisa tu informacion",Notification.Type.ERROR_MESSAGE);
				}
			}
			
			
			
		});
	}

}*/



import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;

import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.ui.NotificationRole;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import mx.edu.uaz.GymNutrition2.accesodatos.ADUsuario;
import mx.edu.uaz.GymNutrition2.modelos.Usuario;
import mx.uaz.edu.GymNutrition2.utils.Hash;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;



import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;

public class LoginForm extends FormLayout{
	private TextField tfUsuario;
	private PasswordField pfContra;
	private Button btnIngresar;
	private String usuario;
	private String pass;
	private Usuario user;
	private ADUsuario ad;
	public LoginForm(){
		crearFormularion();
		setStyleName("mifo2");
	}
	
	public void crearFormularion(){
		ad= new ADUsuario();
		tfUsuario = new TextField("Correo");
		
		pfContra = new PasswordField("Contraseña");
		
		btnIngresar = new Button("Ingresar");
		
		//btnRegistrar= new Button("Registrar");
		//btnRegistrar.setStyleName("miboton");
		btnIngresar.setStyleName("miboton");
		HorizontalLayout h1= new HorizontalLayout();
		h1.addComponents(btnIngresar);
		h1.setSpacing(true);
		
		addComponent(tfUsuario);
		addComponent(pfContra);
		addComponent(h1);
		
		
		
		setResponsive(true);
		setMargin(true);
		setSpacing(true);
		
		btnIngresar.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				List<Usuario> lis=ad.obtenerTodos();
				String pass= Hash.getHash(pfContra.getValue());
				System.out.println("pass"+pass);
				Usuario usas=new Usuario();
				System.out.println("usas"+usas.getPassword()+" "+usas.getCorreo());
				for (Usuario us : lis) {
					System.out.println(us.getCorreo()+" holis"+us.getPassword());
					System.out.println(us.getPassword()+"holis2"+us.getNombre()+"peso"+us.getPeso()+"pass"+us.getPassword());
					System.out.println("password"+us.getPassword());
					if((us.getPassword().equals(pass))&&(us.getCorreo().equals(tfUsuario.getValue()))){
						
						user=us;
						System.out.println("Hash "+Hash.getHash(pfContra.getValue()));
						System.out.println("Us: "+user.getPassword());
					}
				}
				
				//user=ad.buscarValidarActivo(tfUsuario.getValue(), pfContra.getValue());
				if(user!=null){
					//System.out.println(Integer.parseInt(String.valueOf(user.getActivo())));
					System.out.println("Hash2 "+Hash.getHash(pfContra.getValue()));
					System.out.println("Us2: "+user.getPassword());
					Notification.show("Bienvenido al sistema","Acceso exitoso al sistema",Notification.Type.TRAY_NOTIFICATION);
					//VaadinSession.getCurrent().getSession().setMaxInactiveInterval(300); // 5 minutes
					VaadinSession.getCurrent().setAttribute("usuario", user);
					//Usuario user = (Usuario) VaadinSession.getCurrent().getAttribute("usuario");
					if(Integer.valueOf(user.getTipoUser())==0){
						System.out.println("0");
						UI.getCurrent().setContent(new PrincipalForm());
					}else{
						if(Integer.valueOf(user.getTipoUser())==1){
							UI.getCurrent().setContent(new PrincipalUserForm());
							System.out.println("1");
						}
					}
					
				}else{
					Notification.show("Datos Incorrectos","Revisa tu informacion",Notification.Type.ERROR_MESSAGE);
				}
			
				
			}
		});
		
		
	}
	
}

