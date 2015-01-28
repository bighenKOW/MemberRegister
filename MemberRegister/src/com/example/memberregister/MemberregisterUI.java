package com.example.memberregister;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
@Theme("memberregister")
public class MemberregisterUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true, initParams = {
			@WebInitParam(name = "ui", value = "com.example.memberregister.MemberregisterUI"),
			@WebInitParam(name = "productionMode", value = "false") })
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		setContent(layout);
		
		Label headerLabel = new Label("Member Register");
		headerLabel.addStyleName(Reindeer.LABEL_H1);
		layout.addComponent(headerLabel);
		
		HorizontalLayout content = new HorizontalLayout();
		content.setSizeFull();
		layout.addComponent(content);
		
		Navigator navigator = new Navigator(this, content);
		navigator.addView("", new MemberListView());
		
		navigator.navigateTo("");
		
		
	}

}