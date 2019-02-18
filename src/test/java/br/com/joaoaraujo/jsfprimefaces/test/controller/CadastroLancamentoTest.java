package br.com.joaoaraujo.jsfprimefaces.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.joaoaraujo.jsfprimefaces.controller.CadastrarLancamentoMBean;
import br.com.joaoaraujo.jsfprimefaces.entity.ItemEntity;
import br.com.joaoaraujo.jsfprimefaces.repository.ItemRepository;

public class CadastroLancamentoTest {

	
	@Test
	public void testAddLancamento() {
		List<ItemEntity> itens = addItem();
		
		CadastrarLancamentoMBean cadastra = new CadastrarLancamentoMBean();
		cadastra.init();
		cadastra.setItemEscolhido(itens.get(0));
		cadastra.addItemInLancamento();
		cadastra.setItemEscolhido(itens.get(1));
		cadastra.addItemInLancamento();
		cadastra.calculaValorTotal();
		
		assertEquals(new BigDecimal(2000), cadastra.getValorTotal());
		
		cadastra.removeItem(itens.get(0));
		cadastra.calculaValorTotal();
		
		assertEquals(new BigDecimal(1500), cadastra.getValorTotal());
		
		List<ItemEntity> itensReturned = cadastra.findItens("Teste");
		assertFalse(itensReturned.isEmpty());

		itensReturned = cadastra.findItens(String.valueOf(itens.get(0).getId()));
		assertFalse(itensReturned.isEmpty());
	}
	
	
	private List<ItemEntity> addItem() {
		ItemRepository itemRepository = new ItemRepository(true);
		List<ItemEntity> itens= new ArrayList<ItemEntity>();
		
		ItemEntity item = new ItemEntity();
		item.setValor(new BigDecimal(500));
		item.setDescricao("Teste unitário 1");
		itemRepository.insert(item);
		assertTrue(item.getId() > 0);
		itens.add(item);
		
		ItemEntity item2 = new ItemEntity();
		item2.setValor(new BigDecimal(1500));
		item2.setDescricao("Teste unitário 2");
		itemRepository.insert(item2);
		assertTrue(item2.getId() > 0);
		itens.add(item2);
		
		itemRepository.close();
		return itens;
	}
}
