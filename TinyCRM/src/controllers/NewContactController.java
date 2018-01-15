package controllers;

import java.util.regex.Pattern;

import exceptions.InvalidFormFieldData;
import models.CRMModel;
import swingViews.SwingView;
import views.ClientTCRMView;
import views.ContactTCRMView;

public class NewContactController extends ContactController{

	public NewContactController(SwingView contactView, CRMModel contactModel, CRMModel clientModel) {
		super(contactView, contactModel, clientModel);
	
	}
	
	
	public void validateForm() throws InvalidFormFieldData {
		getValidationErrors().clear();
		validateFirstName();
		validateLastName();
		validateCompany();
		validateTelephone();
		validateEmail();
		validateFacebook();
		if (getValidationErrors().size() > 0)
			throw new InvalidFormFieldData ("Invalid Form");
	}

	public void validateFirstName() throws InvalidFormFieldData {
		
		// The following 3 lines of code deal with saving the user's input as a new string
		//to match it to a certain pre-determined Java Regular expression to check the input's validity.
		//This same method is used on all validations with each respective field regular expression. 
		
		String firstNameInput = ((ContactTCRMView) getView()).getTextFirstName();
		String alphabeticPattern = "(?<=\\s|^)[a-zA-Z]*(?=[.,;:]?\\s|$)";

		boolean firstNameMatches = Pattern.matches(alphabeticPattern, firstNameInput);
		
		ContactTCRMView view = (ContactTCRMView) getView();
		if (view.getTextFirstName().trim().length() == 0) {
			addValidationError("FirstName", "Empty First Name. Required Field.");
		}
		
		if (!firstNameMatches) {
			addValidationError("FirstName", "First Name Must Only Use Alphabetic Characters");
		}
	}
	
	public void validateLastName() throws InvalidFormFieldData {
		
		String lastNameInput = ((ContactTCRMView) getView()).getTextLastName();
		String alphabeticPattern = "(?<=\\s|^)[a-zA-Z]*(?=[.,;:]?\\s|$)";

		boolean lastNameMatches = Pattern.matches(alphabeticPattern, lastNameInput);
		
		ContactTCRMView view = (ContactTCRMView) getView();
		if (view.getTextLastName().trim().length() == 0) {
			addValidationError("LastName", "Empty Last Name. Required Field.");
			
			if (!lastNameMatches) {
				addValidationError("LastName", "Last Name Must Only Use Alphabetic Characters");
			}
		}
	}	

	public void validateCompany() {

		// Creates a string with the user input and validates it against a regular
		// expression.

		String companyInput = ((ContactTCRMView) getView()).getTextCompany();
		String alphaNumericPattern = "[a-zA-Z ]*";

		boolean CompanyMatches = Pattern.matches(alphaNumericPattern, companyInput);

		ContactTCRMView view = (ContactTCRMView) getView();
		if (view.getTextCompany().trim().length() == 0) {
			addValidationError("Company", "Empty Company. Required Field.");
		}

		if (!CompanyMatches) {
			addValidationError("Company", "Company Name Must Only Use Alpha Numeric Characters");
		}
	}
	
	public void validateTelephone() {

		String TelephoneInput = ((ContactTCRMView) getView()).getTextTelephone(); 
		String TelPattern  = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
		
		boolean TelMatches = Pattern.matches(TelPattern, TelephoneInput);
		
		ContactTCRMView view = (ContactTCRMView) getView();
		if (view.getTextTelephone().trim().length() == 0) {
			addValidationError("Telephone", "Empty Telephone. Required Field.");
		}
		
		if (!TelMatches) {
			addValidationError("Telephone", "Company Telephone Must Only Use Numeric Characters and Follow The (123)-456-7890 Format");
		}
	}
	
	public void validateEmail() {

		String emailInput = ((ContactTCRMView) getView()).getTextEmail();
		String emailPattern = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";

		boolean MailMatches = Pattern.matches(emailPattern, emailInput);

		ContactTCRMView view = (ContactTCRMView) getView();
		if (view.getTextEmail().trim().length() == 0) {
			addValidationError("Email", "Empty Email. Required Field.");
		}

		if (!MailMatches) {
			addValidationError("Email",
					"Company Email Must Only Use Alpha-Numeric Characters and Follow The username@domain.xxx Format");
		}
	}
	
	public void validateFacebook() {
		String FacebookInput = ((ContactTCRMView) getView()).getTextFacebook(); 
		String alphaNumericPattern  = "[a-zA-Z ]*";
		
		boolean FacebookMatches = Pattern.matches(alphaNumericPattern, FacebookInput);
		
		ContactTCRMView view = (ContactTCRMView) getView();
		if (view.getTextFacebook().trim().length() == 0) {
			addValidationError("Facebook", "Empty Facebook. Required Field.");
		}
		
		if (!FacebookMatches) {
			addValidationError("Facebook", "Company Facebook Username Must Only Use Alpha Numeric Characters Without Spaces");
		}
	}

}
