package com.grup2.analyzer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Page")
public class Page implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_id", nullable = false)
    private int id;

    @Column(name = "page_url")
    private String pageUrl;

    @OneToMany(targetEntity = PageLog.class, mappedBy = "page",
            cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<PageLog> pageLogs;

    public Page() {
    }

    public Page(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public List<PageLog> getPageLogs() {
        return pageLogs;
    }

    public void setPageLogs(List<PageLog> pageLogs) {
        this.pageLogs = pageLogs;
    }
}
