package br.com.joaoaraujo.jsfprimefaces.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.joaoaraujo.jsfprimefaces.entity.ItemEntity;
import br.com.joaoaraujo.jsfprimefaces.entity.LancamentoEntity;
import br.com.joaoaraujo.jsfprimefaces.repository.ItemRepository;
import br.com.joaoaraujo.jsfprimefaces.repository.LancamentoRepository;
import br.com.joaoaraujo.jsfprimefaces.util.Messages;
import br.com.joaoaraujo.jsfprimefaces.util.Util;

@ManagedBean
@ViewScoped
public class CadastrarLancamentoMBean {
	private ItemEntity itemEscolhido;
	private LancamentoEntity lancamentoEntity;
	
	private ItemRepository itemRepository;
	private LancamentoRepository lancamentoRepository;
	private BigDecimal total;
	

	@PostConstruct
    public void init(){
		lancamentoEntity = new LancamentoEntity();
		lancamentoEntity.setItens(new ArrayList<>());
    }
	
	public void salvar()   {
			if(!isValid()) {
				return;
			}
		
		lancamentoRepository = new LancamentoRepository();
		lancamentoEntity.setValorTotal(total);
		lancamentoRepository.insert(lancamentoEntity);
		lancamentoEntity = new LancamentoEntity();
		lancamentoEntity.setItens(new ArrayList<>());
		itemEscolhido = null;
		Messages.addMessage("Lançamento salvo com sucesso!");
	}
	
	public List<ItemEntity> findItens(String query){
		itemRepository = new ItemRepository();
		List<ItemEntity> itens;
		if(Util.isInt(query)) {
			ItemEntity item = itemRepository.findById(Integer.parseInt(query));
			itens = new ArrayList<>();
			if(item != null) { 
				itens.add(item);
			}
			return itens;
		} else {
			return itemRepository.findByDescricao(query);
		}
	}
	
	public void removeItem(ItemEntity item) {
		lancamentoEntity.getItens().remove(item);
		itemEscolhido = new ItemEntity();
	}
	
	public void addItemInLancamento() {
		this.lancamentoEntity.getItens().add(itemEscolhido);
		calculaValorTotal();
	}
	
	public BigDecimal getValorTotal() {		
		calculaValorTotal();
		return total == BigDecimal.ZERO ? null : total;
	}
	
	public void calculaValorTotal() {
		total = BigDecimal.ZERO;
		lancamentoEntity.getItens().forEach(item -> total = total.add(item.getValor()));
	}
	

	public ItemEntity getItemEscolhido() {
		return itemEscolhido;
	}

	public void setItemEscolhido(ItemEntity itemEscolhido) {
		this.itemEscolhido = itemEscolhido;
	}
    
	public LancamentoEntity getLancamento() {
		return lancamentoEntity;
	}

	public void setLancamentos(LancamentoEntity lancamento) {
		this.lancamentoEntity = lancamento;
	}
	
	private boolean isValid()   {
		if(lancamentoEntity.getItens().isEmpty()) {
			Messages.addWarn("Item Obrigatório", "Por favor, insira um item");
			return false;
		}
		return true;
	}
 
}
