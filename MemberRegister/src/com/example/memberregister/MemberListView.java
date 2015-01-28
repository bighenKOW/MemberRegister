package com.example.memberregister;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("deprecation")
public class MemberListView extends CustomComponent implements View {
	
	public MemberListView(){
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		setCompositionRoot(layout);
		
		Table table = new Table();
		table.setSizeFull();
		
		layout.addComponent(table);
		
		layout.addComponent(new Button("Add new", new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
			}
		}));
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
