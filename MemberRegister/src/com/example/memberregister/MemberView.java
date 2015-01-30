package com.example.memberregister;

import com.sun.org.apache.bcel.internal.generic.FieldGen;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class MemberView extends CustomComponent implements View {


	@PropertyId("forname")
	private TextField fornameTextField;
	@PropertyId("lastname")
	private TextField lastnameTextField;
	@PropertyId("city")
	private TextField cityTextField;
	@PropertyId("phone")
	private TextField phoneTextField;
	
	private final SQLContainer container;
	public MemberView(SQLContainer container) {
		this.container = container;
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);
		
		fornameTextField = new TextField("Forname");
		fornameTextField.setNullRepresentation("");
		layout.addComponent(fornameTextField);
		lastnameTextField = new TextField("Last name");
		lastnameTextField.setNullRepresentation("");
		layout.addComponent(lastnameTextField);
		cityTextField = new TextField("City");
		cityTextField.setNullRepresentation("");
		layout.addComponent(cityTextField);
		phoneTextField = new TextField("Phone");
		phoneTextField.setNullRepresentation("");
		layout.addComponent(phoneTextField);
		
		Button saveButton = new Button("Save");
		saveButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
			}
		});

		Button cancelButton = new Button("Cancel");
		cancelButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
			}
		});
		Button closeButton = new Button("Close");
		closeButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
			}
		});

		
		HorizontalLayout buttonsLayout = new HorizontalLayout();
		layout.addComponent(buttonsLayout);
		
		buttonsLayout.addComponent(saveButton);
		buttonsLayout.addComponent(cancelButton);
		buttonsLayout.addComponent(closeButton);
		
		
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Item item = null;
		if ("new".equals(event.getParameters())){
			Object itemId = container.addItem();
			item = container.getItem(itemId);
			
			FieldGroup fieldGroup = new FieldGroup(item);
			fieldGroup.bindMemberFields(this);
			
			
		}
			


	}

}
