package br.com.joaoaraujo.jsfprimefaces.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.joaoaraujo.jsfprimefaces.entity.ItemEntity;

public class EntityCrudService<T>{

	EntityManager em;
	Class<T> classType;
	Logger LOGGER = Logger.getLogger(EntityCrudService.class.getName());
	
	 @PostConstruct
    public void init(){
        LOGGER.log(null,"EntityManager criado");
        System.out.println("Entity manager criado");
    }
	 
	
	@SuppressWarnings("unchecked")
	public EntityCrudService() {
		em = new JPAUtil().getEntityManager();
		classType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void insert(T entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public boolean update(T entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}finally {
			em.close();
		}
	}
	
	public void delete(T entity) {
		try {
			em.getTransaction().begin();
			entity = em.merge(entity);
			em.remove(entity);
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public List<T> findAll(){
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classType);
		query.select(query.from(classType));
		List<T> lista = em.createQuery(query).getResultList();
		em.close();
		return lista;
	}
	
	public T findById(int id) {
		try {
			
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<T> query = criteriaBuilder.createQuery(classType);
			Root<T> root = query.from(classType);
			Path<Integer> oid = root.<Integer>get("id");
			Predicate idEqual = criteriaBuilder.equal(oid,id);
			
			query.where(idEqual);
			return (T) em.createQuery(query).getSingleResult();
		}catch (Exception e) {
			return null;
		}finally {
			em.close();
		}
	}
}
