package com.base.core.util;

import java.util.*;
import java.io.Serializable;

public class Page implements Cloneable, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -66216875310144614L;

	public static final int DEFAULT_PAGE_SIZE = 20;

    public int currentPageIndex = 1;    //当前页
    private int totalAmount = 0;        //总记录数
    private int pageSize = DEFAULT_PAGE_SIZE;  //页面大小
    private int totalPageAmount = 0;       //总的页数
    private int pageStart;
    private boolean isAll = false;       //判断是否全部显示

    private int currentPageCol=1;       //当前行;
    private List curPageList = new ArrayList();

    public Page() {
    }

    public Page(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageStart() {
        changeStartPage();
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    /**
     * by leoj
     */
    public void changeStartPage() {
        pageStart = currentPageIndex <= 1 ? 1 : (currentPageIndex - 1) * pageSize + 1;
    }

    public int getCurrentPageIndex() {
        if (currentPageIndex > totalPageAmount)
            currentPageIndex = totalPageAmount;
        else if (currentPageIndex <= 0) currentPageIndex = 1;
        return currentPageIndex;
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
        if(this.getIsAll())
            totalPageAmount=1;
        else{
        if (totalAmount % pageSize == 0)
            totalPageAmount = totalAmount / pageSize;
        else                         //加了一个else 防止刚好20条是多加一页
            totalPageAmount = totalAmount / pageSize + 1;
        }

    }

    public void setTotalPageAmount(int totalPageAmount) {
		this.totalPageAmount = totalPageAmount;
	}

	public int getTotalPageAmount() {
        return totalPageAmount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getFirstIndexInPage() {
        return (currentPageIndex - 1) * pageSize;
    }

    public int getLastIndexInPage() {
        int last = currentPageIndex * pageSize + pageSize;
        if (last >= getTotalAmount())
            return getTotalAmount();
        else return last;
    }

    public int getFirstPageIndex() {
        return 1;
    }

    public int getLastPageIndex() {
        return totalPageAmount;
    }

    public boolean isLastPage() {
        return currentPageIndex == getLastPageIndex();
    }

    public boolean isFirstPage() {
        return currentPageIndex == getFirstPageIndex();
    }

    public int getNextPageIndex() {
        if (currentPageIndex + 1 > getTotalPageAmount())
            return getTotalPageAmount();
        else
            return currentPageIndex + 1;
    }

    public int getPreviousPageIndex() {
        if (currentPageIndex - 1 <= 0)
            return 1;
        else
            return currentPageIndex - 1;
    }

    public Map getAvaiablePages() {
        Map result = new LinkedHashMap();
        if (totalAmount == 0) return result;
        for (int i = 1; i < totalPageAmount + 1; i++) {
            result.put(i, i);
        }
        return result;
    }

    /*   public Page(int currentPage, int pageSize) {
        init();
        if (currentPage < 1)
            this.currentPageIndex = 1;
        else
            this.currentPageIndex = currentPage;
        if (pageSize < 1)
            this.pageSize = 1;
        else
            this.pageSize = pageSize;
        changeStartPage();
        changTotalPage();
    }*/

    public void init() {
        currentPageIndex = 1;
        totalAmount = 0;
        pageSize = DEFAULT_PAGE_SIZE;  //页面大小
        totalPageAmount = 0;       //总的页数
        changeStartPage();
        changTotalPage();

    }


    public void changTotalPage() {
        if (totalAmount > 0L)
            totalPageAmount = totalAmount % pageSize <= 0 ? totalAmount / pageSize : totalAmount / pageSize + 1;
        else
            totalPageAmount = 0;
        if (totalPageAmount > 0)
            this.currentPageIndex = currentPageIndex <= totalPageAmount ? currentPageIndex : totalPageAmount;

    }

/*
    public void changCurPageList(){
        if(currentPageCol==1){
             Integer curPageCol = 0;
            for (int i = 1; i < 10; i++) {
                 curPageCol = i;
                if (curPageCol > totalPageAmount) {
                    return;
                }
                curPageList.add(curPageCol);
            }
           if(curPageCol<totalAmount)
                    curPageList.add("...");
        }else{
            int startPage = 5+4*(currentPageCol-2);
            for (int i = 0; i < 9; i++) {
                Integer curPageCol = startPage+i;
                if (curPageCol > totalPageAmount) {
                    return;
                }
                curPageList.add(curPageCol);
            }
            if(startPage<totalAmount)
                    curPageList.add("...");
        }

    }
*/

    public boolean getIsAll() {
        return isAll;
    }

    public void setIsAll(boolean all) {
        isAll = all;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getCurrentPageCol() {
        return currentPageCol;
    }

    public void setCurrentPageCol(int currentPageCol) {
        this.currentPageCol = currentPageCol;
    }

    public List getCurPageList() {
        curPageList.clear();
        if(currentPageCol==1){
             Integer curPageCol = 0;
            for (int i = 1; i < 10; i++) {
                 curPageCol = i;
                if (curPageCol > totalPageAmount) {
                    return curPageList;
                }
                curPageList.add(curPageCol);
            }
           if(curPageCol<totalAmount)
                    curPageList.add("...");              
        }else{
            int startPage = 5+4*(currentPageCol-2);
            for (int i = 0; i < 9; i++) {
                Integer curPageCol = startPage+i;
                if (curPageCol > totalPageAmount) {
                    return curPageList;
                }
                curPageList.add(curPageCol);
            }
            if(startPage<totalAmount)
                    curPageList.add("...");
        }
        return curPageList;
    }

    public void setCurPageList(List curPageList) {
        this.curPageList = curPageList;
    }
}
