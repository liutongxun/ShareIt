package com.shareIt.subject.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Pagination request entity.
 *
 * Encapsulates the parameters required for a paginated query, such as page number and page size.
 * Provides validation to ensure sensible defaults if parameters are missing or out of range.
 *
 * @author Liu Tongxun
 * @date 2025/06/09
 */
@Data
public class PageInfo implements Serializable {

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE) {
            return 20;
        }
        return pageSize;
    }


}
