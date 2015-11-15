package kops.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {
	
	HashMap<Location, Set<Package>> setMap = new HashMap<Location, Set<Package>>(); //maps packages to a location
	HashMap<Package, Location> map = new HashMap<Package, Location>();				//maps a location to a package
	
	
	public UPSDatabase(){
		
	}
	
	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg ) {
		Set<Package> tempSet = new HashSet<Package>();
		if (setMap.containsKey(location)){		// if this is not a new location
			tempSet = setMap.get(location);
			tempSet.add(pkg);	
			setMap.put(location, tempSet);
			map.put(pkg, location);
		}
		else{									// if this is a new location
			Set<Package> set = new HashSet<Package>();	
			set.add(pkg);
			setMap.put(location, set);	
			map.put(pkg, location);
		}
	
	}
	
	
	
	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location ) {
		
		//get previous location of package
		Location oldLocation = getLocation(pkg);
		
		//remove package from previous locations
		map.remove(pkg);
		setMap.get(oldLocation).remove(pkg);
		
		//put package in new location
		addPackageToLocation(location, pkg);
	
	}
	
	
	
	/**
	 * @return a Set of Packages at the specified Location or an empty Set if 
	 * the Location doesn't exist or there are no Packages at that Location.
	 */
	public Set<Package> getPackages( Location location ) {
		Set<Package> set = new HashSet<Package>();
		
		if(!(setMap.containsKey(location) || setMap.get(location).isEmpty())){
			return set;
		}
		else{
			set = setMap.get(location);	 //all the packages at that location
			return set;
		}
		
	}
	
	
	
	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {

		if(map.containsKey(pkg)){
			return map.get(pkg);
		}
		
		else{
			return null;
		}
			
	}
	
	
}
