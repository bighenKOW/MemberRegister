package com.example.memberregister;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.ui.Table;

public class MembersTable extends Table {
	
	private static final Action EDIT_ACTION = new Action("Edit");
	private static final Action DELETE_ACTION = new Action("Delete");
	
	
	
	public MembersTable(SQLContainer container){
		setContainerDataSource(container);
		setVisibleColumns(new String[] {"forname", "lastname","city", "phone"});
	
		addActionHandler(new Handler() {
			
			@Override
			public void handleAction(Action action, Object sender, Object target) {
				if (action == EDIT_ACTION) {
					getUI().getNavigator().navigateTo("member/" + target);
				} else if (action == DELETE_ACTION) {
					
				}
						
			}
			
			@Override
			public Action[] getActions(Object target, Object sender) {
				return new Action[]{EDIT_ACTION, DELETE_ACTION};
			}
		});
	
	}
		
	
}
