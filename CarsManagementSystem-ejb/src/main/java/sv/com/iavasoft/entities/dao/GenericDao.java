/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author ricardo
 * @param <T>
 */
public abstract class GenericDao<T> {

    @PersistenceContext(unitName = "CarsManagementSystemPU")
    private EntityManager em;

    private Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        em.persist(entity);
    }

    public void delete(T entity) {

        em.remove(entity);
    }
    
    public T getWithId(Long entityId) {
        return em.getReference(entityClass, entityId);
    }

    public T update(T entity) {
        return em.merge(entity);
    }

    public T find(Long entityID) {
        return em.find(entityClass, entityID);
    }

    @SuppressWarnings({"uncheked", "rawtypes"})
    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    @SuppressWarnings("unchecked")
    protected List<T> findManyResults(String namedQry, Map<String, Object> parameters) {
        List<T> resultList = null;
        try {
            Query q = em.createNamedQuery(namedQry);
            
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(q, parameters);
            }
            
            resultList = (List<T>) q.getResultList();
            
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, e.getMessage());
        }
        return resultList;
    }

    
    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
    
    public List<T> executeQryList(CriteriaQuery cq) {
        return em.createQuery(cq).getResultList();
    }
    
    public CriteriaBuilder getCriteriaBuilder() {
        return em.getCriteriaBuilder();
    }
}
