package br.com.joaoaraujo.jsfprimefaces.repository;

import java.util.List;

import javax.persistence.Query;

import br.com.joaoaraujo.jsfprimefaces.entity.LancamentoEntity;

public class LancamentoRepository extends EntityCrudRepository<LancamentoEntity>{
		
		
		public  List<LancamentoEntity> findByMed100(){
			StringBuilder query = new StringBuilder();
			query.append("select * from lancamento where oid in( select id from (")
				.append("select avg(i.valor) as valorMed, lan.oid as id from lancamento lan ")
				.append("join lancamentoItem li on lan.oid = li.oid_lancamento ") 
				.append("join item i on i.oid = li.oid_item ")
				.append("group by lan.oid) media where valorMed >= 100 )");
			
			Query queryNative = em.createNativeQuery(query.toString(),LancamentoEntity.class);
			return queryNative.getResultList();
			
		}
		
		public List<LancamentoEntity> findByBigger10Item(){
			StringBuilder query = new StringBuilder();
			query.append("select * from lancamento where oid in( ")
			.append("	select id from( ")
			.append("		select count(li.oid_item) as contItens, sum(i.valor) as soma,") 
			.append("			oid_lancamento as id from lancamento lan ")
			.append("		join lancamentoItem li on lan.oid = li.oid_lancamento ")
			.append("		join item i on i.oid = li.oid_item ")
			.append("		where LOWER(lan.observacao) like 'a%' ") 
			.append("		group by oid_lancamento order by contItens desc limit 10 ) ") 
			.append("	soma where soma >=50)");
			
			Query queryNative = em.createNativeQuery(query.toString(),LancamentoEntity.class);
			return queryNative.getResultList();
		}
}
