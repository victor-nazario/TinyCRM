package beans;

public class OpportunityBean extends CRMBean{

	private String company;
	private String telephone;
	private String email;
	private String website;
	private String facebook;
	private String client;
	private String SaleDescription;
	private String value;
	private String date;
	private String status;
	
	public OpportunityBean(long id) {
		super(id);
		company = "";
		telephone = "";
		email = "";
		facebook = "";
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getFacebook() {
		return facebook;
	}
	
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
	public String getDescription() {
		return company;
	}
	
	public String toString() {
		return this.getId() + ": " + this.getCompany();
	}
	
	public boolean equals(Object o) {
		if (o instanceof OpportunityBean) {
			OpportunityBean c = (OpportunityBean) o;
			return (c.getId() == this.getId());
		}
		return false;
	}

	public void setClient(long id) {
		// TODO Auto-generated method stub
		this.id=id;
	}

	public void setSaleDescription(String text) {
		// TODO Auto-generated method stub
		this.SaleDescription = text;
	}

	public void setValue(String text) {
		// TODO Auto-generated method stub
		this.value = text;
	}

	public void setDate(String text) {
		// TODO Auto-generated method stub
		this.date = text;
		
	}

	public void setStatus(String selectedItem) {
		// TODO Auto-generated method stub
		this.status = selectedItem;
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return value;
		
	}

	public String getDate() {
		// TODO Auto-generated method stub
		return date;
	}
	
}
