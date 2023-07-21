package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HelloAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		HelloForm helloForm = (HelloForm) form;
		helloForm.setMessage("Hello, " + name + "!");

		return mapping.findForward("success");
//		HelloForm helloForm = (HelloForm) form;
//		helloForm.setMessage("Hello, World!");
//
//		return mapping.findForward("success");
	}
}
