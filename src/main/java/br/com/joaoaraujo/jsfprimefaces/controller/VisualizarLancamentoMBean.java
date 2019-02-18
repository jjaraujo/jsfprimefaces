package br.com.joaoaraujo.jsfprimefaces.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.joaoaraujo.jsfprimefaces.entity.LancamentoEntity;
import br.com.joaoaraujo.jsfprimefaces.repository.LancamentoRepository;

@ManagedBean
@ViewScoped
public class VisualizarLancamentoMBean {

	private LancamentoRepository lancamentoRepository;
	private BigDecimal somaValor;
	private boolean apenas10Itens;
	
	@PostConstruct
	public void init() {
	}
	
	public List<LancamentoEntity> getLancamentos(){
		lancamentoRepository = new LancamentoRepository();

		if(apenas10Itens) {
			return lancamentoRepository.findByBigger10Item();
		} else {
			return lancamentoRepository.findAll();
		}
	}
	
	public BigDecimal getSomaValor() {
		somaValor = BigDecimal.ZERO;
		lancamentoRepository = new LancamentoRepository();
		List<LancamentoEntity> lancamentos = lancamentoRepository.findByMed100();
		lancamentos.forEach(lancamento -> somaValor = somaValor.add(lancamento.getValorTotal()));
		return somaValor;
	}
	
	public void setSomaValor(BigDecimal somaValor) {
		this.somaValor = somaValor;
	}
	
	public void excluirLancamento(LancamentoEntity entity) {
		lancamentoRepository = new LancamentoRepository();
		lancamentoRepository.delete(entity);
	}

	public boolean isApenas10Itens() {
		return apenas10Itens;
	}

	public void setApenas10Itens(boolean apenas10Itens) {
		this.apenas10Itens = apenas10Itens;
	}
	
}
