package kops.contacts;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class ContactsFrame extends JFrame{

	private JButton getList;
	private JList<String> list;
	private String[] contactNames;
	
	public ContactsFrame(){
		setTitle("ContactList");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		
		getList = new JButton();
		getList.setText("Get List of Contacts");
		add(getList);
		
		
		list = new JList<String>(contactNames);
		list.setLayoutOrientation(JList.VERTICAL);
		
		add(list);
		
		//when button is clicked, get array of contacts using thread
		getList.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ContactsThread thread = new ContactsThread();
				thread.start();
				contactNames = new ContactNamesList().getNames();			

			}
		});
	
	

	}
}
