package com.pdd.wiki.req;

public class EbookQueryReq extends PageReq{
    private Long id;

    private Long category2;

    private String bookName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getCategory2() {
        return category2;
    }

    public void setCategory2(Long category2) {
        this.category2 = category2;
    }
    //打印日志
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bookName=").append(bookName);
        sb.append("]");
        return sb.toString();
    }
}