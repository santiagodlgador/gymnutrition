package mx.edu.uaz.GymNutrition2.vistas;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class RegistroUserForm extends CssLayout {
	protected TextField tfNombre;
	protected TextField tfApellidos;
	protected TextField tfPeso;
	protected TextField tfAltura;
	protected DateField dtfFecha;
	protected TextField tfEmail;
	protected PasswordField pfPassword;
	protected TextField tfTelefono;
	protected TextField tfTipoUser;
	protected Button btnGuardar;

	public RegistroUserForm() {
		Design.read(this);
	}
}
