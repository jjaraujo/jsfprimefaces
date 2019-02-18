package br.com.joaoaraujo.jsfprimefaces.test.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.joaoaraujo.jsfprimefaces.controller.VisualizarLancamentoMBean;

public class VisualizarLancamentoTest {

	@Test
	public void testValorItem() {
		VisualizarLancamentoMBean visualizarLancamentoMBean = new VisualizarLancamentoMBean();
		
		visualizarLancamentoMBean.setApenas10Itens(true);
		assertTrue(visualizarLancamentoMBean.getLancamentos().size() <= 10);
	}
	
}
