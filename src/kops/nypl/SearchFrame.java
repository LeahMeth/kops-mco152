package kops.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import kops.chat.ChatFrame;

public class SearchFrame extends JFrame{
	
	private JPanel searchPanel;
	private JTextField typeSearch;
	private JButton search;
	
	private JPanel listPanel;
	private JList list;
	
	private JPanel centerPanel;	
	private JPanel pagePanel;
	private JButton getPrevious;
	private JLabel pageNow;
	private JLabel totalPages;
	private JButton getNext;
	private JPanel imagePanel;
	private JScrollPane scroll;
	private int thisPage;
	private int allPages;
	private String searchString;
	
	public SearchFrame(){
		setTitle("NYPL Search");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		searchPanel = new JPanel();
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
		
		add(searchPanel, BorderLayout.NORTH);
		searchPanel.setLayout(new FlowLayout());
		typeSearch = new JTextField(44);
		searchPanel.add(typeSearch);
		search = new JButton("Search");
		searchPanel.add(search);	
		//get search results from textfield
		searchString = typeSearch.getText();
		
		listPanel = new JPanel();
		add(listPanel, BorderLayout.WEST);
		
		list = new JList<Result>();
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		listPanel.add(list);
		listPanel.add(new JScrollPane(list));
				
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		add(centerPanel, BorderLayout.CENTER);
		pagePanel = new JPanel();
		pagePanel.setLayout(new BoxLayout(pagePanel, BoxLayout.X_AXIS));
		centerPanel.add(pagePanel);
		getPrevious = new JButton("Previous");
		pagePanel.add(getPrevious);
		thisPage = 0;
		pageNow = new JLabel(thisPage +"/");
		pagePanel.add(pageNow);
		allPages = 0;
		totalPages = new JLabel(allPages+"");
		pagePanel.add(totalPages);
		getNext = new JButton("Next");
		pagePanel.add(getNext);
		imagePanel = new JPanel();
		centerPanel.add(imagePanel);
		
		scroll = new JScrollPane(imagePanel);
		
		centerPanel.add(scroll);
		
		search.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//get search results from textfield
				searchString = typeSearch.getText();
				//start thread
				SearchThread thread = new SearchThread(list, searchString);
				thread.start();
			}
		});
		

		
		
	}
	
	
	public static void main(String[] args){
		new SearchFrame().setVisible(true);
	}
	
	

}
