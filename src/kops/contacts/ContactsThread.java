package kops.contacts;

import java.util.Arrays;

public class ContactsThread extends Thread {

	private Contact[] contacts;
	private String[] names;
	private String name;
	//other fields to return
	
	public ContactsThread(){
		
	}
	
	public void run(){
		JsonReader reader = new JsonReader();		
		this.contacts = reader.getContacts();
		
		this.names = new String[10];
		for(int i = 0; i < 10; i++){
			this.names[i] = contacts[i].getName();
		}
		
		//sort array of names
		Arrays.sort(names);
			
		for(int i =0; i<10; i++){
			System.out.println(names[i]);
		}
		
		ContactNamesList list = new ContactNamesList();
		list.setNames(this.names);
	}

	
	
	
	
	
	
	
}
