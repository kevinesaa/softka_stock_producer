package com.esaa.corp.stock.producer._commons.models.dto;

public class PageResponseModel {

    private int currentPage;
    private int size;
    private int maxPages;
    private int totalItems;
    private int skip;

    public PageResponseModel(int totalItems, int currentPage, int pageSize) {

        final int limit = pageSize >= 1? pageSize:PageRequestDto.DEFAULT_SIZE;
        final int skips = Math.abs( limit * (currentPage - 1 ) );
        setMaxPages(totalItems/limit);
        setCurrentPage(currentPage);
        setTotalItems(totalItems);
        setSize(limit);
        setSkip(skips);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxPages() {
        return maxPages;
    }

    public void setMaxPages(int maxPages) {
        this.maxPages = maxPages;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }


}
