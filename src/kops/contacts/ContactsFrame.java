package kops.contacts;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class ContactsFrame extends JFrame{

	private JButton getList;
	private JList<String> list;
	private String[] contactNames;
	private JPanel panel;
	
	public ContactsFrame(){
		setTitle("ContactList");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS ));	
		
		
		getList = new JButton();
		getList.setText("Get List of Contacts");
		add(getList);
		
		add(panel);
		
		list = new JList<String>(contactNames);
		list.setLayoutOrientation(JList.VERTICAL);
		
		panel.add(list);
		
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
