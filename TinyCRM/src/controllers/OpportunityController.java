package controllers;

import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.InvalidFormFieldData;
import main.CRMMain;
import models.CRMModel;
import models.ClientModel;
import swingViews.OpportunitySwingView;
import views.ContactTCRMView;
import views.OpportunityTCRMView;
import views.TCRMView;
import swingViews.SwingView;

public class OpportunityController extends CRMController {

	public OpportunityController(SwingView opportunityView, CRMModel opportunityModel, CRMModel clientModel) {
		super(opportunityView, opportunityModel);
		OpportunitySwingView ov = (OpportunitySwingView) opportunityView;
		ClientModel clientModel2 = (ClientModel) clientModel;

		ov.setSelectClientItems(clientModel2.getAllBeans());
		ov.clearFieldErrors();
		ov.setSelectClientListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Client Combo Box Selected");
			}
		});
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validateForm() throws InvalidFormFieldData {
		getValidationErrors().clear();
		validateDescription();
		validateValue();
		validateDate();
		if (getValidationErrors().size() > 0)
			throw new InvalidFormFieldData ("Invalid Form");// TODO Auto-generated method stub

	}

	protected void refreshView() {
		super.refreshView();
		String errorString;
		OpportunitySwingView ov = (OpportunitySwingView) getView();
		ov.clearFieldErrors();
		Map<String, String> validationErrors = getValidationErrors();
		if (validationErrors.size() > 0) {
			errorString = "Fields in red are invalid";
			if (validationErrors.containsKey("Description")) { ov.setErrorDescription(validationErrors.get("Description")); }
			if (validationErrors.containsKey("Value")) { ov.setErrorValue(validationErrors.get("Value")); }
			if (validationErrors.containsKey("Date")) { ov.setErrorDate(validationErrors.get("Date")); }
			if (validationErrors.containsKey("Status")) { ov.setErrorStatus(validationErrors.get("Status")); }
			ov.setMessagesText(errorString);
		}
	}

	
	public void doLeft() {
		System.out.println("OpportunityController.doLeft()");
		super.doLeft();
	}
	
	public void doInit() {
		super.doInit();
		refreshDropdowns();
	}

	public void doRight() {
		System.out.println("OpportunityController.doRight()");
		super.doRight();
	}

	public void doEdit() {
		System.out.println("OpportunityController.doRight()");
		refreshDropdowns();
		super.doEdit();
	}

	public void doAdd() {
		System.out.println("OpportunityController.doAdd()");
		refreshDropdowns();
		super.doAdd();
	}

	public void doDelete() {
		System.out.println("OpportunityController.doDelete()");
		super.doDelete();
	}

	public void doSave() {
		System.out.println("OpportunityController.doSave()");
		super.doSave();
	}

	public void doSelectClient() {
		this.refreshView();
	}
	
	public void validateDescription() throws InvalidFormFieldData {
		OpportunityTCRMView view = (OpportunityTCRMView) getView();
		if (view.getTextDescription().trim().length() == 0) {
			addValidationError("Description", "Empty Description. Required Field.");
		}
	}
	
	public void validateValue() throws InvalidFormFieldData {
		OpportunityTCRMView view = (OpportunityTCRMView) getView();
		if (view.getTextValue().trim().length() == 0) {
			addValidationError("Value", "Empty Value. Required Field.");
		}
		else if(!view.getTextValue().matches("\\$\\d+(\\.\\d{2})?")) {
			addValidationError("Value", "Enter price in dollars and cents (Preceded by $).");
		}
	}
	
	public void validateDate() throws InvalidFormFieldData {
		OpportunityTCRMView view = (OpportunityTCRMView) getView();
		if (view.getTextDate().trim().length() == 0) {
			addValidationError("Date", "Empty Date. Required Field.");
		}
		else if(!view.getTextDate().matches("[0-9]{2}.[0-9]{2}.(?:[0-9]{2})?[0-9]{2}")) {
			addValidationError("Date", "Date input must be in dd/mm/yyyy.");
		}
	}
	
	

	@Override
	public void refreshDropdowns() {
		OpportunityTCRMView ov = (OpportunityTCRMView) getView();
		ov.setSelectClientItems(CRMMain.clientModel.getAllBeans());// TODO Auto-generated method stub

	}

}