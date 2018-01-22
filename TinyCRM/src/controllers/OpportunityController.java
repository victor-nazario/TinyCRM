package controllers;

import java.util.regex.Pattern;

import exceptions.InvalidFormFieldData;
import models.CRMModel;
import swingViews.SwingView;
import views.ClientTCRMView;
import views.OpportunityTCRMView;
import views.TCRMView;

public class OpportunityController extends CRMController {
	//Definition of super constructor
	public OpportunityController(TCRMView crmView, CRMModel crmModel) {
		super(crmView, crmModel);

	}




	//Deals with the validation of user input on respective fields 

	public void validateForm() throws InvalidFormFieldData {
		getValidationErrors().clear();
		validateGain();
		validateLoss();
		validateVocalNotice();
		validateWrittenNotice();
		validateCompany();

		if (getValidationErrors().size() > 0)
			throw new InvalidFormFieldData ("Invalid Form");
	}


	//Opportunity Validations

	private void validateWrittenNotice() {

		String WrittenNoticeInput = ((OpportunityTCRMView) getView()).getTextWrittenNotice(); 
		String alphaNumericPattern  = "[a-zA-Z ]*";

		boolean WrittenNoticeMatches = Pattern.matches(alphaNumericPattern, WrittenNoticeInput);

		OpportunityTCRMView view = (OpportunityTCRMView) getView();
		if (view.getTextWrittenNotice().trim().length() == 0) {
			addValidationError("WrittenNotice", "Empty Company. Required Field.");
		}

		if (!WrittenNoticeMatches) {
			addValidationError("WrittenNotice", "Written Notices Must Only Use Alpha Numeric Characters");
		}

	}




	private void validateVocalNotice() {
		String VolcalNoticeInput = ((OpportunityTCRMView) getView()).getTextVerbalNotice(); 
		String alphaNumericPattern  = "[a-zA-Z ]*";

		boolean VocalNoticeMatches = Pattern.matches(alphaNumericPattern, VolcalNoticeInput);

		OpportunityTCRMView view = (OpportunityTCRMView) getView();
		if (view.getTextVerbalNotice().trim().length() == 0) {
			addValidationError("VocalNotice", "Empty Vocal Notice. Required Field.");
		}

		if (!VocalNoticeMatches) {
			addValidationError("VocalNotice", "Vocal Notices Must Only Use Alpha Numeric Characters");
		}

	}




	private void validateLoss() {

		String LossInput = ((OpportunityTCRMView) getView()).getTextLoss(); 
		String LossPattern  = "[a-zA-Z ]*";

		boolean LossMatches = Pattern.matches(LossPattern, LossInput);

		OpportunityTCRMView view = (OpportunityTCRMView) getView();
		if (view.getTextLoss().trim().length() == 0) {
			addValidationError("Loss", "Empty Loss. Required Field.");
		}

		if (!LossMatches) {
			addValidationError("Loss", "Company Losses Must Only Use Numeric Characters and Follow The 1002.0 Format");
		}
	}




	private void validateGain() {
		String GainInput = ((OpportunityTCRMView) getView()).getTextGain(); 
		String GainsPattern  = "[a-zA-Z ]*";

		boolean LossMatches = Pattern.matches(GainsPattern, GainInput);

		OpportunityTCRMView view = (OpportunityTCRMView) getView();
		if (view.getTextGain().trim().length() == 0) {
			addValidationError("Gain", "Empty Gain. Required Field.");
		}

		if (!LossMatches) {
			addValidationError("Gain", "Company Gain Must Only Use Numeric Characters and Follow The 1002.0 Format");
		}

	}




	public void validateCompany() {

		// The following 3 lines of code deal with saving the user's input as a new string
		//to match it to a certain pre-determined Java Regular expression to check the input's validity.
		//This same method is used on all validations with each respective field regular expression. 

		String companyInput = ((OpportunityTCRMView) getView()).getTextCompany(); 
		String alphaNumericPattern  = "[a-zA-Z ]*";

		boolean CompanyMatches = Pattern.matches(alphaNumericPattern, companyInput);

		OpportunityTCRMView view = (OpportunityTCRMView) getView();
		if (view.getTextCompany().trim().length() == 0) {
			addValidationError("Company", "Empty Company. Required Field.");
		}

		if (!CompanyMatches) {
			addValidationError("Company", "Company Name Must Only Use Alpha Numeric Characters");
		}
	}



	@Override
	public void refreshDropdowns() {


	}

}
