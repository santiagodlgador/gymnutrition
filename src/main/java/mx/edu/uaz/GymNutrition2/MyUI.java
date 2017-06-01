package mx.edu.uaz.GymNutrition2;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
//import com.vaadin.ui.LoginForm;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.StartedEvent;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import mx.edu.uaz.GymNutrition2.forms.LoginForm;
import mx.edu.uaz.GymNutrition2.forms.PrincipalForm;
import mx.edu.uaz.GymNutrition2.vistas.LoginU;
import mx.edu.uaz.GymNutrition2.vistas.RegistroUserForm;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new PrincipalForm());
    	//setContent(new LoginU());
    	//setContent(new PrincipalForm());
    	/* Window mainWindow = new Window("Singleuploadclick Application");
    	    Label label = new Label("Hello Vaadin user");
    	    
    	    mainWindow.addComponent(label);

    	    Label status = new Label("Please select a file to upload");
    	   Upload upload = new Upload(null, receiver);

    	    upload.setImmediate(true);
    	    upload.setButtonCaption("Select file");

    	    upload.addListener(new Upload.StartedListener() {
    	        private static final long serialVersionUID = 1L;

    	        @Override
    	        public void uploadStarted(StartedEvent event) {
    	            upload.setVisible(false);
    	            status.setValue("Uploading file \"" + event.getFilename() + "\"");
    	        }
    	    });

    	    upload.addListener(new Upload.ProgressListener() {
    	        private static final long serialVersionUID = 1L;

    	        @Override
    	        public void updateProgress(long readBytes, long contentLength) {
    	        }

    	    });

    	    upload.addListener(new Upload.SucceededListener() {
    	        private static final long serialVersionUID = 1L;

    	        @Override
    	        public void uploadSucceeded(SucceededEvent event) {
    	            status.setValue("Uploading file \"" + event.getFilename() + "\" succeeded");
    	        }
    	    });

    	    upload.addListener(new Upload.FailedListener() {
    	        private static final long serialVersionUID = 1L;

    	        @Override
    	        public void uploadFailed(FailedEvent event) {
    	            status.setValue("Uploading interrupted");
    	        }
    	    });

    	    upload.addListener(new Upload.FinishedListener() {
    	        private static final long serialVersionUID = 1L;

    	        @Override
    	        public void uploadFinished(FinishedEvent event) {
    	            upload.setVisible(true);
    	            upload.setCaption("Select another file");
    	        }
    	    });

    	    mainWindow.addComponent(status);
    	    mainWindow.addComponent(upload);            
    	    setMainWindow(mainWindow);*/
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
