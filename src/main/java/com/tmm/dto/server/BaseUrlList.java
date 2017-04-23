package com.tmm.dto.server;

import java.util.List;

/**
 * Created by Captain Wang on 17/4/23.
 */
public class BaseUrlList {
    private Integer baseurlTotal;
    private List<BaseURLDetails> baseUrls;

    public BaseUrlList() {
    }

    public BaseUrlList(Integer baseurlTotal, List<BaseURLDetails> baseUrls) {
        this.baseurlTotal = baseurlTotal;
        this.baseUrls = baseUrls;
    }

    public Integer getBaseurlTotal() {
        return baseurlTotal;
    }

    public void setBaseurlTotal(Integer baseurlTotal) {
        this.baseurlTotal = baseurlTotal;
    }

    public List<BaseURLDetails> getBaseUrls() {
        return baseUrls;
    }

    public void setBaseUrls(List<BaseURLDetails> baseUrls) {
        this.baseUrls = baseUrls;
    }
}
