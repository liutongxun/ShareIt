package com.shareIt.subject.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Pagination response entity.
 *
 * Represents a paginated result set including page metadata and records.
 *
 * @author Liu Tongxun
 * @date 2025/06/09
 */
/**
 * Generic pagination response container.
 *
 * @param <T> the type of the records in the paginated result
 */
@Data
public class PageResult<T> implements Serializable {

    /** Current page number, defaults to 1 */
    private Integer pageNo = 1;

    /** Number of records per page, defaults to 20 */
    private Integer pageSize = 20;

    /** Total number of records across all pages */
    private Integer total = 0;

    /** Total number of pages calculated from total and pageSize */
    private Integer totalPages = 0;

    /** List of records for the current page */
    private List<T> result = Collections.emptyList();

    /** Index of the first record on the current page (1-based) */
    private Integer start = 1;

    /** Index of the last record on the current page (1-based) */
    private Integer end = 0;

    /**
     * Assigns the list of records for this page.
     * If the list is non-null and non-empty, it also sets the total count
     * to the size of the provided list, triggering recalculation of derived fields.
     *
     * @param result the list of records to display on the current page
     */
    public void setRecords(List<T> result) {
        this.result = result == null ? Collections.emptyList() : result;
        if (result != null && result.size() > 0){
            setTotal(result.size());
        }
    }

    /**
     * Sets the total record count and automatically recalculates:
     * - totalPages = total / pageSize, rounded up if there is a remainder
     * - start = (pageNo - 1) * pageSize + 1
     * - end = start - 1 + pageSize
     *
     * @param total the total number of records across all pages
     */
    public void setTotal(Integer total) {
        this.total = total == null ? 0 : total;
        if (pageSize != null && pageSize > 0){
            this.totalPages = total / pageSize + (total % pageSize == 0 ? 0 : 1);
        }else {
            this.totalPages = 0;
        }

        this.start = (pageSize > 0 ? (pageNo - 1) * pageSize : 0) + 1;
        this.end = start - 1 + (pageSize > 0 && pageNo > 0 ? pageSize : 0);


    }

    /**
     * Updates the pageSize. Note: changing pageSize will not automatically
     * recalculate totalPages, start, and end until setTotal is called again.
     *
     * @param pageSize the new page size to apply
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Updates the pageNo. Note: changing pageNo will not automatically
     * recalculate start and end until setTotal is called again.
     *
     * @param pageNo the new page number to apply
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
