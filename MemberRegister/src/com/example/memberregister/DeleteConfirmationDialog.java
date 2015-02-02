package com.example.memberregister;

import java.sql.SQLException;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class DeleteConfirmationDialog extends Window {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeleteConfirmationDialog(final SQLContainer container, final Object itemId) {
		
		setCaption("Delete confirmation");
		setModal(true);
		setResizable(false);
		
		
		HorizontalLayout layout = new HorizontalLayout();
		
		Label label = new Label("Do you want to delete the person ?");
		
		layout.addComponent(label);
		layout.setSpacing(true);
		
		Button yesButton = new Button("Yes");
		yesButton.addClickListener(new Button.ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				try {
					container.removeItem(itemId);
					container.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				getUI().removeWindow(DeleteConfirmationDialog.this);
				
			}
		});
		
		Button noButton = new Button("No");
		noButton.addClickListener(new Button.ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().removeWindow(DeleteConfirmationDialog.this);
				
			}
		});
		
		layout.addComponent(yesButton);
		layout.addComponent(noButton);
		
		setContent(layout);
	}
}
