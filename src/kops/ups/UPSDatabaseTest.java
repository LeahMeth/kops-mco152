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
		
		Location l2 = ups.getLocation(p);
		Assert.assertEquals(l, l2);
		
		Set<Package> packages = ups.getPackages(l);
		Assert.assertEquals(p, packages.toArray()[0]);
	}
	
	@Test 
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		
	}
	
	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		Assert.fail("test not implemented");
	}
	
	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		Assert.fail("test not implemented");
	}
	
}
