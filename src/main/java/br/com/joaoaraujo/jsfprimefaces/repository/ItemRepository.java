package br.com.joaoaraujo.jsfprimefaces.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.joaoaraujo.jsfprimefaces.entity.ItemEntity;

public class ItemRepository extends EntityCrudService<ItemEntity> {
	
	
	public List<ItemEntity> findByDescricao(String descricao){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<ItemEntity> query = criteriaBuilder.createQuery(ItemEntity.class);
		Root<ItemEntity> root = query.from(ItemEntity.class);
		Path<String> des = root.<String>get("descricao");
		Predicate descricaoLike = criteriaBuilder.like(des, "%".concat(descricao).concat("%"));
		
		query.where(descricaoLike);
	//	query.select(query.from(classType));
		List<ItemEntity> list = em.createQuery(query).getResultList();
		em.close();
		return list;
	}

}
