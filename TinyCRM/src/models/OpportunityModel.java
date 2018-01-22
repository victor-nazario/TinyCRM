
package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import beans.CRMBean;
import beans.OpportunityBean;

public class OpportunityModel extends CRMModel {

	private static String OPPORTUNITIES_FILE = "data/opportunity.tsv";

	public OpportunityModel() {
		super();
	}

	@Override
	public void doInit() {
		super.doInit();
		ArrayList<CRMBean> beans = parseBeansFromFile(OPPORTUNITIES_FILE);
		this.setList(beans);
		this.setIndex(0);
	}

	@Override
	public void doAdd() {
		long id = 1;
		if (this.getCount() > 0) {
			id = ((OpportunityBean) this.getBean(this.getCount()-1)).getId() + 1;
		}
		this.getAllBeans().add(new OpportunityBean(id));
		this.setIndex(this.getCount() - 1);  // New record becomes the current one
	}

	@Override
	public void doSave() {
		super.doSave();
		saveBeansToFile(OPPORTUNITIES_FILE);
	}

	public ArrayList<CRMBean> parseBeansFromFile(String filename) {
		File inputFile = new File(filename);
		try {
			ArrayList<CRMBean> opportunityBeans = new ArrayList<CRMBean>();
			Scanner inputScanner = new Scanner(inputFile);
			inputScanner.nextLine();  // Ignore header line
			inputScanner.useDelimiter("[\t\n]");
			while (inputScanner.hasNextLine()) {
				String ID = inputScanner.next();
				int id = Integer.parseInt(ID);
				OpportunityBean newBean = new OpportunityBean(id);
				String client = inputScanner.next();
				int clientId = Integer.parseInt(client);
				newBean.setClient(clientId);
				String saleDescription = inputScanner.next();
				newBean.setSaleDescription(saleDescription);
				String value = inputScanner.next();
				newBean.setValue(value);
				String date = inputScanner.next();
				newBean.setDate(date);
				String status = inputScanner.next();
				newBean.setStatus(status);
				inputScanner.nextLine();  // Skip over anything left in line
				opportunityBeans.add(newBean);
			}
			inputScanner.close();
			return opportunityBeans;
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Input file not Found");
		}
	}

	public String beanToFileLine(CRMBean bean) {

		String result = "";
		OpportunityBean ob = (OpportunityBean) bean;
		result += ob.getId();
		result += '\t';
		if (ob.getClient() < 0) {
			result += "-1";
		}
		else {
			result += ""+ob.getClient();
		}
		result += '\t';
		result += ob.getSaleDescription();
		result += '\t';
		result += ob.getValue();
		result += '\t';
		result += ob.getDate();
		result += '\t';
		result += ob.getStatus();
		return result;
	}

	public void saveBeansToFile(String filename) {
		ArrayList<CRMBean> opportunityBeans = getAllBeans();
		File outputFile = new File(filename);
		try {
			PrintWriter out = new PrintWriter(outputFile);
			// Print Header Line
			out.println("TinyCRM Opportunities data file");
			for (CRMBean bean : opportunityBeans) {
				out.println(beanToFileLine(bean));
			}
			out.close();
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Output file not Found");
		}
	}

}