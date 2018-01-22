
package beans;

public class OpportunityBean extends CRMBean {

	
	private String description;
	private String value;
	private String closingdate;
	private long client;
	private String status;
	
	
	
	public OpportunityBean(long id) {
		super(id);
		description = "";
		value = "";
		closingdate = "";
		client = -1;
		status = "";
		// TODO Auto-generated constructor stub
	}
	
	
	
	public long getClient() {
		return client;
	}
	
	public void setClient(long id) {
		this.client = id;
	}
	
	public String getSaleDescription() {
		return description;
	}
	
	public void setSaleDescription(String description) {
		this.description = description;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
	this.value = value;
    }
	
	public String getDate() {
		return closingdate;
	}
	
	public void setDate(String closingdate) {
		this.closingdate = closingdate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}
	
	public boolean equals(Object o) {
		if (o instanceof OpportunityBean) {
			OpportunityBean c = (OpportunityBean) o;
			return (c.getId() == this.getId());
		}
		return false;
	}

	@Override
	public String toString() {
		return this.getId() + ": " + this.getSaleDescription();
	}
}