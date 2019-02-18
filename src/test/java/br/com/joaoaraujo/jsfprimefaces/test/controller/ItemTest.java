package br.com.joaoaraujo.jsfprimefaces.test.controller;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.joaoaraujo.jsfprimefaces.entity.ItemEntity;
import br.com.joaoaraujo.jsfprimefaces.repository.ItemRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItemTest {

	ItemEntity item = new ItemEntity();

	@Test
	public void testCrud() {
		ItemRepository itemRepository = new ItemRepository(true);
		item.setValor(new BigDecimal(500));
		item.setDescricao("Teste unitário");
		itemRepository.insert(item);
		assertTrue(item.getId() > 0);

		assertTrue(itemRepository.findById(item.getId())!= null);

		item.setValor(new BigDecimal(250));
		item.setDescricao("Item Update");
		assertTrue(itemRepository.update(item));

		assertTrue(itemRepository.delete(item));
		
		itemRepository.close();
	}
}
