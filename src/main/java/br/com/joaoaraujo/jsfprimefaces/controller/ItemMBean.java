package br.com.joaoaraujo.jsfprimefaces.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.joaoaraujo.jsfprimefaces.entity.ItemEntity;
import br.com.joaoaraujo.jsfprimefaces.repository.ItemRepository;

@ViewScoped
@ManagedBean
public class ItemMBean {
	
	private ItemRepository itemRepository;
	private ItemEntity item;
	private List<ItemEntity> itens;
	
	@PostConstruct
    public void init(){
		item = new ItemEntity();
    }
	
	public boolean isRenderTableItens() {
		return itens != null && !itens.isEmpty();
	}
	
	public void salvarItem() {
		itemRepository = new ItemRepository();
		if(item.getId() == 0) {
			itemRepository.insert(item);
		} else {
			itemRepository.update(item);
		}
		item = new ItemEntity(); // limpa o form
	}
	
	public void limparItem() {
		item = new ItemEntity();
	}
	
	public void excluirItem(ItemEntity item) {
		itemRepository = new ItemRepository();
		itemRepository.delete(item);
	}
	public void test() {
		int i = 0;
		System.out.println(i);
	}

	public ItemEntity getItem() {
		return item;
	}

	public void carregaItem(ItemEntity item) {
		this.item = item;
	}

	public List<ItemEntity> getItens() {
		itemRepository = new ItemRepository();
		return itemRepository.findAll();
	}

	public void setItens(List<ItemEntity> itens) {
		this.itens = itens;
	}
	
}
