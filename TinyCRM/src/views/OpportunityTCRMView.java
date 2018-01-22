package views;

import java.util.ArrayList;

import beans.CRMBean;

public interface OpportunityTCRMView extends TCRMView {

	String getTextId();
	String getTextCompany();
	String getTextGain();
	String getTextLoss();
	String getTextWrittenNotice();
	String getTextVerbalNotice();
	
	void setTextId(String textId);
	void setTextCompany(String textCompany);
	void setTextGain(String textGain);
	void setTextLoss(String textLoss);
	void setTextWrittenNotice(String textWrittenNotice);
	void setTextVerbalNottice(String textVerbalNotice);
	
	String getErrorCompany();
	String getErrorGain();
	String getErrorLoss();
	String getErrorWrittenNotice();
	String getErrorVerbalNottice();

	void setErrorCompany(String errorCompany);
	void setErrorGain(String errorGain);
	void setErrorLoss(String errorLoss);
	void setErrorWrittenNotice(String errorWrittenNotice);
	void setErrorVerbalNotice(String errorVerbalNottice);
	String getTextDescription();
	String getTextDate();
	String getTextValue();
	void setSelectClientItems(ArrayList<CRMBean> allBeans);

}