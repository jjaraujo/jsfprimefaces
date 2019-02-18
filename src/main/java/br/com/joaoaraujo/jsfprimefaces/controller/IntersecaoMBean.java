package br.com.joaoaraujo.jsfprimefaces.controller;

import java.util.Set;
import java.util.TreeSet;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.joaoaraujo.jsfprimefaces.util.Messages;

@ManagedBean
@ViewScoped
public class IntersecaoMBean {

	private Integer valor1Int1;
	private Integer valor2Int1;
	private Integer valor1Int2;
	private Integer valor2Int2;
	
	public void calculaIntersecao() {
		Set<Integer> conjunto1 = new TreeSet<Integer>();
		Set<Integer> conjunto2 = new TreeSet<Integer>();
		for(int i = valor1Int1; i <= valor2Int1; i++) {
			conjunto1.add(i);
		}
		for(int i = valor1Int2; i <= valor2Int2; i++) {
			conjunto2.add(i);
		}
		Set<Integer> intersecao = new TreeSet<Integer>(conjunto1);
		intersecao.retainAll(conjunto2);
		if(!intersecao.isEmpty()) {
			Messages.addMessage(FacesMessage.SEVERITY_INFO, "Possui interseção!");
		} else {
			Messages.addMessage(FacesMessage.SEVERITY_WARN,"Atenção", "Não possui interseção!");
		}
	}
	
	public Integer getValor1Int1() {
		return valor1Int1;
	}
	public void setValor1Int1(Integer valor1Int1) {
		this.valor1Int1 = valor1Int1;
	}
	public Integer getValor2Int1() {
		return valor2Int1;
	}
	public void setValor2Int1(Integer valor2Int1) {
		this.valor2Int1 = valor2Int1;
	}
	public Integer getValor1Int2() {
		return valor1Int2;
	}
	public void setValor1Int2(Integer valor1Int2) {
		this.valor1Int2 = valor1Int2;
	}
	public Integer getValor2Int2() {
		return valor2Int2;
	}
	public void setValor2Int2(Integer valor2Int2) {
		this.valor2Int2 = valor2Int2;
	}
	
	
	
}
