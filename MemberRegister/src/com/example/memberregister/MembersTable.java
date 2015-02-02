package com.example.memberregister;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;

public class MembersTable extends Table {
	
	private static final Action EDIT_ACTION = new Action("Edit");
	private static final Action DELETE_ACTION = new Action("Delete");
	private static final Action WTF_ACTION = new Action("Wtf?");
	
	
	public MembersTable(SQLContainer container){
		setContainerDataSource(container);
		setVisibleColumns(new String[] {"forname", "lastname","city", "phone", "email"});
	
		addActionHandler(new Handler() {
			
			@Override
			public void handleAction(Action action, Object sender, Object target) {
				if (action == EDIT_ACTION) {
					getUI().getNavigator().navigateTo("member/" + target);
				} else if (action == DELETE_ACTION) {
					getUI().addWindow( new DeleteConfirmationDialog(container,target));
			
				}
						
			}
			
			@Override
			public Action[] getActions(Object target, Object sender) {
				return new Action[]{EDIT_ACTION, DELETE_ACTION, WTF_ACTION};
			}
		});
		
		addGeneratedColumn("email", new ColumnGenerator() {
			
			@Override
			public Object generateCell(Table source, Object itemId, Object columnId) {
				String email = (String)container.getContainerProperty(itemId, columnId).getValue();
				
				if (email == null || email.equals("")){
					return null;
				}
				return new Link(email, new ExternalResource("mailto:"+email)); 
					
			}
		});
	
	}
		
	
}
