package kops.weather;

public class Main {

	private String temp;
	
	public Main(CurrentWeather cw){
		this.temp = cw.getMain().getTemp();
	}
	
	public String getTemp(){
		return temp;
	}
}
