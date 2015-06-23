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
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author ricardo
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
        T entityToBeRemoved = em.merge(entity);

        em.remove(entityToBeRemoved);
    }

    public T update(T entity) {
        return em.merge(entity);
    }

    public T find(int entityID) {
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
}
