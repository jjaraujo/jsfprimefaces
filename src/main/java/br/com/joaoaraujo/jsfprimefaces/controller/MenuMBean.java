package br.com.joaoaraujo.jsfprimefaces.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class MenuMBean {

	public String itemUrl() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("item.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "item?faces-redirect=true";
	}
	
	public String cadastrarLancamentoUrl() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastrarLancamento.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "cadastrarLancamento?faces-redirect=true";
	}
	
	public String visualizarLancamentoUrl() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("visualizarLancamento.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "visualizarLancamento?faces-redirect=true";
	}
	
	public String intersecaoUrl() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("intersecao.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "intersecao?faces-redirect=true";
	}
}
