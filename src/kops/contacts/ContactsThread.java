package kops.contacts;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import java.util.Arrays;

public class ContactsThread extends Thread {

	private Contact[] contacts;
	private String[] names;
	private JList<String> contactList;

	public ContactsThread(JList<String> list) {
		this.contactList = list;

	}

	public void run() {
		JsonReader reader = new JsonReader();
		this.contacts = reader.getContacts();

		this.names = new String[10];
		for (int i = 0; i < 10; i++) {
			this.names[i] = contacts[i].getName();
		}

		// sort array of names
		Arrays.sort(names);

		contactList.setListData(names);

	}

}
