package com.esaa.corp.stock.producer._commons.models.dto;

import java.util.Collections;
import java.util.List;

public class PageResponseWrapperDto<T> {

    private List<T> items;
    private PageResponseModel page;

    public PageResponseWrapperDto(List<T> items, PageResponseModel page) {

        this.items = items != null ? items : Collections.EMPTY_LIST;
        //adjust pagination object
        if(page != null && page.getCurrentPage() > 0) {
            this.page = page;
            int listSize = items.size();
            if(page.getSkip() < listSize) {
                int auxSize = page.getSkip() + page.getSize();
                if (auxSize <= listSize) {
                    listSize = page.getSize();
                }
                this.items = items.subList(page.getSkip(), listSize);
            }
        }
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public PageResponseModel getPage() {
        return page;
    }

    public void setPage(PageResponseModel page) {
        this.page = page;
    }
}
