package kops.weather;

public class CurrentWeather {

	private String name;
	private Main main;
	//has an array of weather
	private Weather[] weather;

	

	public Weather getWeather() {
		return this.weather[0];
	}

	public Main getMain() {
		return this.main;
	}
	public String getName(){
		return this.name;
	}


	
	
}
