package com.grup2.analyzer.service;

import com.grup2.analyzer.dao.PageLogDAO;
import com.grup2.analyzer.model.PageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("pageLogService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class PageLogService {

    @Autowired
    private PageLogDAO dao;

    public List<PageLog> loadPageLogId(int pageId, String sort) {
        return dao.loadPageLogId(pageId, sort);
    }

    public void saveOrUpdatePage(PageLog pageLog) {
        dao.saveOrUpdateObject(pageLog);
    }

}
