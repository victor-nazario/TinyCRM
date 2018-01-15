package controllers;

import exceptions.InvalidFormFieldData;
import models.CRMModel;
import swingViews.SwingView;
import views.ClientTCRMView;
import java.util.regex.Pattern; 

public class NewClientController extends ClientController{

	//Definition of super constructor
	public NewClientController(SwingView view, CRMModel model) {
		super(view, model);
		
	}
	
	
	//Deals with the validation of user input on respective fields 
	
	public void validateForm() throws InvalidFormFieldData {
		getValidationErrors().clear();
		validateCompany();
		validateTelephone();
		validateEmail();
		validateWebsite();
		validateFacebook();
		if (getValidationErrors().size() > 0)
			throw new InvalidFormFieldData ("Invalid Form");
	}
	
	
	public void validateCompany() {
		
		// The following 3 lines of code deal with saving the user's input as a new string
		//to match it to a certain pre-determined Java Regular expression to check the input's validity.
		//This same method is used on all validations with each respective field regular expression. 
		
		String companyInput = ((ClientTCRMView) getView()).getTextCompany(); 
		String alphaNumericPattern  = "[a-zA-Z ]*";
		
		boolean CompanyMatches = Pattern.matches(alphaNumericPattern, companyInput);
		
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextCompany().trim().length() == 0) {
			addValidationError("Company", "Empty Company. Required Field.");
		}
		
		if (!CompanyMatches) {
			addValidationError("Company", "Company Name Must Only Use Alpha Numeric Characters");
		}
	}
	
	public void validateTelephone() {

		String TelephoneInput = ((ClientTCRMView) getView()).getTextTelephone(); 
		String TelPattern  = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
		
		boolean TelMatches = Pattern.matches(TelPattern, TelephoneInput);
		
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextTelephone().trim().length() == 0) {
			addValidationError("Telephone", "Empty Telephone. Required Field.");
		}
		
		if (!TelMatches) {
			addValidationError("Telephone", "Company Telephone Must Only Use Numeric Characters and Follow The (123)-456-7890 Format");
		}
	}
	
	public void validateEmail() {
		
		String emailInput = ((ClientTCRMView) getView()).getTextEmail(); 
		String emailPattern  = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
		
		boolean MailMatches = Pattern.matches(emailPattern, emailInput);
		
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextEmail().trim().length() == 0) {
			addValidationError("Email", "Empty Email. Required Field.");
		}
		
		if (!MailMatches) {
			addValidationError("Email", "Company Email Must Only Use Alpha-Numeric Characters and Follow The username@domain.xxx Format");
		}
	}
	
	public void validateWebsite() {
		
		String WebsiteInput = ((ClientTCRMView) getView()).getTextWebsite(); 
		String webPattern  = "^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";
		boolean WebMatches = Pattern.matches(webPattern, WebsiteInput);
		
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextWebsite().trim().length() == 0) {
			addValidationError("Website", "Empty Website. Required Field.");
		}
		
		if (!WebMatches) {
			addValidationError("Website", "Company Website Must Only Use Alpha-Numeric Characters");
		}
	}
	
	public void validateFacebook() {
		String FacebookInput = ((ClientTCRMView) getView()).getTextFacebook(); 
		String alphaNumericPattern  = "[a-zA-Z ]*";
		
		boolean FacebookMatches = Pattern.matches(alphaNumericPattern, FacebookInput);
		
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextFacebook().trim().length() == 0) {
			addValidationError("Facebook", "Empty Facebook. Required Field.");
		}
		
		if (!FacebookMatches) {
			addValidationError("Facebook", "Company Facebook Username Must Only Use Alpha Numeric Characters Without Spaces");
		}
	}
	
	

}
