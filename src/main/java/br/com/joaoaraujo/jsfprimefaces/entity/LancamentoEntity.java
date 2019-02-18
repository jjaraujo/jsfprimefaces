package br.com.joaoaraujo.jsfprimefaces.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="lancamento")
public class LancamentoEntity {

	@Id
	@GeneratedValue
	@Column(name="oid")
	private int id;
	@Column(name="dt_inicial")
	private Date dataInicial;
	@Column(name="dt_final")
	private Date dataFinal;
	@Column(name="vl_total")
	private BigDecimal valorTotal;
	private String observacao;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "lancamentoItem", joinColumns = {
	        @JoinColumn(name = "oid_lancamento")}, inverseJoinColumns = {
	        @JoinColumn(name = "oid_item")})
    private List<ItemEntity> itens;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dattFinal) {
		this.dataFinal = dattFinal;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public List<ItemEntity> getItens() {
		return itens;
	}
	public void setItens(List<ItemEntity> itens) {
		this.itens = itens;
	}
	
	
}
