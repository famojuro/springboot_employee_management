package com.innovativeapps.employee.data.provider;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

public interface DataProviderLocal {


    <T> int count(Class<T> type);

    <T> T create(T t);

    void delete(Object t);

    <T> T find(Object id, Class<T> type);

    <T> T find(Object id, Class<T> type, Map<String,Object> properties);

    <T> List<T> findAll(Class<T> type);

    <T> T update(T t);

    EntityManager getEntityManager();

    <T> List<T> findRange(Class<T> type, int maxResults, int firstResult);

    <T> List<T> findRangeQuery(Class<T> type, int maxResults, int firstResult);

    <T> List<T> findByNamedQuery(String namedQueryName,
                                 Map<String, Object> parameters, Class<T> type);

    <T> List<T> findByNamedQuery(String namedQueryName,
                                 Map<String, Object> parameters, int resultLimit, Class<T> type);


}
