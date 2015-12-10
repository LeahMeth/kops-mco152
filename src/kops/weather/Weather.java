package kops.weather;

public class Weather {

	private Weather[] weather;
	private String description;
	private String icon;
	
	public Weather(CurrentWeather cw){
		this.weather = cw.getWeather();
		this.description = this.weather[0].getDescription();
		this.icon = this.weather[0].getIcon();
	}
	
	public Weather[] getWeather(){
		return this.weather;
	}
	
	public String getDescription(){
		return this.description;
	}

	public String getIcon() {
		return this.icon;
	}

}
