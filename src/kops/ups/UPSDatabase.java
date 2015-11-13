package kops.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {

	
	HashMap<Location, Set<Package>> map = new HashMap<Location, Set<Package>>();
	
	
	public UPSDatabase(){
		
	}
	
	
	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation( Location location, Package pkg ) {
		
		if (map.containsKey(location)){
			
			
		}
		else{
			Set<Package> set = new HashSet<Package>();
			set.add(pkg);
			map.put(location, set);	
		}
		
		
		
		
	}
	
	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation( Package pkg, Location location ) {
		map.remove(pkg);
		map.put(pkg, location);
		
	}
	
	/**
	 * @return a Set of Packages at the specified Location or an empty Set if 
	 * the Location doesn't exist or there are no Packages at that Location.
	 */
	public Set<Package> getPackages( Location location ) {
		Set<Package> set = new HashSet<Package>();
		
		if(!(map.values().contains(location))){
			return set; 	//should be empty
		}
		else{
			set = map.
		}
		
	}
	
	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		if (!map.containsKey(pkg)){
			return null;
		}
		else{
			return map.get(pkg);
		}	
	}
	
	
}
