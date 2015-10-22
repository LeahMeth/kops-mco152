package kops.gui;

public class Projectile {
	
	private double time;
	private double velocity;
	private double radians;

	
	public Projectile(double time, double angle, double velocity){
		this.time = time;
		this.velocity = velocity;
		radians = Math.toRadians(angle);
	}
	
	
	public Double getX(){
		return Math.sin(radians) * this.velocity * this.time;
		 
	}
	
	public Double getY(){
		return  Math.cos(radians) * velocity * time 
				- (.5 * 9.8 * time*time);		

	}
}
