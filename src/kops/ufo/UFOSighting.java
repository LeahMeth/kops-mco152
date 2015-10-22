package kops.ufo;

public class UFOSighting {

	private String sightedAt;
	private String reportedAt;
	private String location;
	private String shape;
	private String duration;
	private String description;
	
	
	public UFOSighting(UFOSighting s){
		
		this.sightedAt = s.getSightedAt();
		this.reportedAt = s.getReportedAt();
		this.location = s.getLocation();
		this.shape = s.getShape();
		this.duration = s.getDuration();
		this.description = s.getDescription();
		
		
		
	}
	
	
	public String getSightedAt() {
		return sightedAt;
	}
	public String getReportedAt() {
		return reportedAt;
	}
	public String getLocation() {
		return location;
	}
	public String getShape() {
		return shape;
	}
	public String getDuration() {
		return duration;
	}
	public String getDescription() {
		return description;
	}
	
}
