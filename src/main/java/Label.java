

import lombok.Data;

@Data
public class Label {

	  private String id;
	  private String project_id;
	  private String kind;
	  private String name;
	  private String created_at;
	  private String updated_at;
	  
	  public boolean isCVPrioratized(){
		  return "cv priority".equalsIgnoreCase(name);
	  }
	  
	  public boolean isEnrollment(){
		  return "enrollment".equalsIgnoreCase(name);
	  }
	  
	  public boolean isAccountManagement(){
		  return "account management".equalsIgnoreCase(name);
	  }
	
}
