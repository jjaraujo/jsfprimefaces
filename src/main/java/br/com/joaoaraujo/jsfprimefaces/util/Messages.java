package br.com.joaoaraujo.jsfprimefaces.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Messages {

	private static void addMessage(Severity severity, String title, String msg) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(severity, title, msg));
		} catch (NullPointerException e) {
			
		}
	}
	
	public static void addMessageDetalhes(String msg) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("",msg));
		} catch (NullPointerException e) {
		}
	}

	public static void addMessage(String msg) {
		addMessage(FacesMessage.SEVERITY_INFO, "Sucesso", msg);
	}

	public static void addMessage(String title, String msg) {
		addMessage(FacesMessage.SEVERITY_INFO, title, msg);
	}

	public static void addErro(String title, String msg) {
		addMessage(FacesMessage.SEVERITY_ERROR, title, msg);
	}

	public static void addWarn(String title, String msg)  {
		addMessage(FacesMessage.SEVERITY_WARN, title, msg);
	}
}