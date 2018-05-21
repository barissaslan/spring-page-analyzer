package com.grup2.analyzer.service;

import com.grup2.analyzer.dao.PageDAO;
import com.grup2.analyzer.model.Page;
import com.grup2.analyzer.model.PageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("pageService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class PageService {

    @Autowired
    private PageDAO dao;

    public List<Page> loadPages() {
        return dao.loadPages();
    }

    public Page loadPageByURL(String pageURL) {
        return dao.loadPageByURL(pageURL);
    }

    public Page loadPageById(int id) {
        return dao.loadPageById(id);
    }

    public void saveOrUpdatePage(Page page) {
        dao.saveOrUpdateObject(page);
    }

}
