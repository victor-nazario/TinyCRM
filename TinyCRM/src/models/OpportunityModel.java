package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import beans.CRMBean;
import beans.ClientBean;
import beans.OpportunityBean;

public class OpportunityModel extends CRMModel {
	
	private static String OPPORTUNITY_FILE = "data/opportunity.tsv";

	public OpportunityModel() {
		super();
	}
	
	@Override
	public void doInit() {
		super.doInit();
		ArrayList<CRMBean> beans = parseBeansFromFile(OPPORTUNITY_FILE);
		this.setList(beans);
		setIndex(0);	}

//	@Override
//	public void doLeft() {
//		super.doLeft();
//	}

//	@Override
//	public void doRight() {
//		super.doRight();
//	}

//	@Override
//	public void doEdit() {
//		super.doEdit();
//	}

	@Override
	public void doAdd() {
		long id = 1;
		if (this.getCount() > 0) {
			id = ((OpportunityBean) this.getBean(this.getCount()-1)).getId() + 1;
		}
		this.getAllBeans().add(new OpportunityBean(id));
		this.setIndex(this.getCount() - 1);
	}

//	@Override
//	public void doDelete() {
//		super.doDelete();
//
//	}

	@Override
	public void doSave() {
		super.doSave();
		saveBeansToFile(OPPORTUNITY_FILE);
	}
	
//	@Override
//	public void doCancel() {
//		super.doCancel();
//	}
	
	public ArrayList<CRMBean> parseBeansFromFile(String filename) {
		File inputFile = new File(filename);
		try {
			ArrayList<CRMBean> OpportunityBeans = new ArrayList<CRMBean>();
			Scanner inputScanner = new Scanner(inputFile);
			inputScanner.nextLine();  // Ignore header line
			int count = 0;
			inputScanner.useDelimiter("[\t\n]");
			while (inputScanner.hasNextLine()) {
				String ID = inputScanner.next();
				int id = Integer.parseInt(ID);
				OpportunityBean newBean = new OpportunityBean(id);
				String company = inputScanner.next();
				newBean.setCompany(company);
				String telephone = inputScanner.next();
				newBean.setTelephone(telephone);
				String email = inputScanner.next();
				newBean.setEmail(email);
				String website = inputScanner.next();
				newBean.setWebsite(website);
				String facebook = inputScanner.next();
				newBean.setFacebook(facebook);
				inputScanner.nextLine();  // Skip over anything left in line
				OpportunityBeans.add(newBean);
				count++;
			}
			inputScanner.close();
			return OpportunityBeans;
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Input file not Found");
		}
	}
	
	public void saveBeansToFile(String filename) {
		
		ArrayList<CRMBean> OpportunityBeans = getAllBeans();
		File outputFile = new File(filename);
		try {
			PrintWriter out = new PrintWriter(outputFile);
			// Print Header Line
			out.println("TinyCRM Clients data file");
			for (CRMBean bean : OpportunityBeans) {
				out.println(beanToFileLine(bean));
			}
			out.close();
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Output file not Found");
		}
	}
	
	public String beanToFileLine(CRMBean bean) {

		String result = "";
		OpportunityBean cb = (OpportunityBean) bean;
		result += cb.getId();
		result += '\t';
		result += cb.getCompany();
		result += '\t';
		result += cb.getTelephone();
		result += '\t';
		result += cb.getEmail();
		result += '\t';
		result += cb.getWebsite();
		result += '\t';
		result += cb.getFacebook();
		return result;
		
	}

}

