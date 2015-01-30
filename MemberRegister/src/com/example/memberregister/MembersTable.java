package com.example.memberregister;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.ui.Table;

public class MembersTable extends Table {
	
	public MembersTable(SQLContainer container){
		setContainerDataSource(container);
		setVisibleColumns(new String[] {"forname", "lastname","city", "phone"});
	}
	

}
