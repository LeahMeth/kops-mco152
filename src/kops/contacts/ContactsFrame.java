package kops.contacts;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ContactsFrame extends JFrame {

	private JList<String> list;
	private String[] contactNames;
	private JPanel panel;
	private DefaultListModel listModel;

	public ContactsFrame() {
		setTitle("ContactList");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		add(panel);

		listModel = new DefaultListModel();
		list = new JList<String>(listModel);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		panel.add(list);
		panel.add(new JScrollPane(list));

		// when button is clicked, get array of contacts using thread
		// getList.addActionListener(new ActionListener(){
		// @Override
		// public void actionPerformed(ActionEvent arg0){

		ContactsThread thread = new ContactsThread(list);
		thread.start();

		// }
		// });

	}
}
