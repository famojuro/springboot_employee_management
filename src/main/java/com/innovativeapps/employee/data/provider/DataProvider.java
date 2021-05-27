package com.innovativeapps.employee.data.provider;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataProvider implements DataProviderLocal{

    @PersistenceContext
    EntityManager em;

    @Override
    public <T> int count(Class<T> type) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(type);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    @Override
    public <T> T create(T t) {
      em.persist(t);
      em.flush();
      return t;
    }

    @Override
    public void delete(Object t) {
        em.remove(em.merge(t));
        em.flush();
    }

    @Override
    public <T> T find(Object id, Class<T> type) { return (T) em.find(type, id); }

    @Override
    public <T> T find(Object id, Class<T> type, Map<String, Object> properties) {
        return (T) em.find(type, id, properties);
    }

    @Override
    public <T> List<T> findAll(Class<T> type) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(type));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public <T> T update(T t) { return (T) em.merge(t); }

    @Override
    public EntityManager getEntityManager() { return em; }

    @Override
    public <T> List<T> findRange(Class<T> type, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(type));
        Query q = em.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }

    @Override
    public <T> List<T> findRangeQuery(Class<T> type, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(type));
        Query q = em.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }

    @Override
    public <T> List<T> findByNamedQuery(String namedQueryName, Map<String, Object> parameters, Class<T> type) {
        return findByNamedQuery(namedQueryName, parameters, 0, type);
    }

    @Override
    public <T> List<T> findByNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit, Class<T> type) {
        Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
        Query query = this.em.createNamedQuery(namedQueryName);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        for (Map.Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }
}
