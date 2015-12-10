package kops.weather;

public class CurrentWeather {

	private String temp;
	private Main main;
	//has an array of weather
	private Weather[] weather;
	private String description;
	private String icon;
	
	public CurrentWeather(CurrentWeather cw){
		this.main = cw.getMain();
		this.temp = this.main.getTemp();
		this.weather = cw.getWeather(); 
		this.description = this.weather[0].getDescription();
		this.icon = this.weather[0].getIcon();
	}

	public Weather[] getWeather() {
		return this.weather;
	}

	public Main getMain() {
		return this.main;
	}

	public String getTemp(){
		return this.temp;
	}
	
	public String getDescription(){
		return this.description;
	}

	public String getIcon(){
		return this.icon;
	}
	
	
}
