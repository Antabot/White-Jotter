package com.gm.wj.util;

import org.springframework.data.domain.Page;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Evan
 * @Date 2020/6/10
 */
public class MyPage<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = -3720998571176536865L;
    private List<T> content = new ArrayList<>();
    private long totalElements;
    private int pageNumber;
    private int pageSize;
    private boolean first;
    private boolean last;
    private boolean empty;
    private int totalPages;
    private int numberOfElements;

    public MyPage() {
    }

    //只用把原来的page类放进来即可
    public MyPage(Page<T> page) {
        this.content = page.getContent();
        this.totalElements = page.getTotalElements();
        this.pageNumber = page.getPageable().getPageNumber();
        this.pageSize = page.getPageable().getPageSize();
        this.numberOfElements = page.getNumberOfElements();
    }

    //是否有前一页
    public boolean hasPrevious() {
        return getPageNumber() > 0;
    }

    //是否有下一页
    public boolean hasNext() {
        return getPageNumber() + 1 < getTotalPages();
    }

    //是否第一页
    public boolean isFirst() {
        return !hasPrevious();
    }

    //是否最后一页
    public boolean isLast() {
        return !hasNext();
    }

    //获取内容
    public List<T> getContent() {
        return Collections.unmodifiableList(content);
    }

    //设置内容
    public void setContent(List<T> content) {
        this.content = content;
    }

    //是否有内容
    public boolean hasContent() {
        return getNumberOfElements() > 0;
    }

    //获取单页大小
    public int getPageSize() {
        return pageSize;
    }

    //设置单页大小
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //获取全部元素数目
    public long getTotalElements() {
        return totalElements;
    }

    //设置全部元素数目
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    //设置是否第一页
    public void setFirst(boolean first) {
        this.first = first;
    }

    // 设置是否最后一页
    public void setLast(boolean last) {
        this.last = last;
    }

    //获取当前页号
    public int getPageNumber() {
        return pageNumber;
    }

    //设置当前页号
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    //获取总页数
    public int getTotalPages() {
        return getPageSize() == 0 ? 1 : (int) Math.ceil((double) totalElements / (double) getPageSize());
    }

    //设置总页数
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    //获取单页元素数目
    public int getNumberOfElements() {
        return numberOfElements;
    }

    //设置单页元素数目
    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    //判断是否为空
    public boolean isEmpty() {
        return !hasContent();
    }

    //设置是否为空
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    //迭代器
    @Override
    public Iterator<T> iterator() {
        return getContent().iterator();
    }
}
