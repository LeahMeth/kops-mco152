package kops.ups;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		Package p = new Package("1");
		Location l = new Location(20, 30);
		UPSDatabase ups = new UPSDatabase();
		ups.addPackageToLocation(l, p);
		
		Assert.assertTrue((ups.getPackages(l)).contains(p));
		
		Assert.assertEquals(l, ups.getLocation(p));
		
	}
	
	@Test 
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		//add a package
		Package p = new Package("1");
		Location old = new Location(30, 40);
		UPSDatabase ups = new UPSDatabase();
		ups.addPackageToLocation(old, p);
		
		//update package and check
		Location newLocation = new Location(50, 60);
		ups.updatePackageLocation(p, newLocation);
		
		Assert.assertTrue(ups.getPackages(newLocation).contains(p));
		
		Assert.assertEquals(newLocation, ups.getLocation(p));
		
		Assert.assertFalse(ups.getPackages(old).contains(p));
		
	}
	
	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase ups = new UPSDatabase();
		Location l = new Location(20, 20);
		Package p = new Package("1");
		ups.addPackageToLocation(l, p);
		
		Location l2 = new Location(30, 30);
		ups.updatePackageLocation(p, l2);
		
		Set<Package> temp = ups.getPackages(l);
		
		Assert.assertTrue(temp.isEmpty());
	}
	
	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		Package p = new Package("1");
		UPSDatabase ups = new UPSDatabase();
		
		Assert.assertNull(ups.getLocation(p));
	}
	
}
