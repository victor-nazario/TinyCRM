package main;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import controllers.CRMController;
import controllers.NewClientController;
import controllers.NewContactController;
import controllers.OpportunityController;
import models.CRMModel;
import models.ClientModel;
import models.ContactModel;
import swingViews.ClientSwingView;
import swingViews.ContactSwingView;
import swingViews.OpportunitySwingView;
import swingViews.SwingView;

public class CRMMain {

	// Create Contacts module MVC objects
	public static SwingView clientView = new ClientSwingView();
	public static CRMModel clientModel = new ClientModel();
	public static CRMController NewclientController = new NewClientController(clientView, clientModel);

	// Create Clients module MVC objects
	public static SwingView contactView = new ContactSwingView();
	public static CRMModel contactModel = new ContactModel();
	// Contacts module has relationship with Clients module so we pass the Clients model object to the Contacts controller
	public static CRMController NewcontactController = new NewContactController(contactView, contactModel, clientModel); 
	
	private static String currentModule;
	private static SwingView currentView;
	
	//Create Opportunity module MVC objects
	
	public static SwingView OpportunityView = new OpportunitySwingView();
	public static CRMModel OpportunityModel = new models.OpportunityModel();//What does the models. do?
	public static CRMController OpportunityController = new OpportunityController(OpportunityView, contactModel); 
	

	// mapModuleToView holds the view object for each module
	public static Map<String,SwingView> mapModuleToView = new HashMap<String,SwingView>();
	// mapModuleToIndex holds the index in the module selection combo box for each module
	public static Map<String,Integer> mapModuleToIndex = new HashMap<String,Integer>();

	public static void main (String[] args) {

		contactView.setModuleSelectionItems(new String[] {"Contacts", "Clients", "Opportunities", "Reports"});
		clientView.setModuleSelectionItems(new String[] {"Contacts", "Clients", "Opportunities", "Reports"});
		OpportunityView.setModuleSelectionItems(new String[] {"Contacts", "Clients", "Opportunities", "Reports"});
		
		
		mapModuleToView.put("Contacts", contactView);
		mapModuleToView.put("Clients", clientView);
		mapModuleToView.put("Opportunity", OpportunityView);

		mapModuleToIndex.put("Contacts", 0);
		mapModuleToIndex.put("Clients", 1);
		mapModuleToIndex.put("Opportunities", 1);
		mapModuleToIndex.put("Reports", 1);
		
		NewclientController.doInit();
		NewclientController.setSwitchModuleListener((String s) -> CRMMain.switchToModule(s));

		NewcontactController.doInit();
		NewcontactController.setSwitchModuleListener((String s) -> CRMMain.switchToModule(s));
		
		
		
		OpportunityController.doInit();
		OpportunityController.setSwitchModuleListener((String s) -> CRMMain.switchToModule(s));

		//contactView.setModuleSelected(mapModuleToIndex.get("Contacts"));
		switchToModule("Clients"); // Initially open the Contacts module

	}

	public static void switchToModule(String moduleName) {

		if (moduleName.equals(currentModule)) return;
		
		SwingView nextView = mapModuleToView.get(moduleName);
		
		if (nextView != null) {
			
			nextView.setMessagesText("Welcome to TinyCRM: " + moduleName);

			nextView.setVisible(true);
			if (currentView != null) currentView.setVisible(false);
			
			currentModule = moduleName;
			currentView = nextView;
			currentView.setModuleSelected(mapModuleToIndex.get(currentModule));
		}
		else {
			currentView.setModuleSelected(mapModuleToIndex.get(currentModule));
			currentView.setMessagesText(moduleName + " Module Not Available Yet");
		}
	}
}
