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
public class PageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public boolean saveOrUpdateObject(Object object) {
        getCurrentSession().save(object);
        return true;
    }

    public boolean removeObject(Page page) {
        getCurrentSession().remove(page);
        return true;
    }

    public List<Page> loadPages() {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Page> criteriaQuery = criteriaBuilder.createQuery(Page.class);
        Root<Page> root = criteriaQuery.from(Page.class);
        criteriaQuery.select(root);

        Query<Page> query = currentSession.createQuery(criteriaQuery);

        List<Page> pageList = query.getResultList();
        return pageList;
    }

    public Page loadPageByURL(String pageURL) {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Page> criteriaQuery = criteriaBuilder.createQuery(Page.class);
        Root<Page> root = criteriaQuery.from(Page.class);

        Predicate predicateURL = criteriaBuilder.equal(root.get("pageUrl"), pageURL);
        criteriaQuery.select(root).where(predicateURL);
        criteriaQuery.distinct(true);

        Query<Page> query = currentSession.createQuery(criteriaQuery);
        Page page;
        try {
            page = query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return page;
    }

    public Page loadPageById(int pageId) {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Page> criteriaQuery = criteriaBuilder.createQuery(Page.class);
        Root<Page> root = criteriaQuery.from(Page.class);

        Predicate predicateURL = criteriaBuilder.equal(root.get("id"), pageId);
        criteriaQuery.select(root).where(predicateURL);
        criteriaQuery.distinct(true);

        Query<Page> query = currentSession.createQuery(criteriaQuery);
        Page page;
        try {
            page = query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return page;
    }

}
