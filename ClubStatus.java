package HW5_MVC_GUI;

public enum ClubStatus {
	ACTIVE("AC", "Active Club"), INACTIVE("IP", "Inactive Club");
	
	private String statusCode;
	private String outputString;
	
	private ClubStatus(String statusCode, String outputString) {
		this.statusCode = statusCode;
		this.outputString = outputString;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	
	@Override
	public String toString() {
		return outputString;
	}
}
