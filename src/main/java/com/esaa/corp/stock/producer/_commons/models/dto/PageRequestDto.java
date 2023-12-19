package com.esaa.corp.stock.producer._commons.models.dto;

import java.util.Optional;

public class PageRequestDto {

    public final static int DEFAULT_PAGE = 1;
    public final static int DEFAULT_SIZE = 30;

    private Integer page;
    private Integer size;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public static class PageRequestDtoBuilder {


        private Integer page;
        private Integer size;

        public PageRequestDto build() {
            PageRequestDto page = new PageRequestDto();
            page.setPage(this.page);
            page.setSize(this.size);
            return page;
        }

        public PageRequestDtoBuilder setPage(Integer page) {
            this.page = page != null && page >= DEFAULT_PAGE? page:DEFAULT_PAGE;
            return this;
        }

        public PageRequestDtoBuilder setPage(Optional<String> page) {
            this.page = DEFAULT_PAGE;
            try {
                final String inputPage = page.orElse(Integer.toString(DEFAULT_PAGE));
                this.page = Integer.valueOf(inputPage);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return this;
        }

        public PageRequestDtoBuilder setSize(Integer size) {
            this.size = size != null && size >= DEFAULT_SIZE? size:DEFAULT_SIZE;
            return this;
        }

        public PageRequestDtoBuilder setSize(Optional<String> size) {
            this.size = DEFAULT_SIZE;
            try {
                final String input = size.orElse(Integer.toString(DEFAULT_SIZE));
                this.size = Integer.valueOf(input);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return this;
        }
    }
}
