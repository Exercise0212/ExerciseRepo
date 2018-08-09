package com.exercise.assignment.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.exercise.searchlogic.PluginSearchLogic;


/**
 * It creates the GUI for the plugin and calls the plugin for the computation to know whether the word is present or not.
 * 
 * @author anuj
 *
 */
public class SearchView {

	
	public SearchView(){

			  Display display = Display.getDefault();
		      Shell shell = new Shell(display);
		      shell.setBounds(400, 300, 400, 200);
		      shell.setText("Search Keyword Assignment");
		      GridLayout layout = new GridLayout(2,false);
		      layout.numColumns = 2;
		      shell.setLayout(layout);
		      shell.setMaximized(false);
			  shell.setMinimized(false);
			  Label label = new Label(shell, SWT.LEFT);
		      label.setText("Enter your word you want to search in passage.");
		      GridData gridData = new GridData();
		      gridData.horizontalSpan = 2;
		      label.setLayoutData(gridData); 
		      label = new Label(shell, SWT.LEFT);
		      label.setText(" Search Keyword :");
		      Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		      gridData = new GridData();
		      gridData.horizontalAlignment = GridData.FILL;
		      gridData.grabExcessHorizontalSpace = true;
		      text.setLayoutData(gridData);
		      label = new Label(shell, SWT.LEFT);
		      label.setText(" Passage :");
		      gridData = new GridData();
			  gridData.verticalAlignment = SWT.TOP;
			  label.setLayoutData(gridData);
		      final Text textarea = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.WRAP);
		      gridData = new GridData();
		      gridData.horizontalAlignment = GridData.FILL;
		      gridData.verticalAlignment = GridData.FILL;
		      gridData.grabExcessHorizontalSpace = true;
		      textarea.setLayoutData(gridData);
		      textarea.setText("");
		      Button searchButton = new Button(shell,SWT.PUSH);
		      searchButton.setText("Search keyword");
		      GridData btndata = new  GridData();
    	       btndata.horizontalSpan = 2;
		       btndata.horizontalAlignment = GridData.CENTER;
		       searchButton.setLayoutData(btndata);
		       searchButton.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						//calling the search functionality from another plugin.
						PluginSearchLogic.isWordPresesnt(textarea.getText(), text.getText());
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
					}
				});
		       shell.setVisible(true);
		      shell.open();
		      
		      shell.addListener(SWT.Close, new Listener() {
                  @Override
                  public void handleEvent(Event event) {
                      if (!shell.isDisposed()) {
                         
                          shell.dispose();
                        
                      }
                  }
              });
		      while (!shell.isDisposed()) {
		         if (!display.readAndDispatch()) {
		            display.sleep();
		         }
		      }
		      
		}
	
		/**
		 *  output the completion of plugin operation.
		 */
		public void outputMessage(){
			
		System.out.println("Plugin has been successfully ran.");
		}

}
