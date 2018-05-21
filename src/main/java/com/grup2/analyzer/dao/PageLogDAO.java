package com.grup2.analyzer.dao;

import com.grup2.analyzer.model.Page;
import com.grup2.analyzer.model.PageLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@Repository
public class PageLogDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public boolean saveOrUpdateObject(Object object) {
        getCurrentSession().save(object);
        return true;
    }

    public List<PageLog> loadPageLogId(int pageId, String sort) {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<PageLog> criteriaQuery = criteriaBuilder.createQuery(PageLog.class);
        Root<PageLog> root = criteriaQuery.from(PageLog.class);

        Predicate predicateId = criteriaBuilder.equal(root.get("page").get("id"), pageId);
        criteriaQuery.select(root).where(predicateId);
        criteriaQuery.distinct(true);

        if (sort.equals("newest")) {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
        }

        Query<PageLog> query = currentSession.createQuery(criteriaQuery);
        List<PageLog> logs = query.getResultList();
        return logs;
    }
}
