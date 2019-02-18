package br.com.joaoaraujo.jsfprimefaces.test.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.joaoaraujo.jsfprimefaces.controller.IntersecaoMBean;

public class IntersecaoTest {

	@Test
	public void testTrue() {
		IntersecaoMBean intersecaoMBean = new IntersecaoMBean();
		intersecaoMBean.setValor1Int1(10);
		intersecaoMBean.setValor2Int1(15);
		intersecaoMBean.setValor1Int2(3);
		intersecaoMBean.setValor2Int2(40);
		
		assertTrue(intersecaoMBean.calculaIntersecao());
	}

	@Test
	public void testFalse() {
		IntersecaoMBean intersecaoMBean = new IntersecaoMBean();
		intersecaoMBean.setValor1Int1(10);
		intersecaoMBean.setValor2Int1(15);
		intersecaoMBean.setValor1Int2(16);
		intersecaoMBean.setValor2Int2(40);

		assertFalse(intersecaoMBean.calculaIntersecao());
	}

}
