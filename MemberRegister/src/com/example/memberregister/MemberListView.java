package com.example.memberregister;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class MemberListView extends CustomComponent implements View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public MemberListView(SQLContainer container){
		setSizeFull();
		
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		setCompositionRoot(layout);
		
		Table table = new MembersTable(container);
		table.setSizeFull();
		
		layout.addComponent(table);
		layout.setExpandRatio(table, 1);
		
		
		// Have a component that fires click events
		final Button button = new Button("Add new");
		        
		// Handle the events with an anonymous class
		button.addClickListener(new Button.ClickListener() {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
		        getUI().getNavigator().navigateTo("member/new");
		    }
		});		
		
		layout.addComponent(button);
		
		}
		
	

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
