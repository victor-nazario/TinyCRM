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
		
		//Creates  a string with the user input and validates it against a regular expression. 
		
		String companyInput = ((ClientTCRMView) getView()).getTextCompany(); 
		String alphaNumericPattern  = "^[a-zA-Z0-9\\\\s]*$";
		
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
		String alphaNumericPattern  = "\\\\d{10}|(?:\\\\d{3}-){2}\\\\d{4}|\\\\(\\\\d{3}\\\\)\\\\d{3}-?\\\\d{4}";
		boolean TelMatches = Pattern.matches(alphaNumericPattern, TelephoneInput);
		
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextTelephone().trim().length() == 0) {
			addValidationError("Telephone", "Empty Telephone. Required Field.");
		}
		
		if (!TelMatches) {
			addValidationError("Company", "Company Telephone Must Only Use Numeric Characters and Follow The (123)-456-7890 Format");
		}
	}
	
	public void validateEmail() {
		
		String EmailInput = ((ClientTCRMView) getView()).getTextEmail(); 
		String alphaNumericPattern  = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
		
		boolean MailMatches = Pattern.matches(alphaNumericPattern, EmailInput);
		
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextEmail().trim().length() == 0) {
			addValidationError("Email", "Empty Email. Required Field.");
		}
		
		if (!MailMatches) {
			addValidationError("Company", "Company Email Must Only Use Alpha-Numeric Characters and Follow The username@domain.xxx Format");
		}
	}
	
	public void validateWebsite() {
		
		String WebsiteInput = ((ClientTCRMView) getView()).getTextWebsite(); 
		String alphaNumericPattern  = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		boolean WebMatches = Pattern.matches(alphaNumericPattern, WebsiteInput);
		
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextWebsite().trim().length() == 0) {
			addValidationError("Website", "Empty Website. Required Field.");
		}
		
		if (!WebMatches) {
			addValidationError("Company", "Company Website Must Only Use Alpha=Numeric Characters");
		}
	}
	
	public void validateFacebook() {
		String FacebookInput = ((ClientTCRMView) getView()).getTextFacebook(); 
		String alphaNumericPattern  = "^[a-zA-Z0-9\\\\s]*$";
		
		boolean FacebookMatches = Pattern.matches(alphaNumericPattern, FacebookInput);
		
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextFacebook().trim().length() == 0) {
			addValidationError("Facebook", "Empty Facebook. Required Field.");
		}
		
		if (!FacebookMatches) {
			addValidationError("Company", "Company Facebook Must Only Use Alpha Numeric Characters");
		}
	}
	
	

}
