package com.app.collectiontool.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Gadget {

    private Long gadgetId;

    private String gadgetName;

    private final String baseUrl;

    public Gadget(Long gadgetId, String gadgetName, String baseUrl){
        this.gadgetId=gadgetId;
        this.gadgetName=gadgetName;
        this.baseUrl = baseUrl;
    }

    public String getUrl() {
        return baseUrl + "/" + gadgetId;
    }

}
