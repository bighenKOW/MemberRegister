package com.example.memberregister;

import java.sql.SQLException;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
@Theme("memberregistertheme")
public class MemberregisterUI extends UI {
	
	private SQLContainer createContainer(){
		try{
			final JDBCConnectionPool pool = new SimpleJDBCConnectionPool(
					"com.mysql.jdbc.Driver",
					"jdbc:mysql://localhost:3306/person", "root", "");
			TableQuery tb = new TableQuery("person", pool);
			SQLContainer container = new SQLContainer(tb);
//			addCleanupListener (new CleanupListener(){
//				public void Cleanup(CleanupEvent event){
//					pool.destroy();
//				}
//			});
			return container;
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}

	@WebServlet(value = "/*", asyncSupported = true, initParams = {
			@WebInitParam(name = "ui", value = "com.example.memberregister.MemberregisterUI"),
			@WebInitParam(name = "productionMode", value = "false") })
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSizeFull();
		setContent(layout);
		
		Label headerLabel = new Label("Member Register");
		headerLabel.addStyleName(Reindeer.LABEL_H1);
		layout.addComponent(headerLabel);
		
		HorizontalLayout content = new HorizontalLayout();
		content.setSizeFull();
		layout.addComponent(content);
		layout.setExpandRatio(content, 1);
		
		SQLContainer container = createContainer();
				
		
		Navigator navigator = new Navigator(this, content);
		navigator.addView("", new MemberListView(container));
		navigator.addView("member", new MemberView(container));
		
		navigator.navigateTo("");
		
		
	}

}