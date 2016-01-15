package kops.nypl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SearchThread extends Thread{

	private JList<Result> list;
	private Result[] results;
	private String searchString;
	
	
	public SearchThread(JList<Result> list, String string){
		this.list = list;
		this.searchString = string;
		
	}
	
	public void run(){
		
		//connect to Json and get array
		ReadSearchJson reader = new ReadSearchJson(searchString);
		this.results = reader.getResults();	
		
		for(int i = 0; i < results.length; i++){
			System.out.println(results[i].getTitle());
		}
		
		//add to JList;	
		list.setListData(results);
		
		//display images when select item from list
		list.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent le) {
		        int index = list.getSelectedIndex();
		        //call display thread for this list element
		        DisplayThread displayThread = new DisplayThread(index);
		        displayThread.start();
		        
		        
		      }
		    });
	}
	
	
}
