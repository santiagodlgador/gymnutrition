package mx.edu.uaz.GymNutrition2.vistas;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
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
public class SeguimientoUserForm extends CssLayout {
	protected ComboBox cbUsers;
	protected TextField tfPecho;
	protected TextField tfEspalda;
	protected TextField tfCintura;
	protected TextField tfCadera;
	protected CssLayout dateTimeSeguimiento;
	protected DateField dfFecha;
	protected TextField tfEdad;
	protected TextField tfTriceps;
	protected TextField tfBiceps;
	protected TextField tfCuadriceps;
	protected TextField tfGemelos;
	protected TextField tfPeso;
	protected TextField tfTalla;
	protected Button btnGuardar;

	public SeguimientoUserForm() {
		Design.read(this);
	}
}
