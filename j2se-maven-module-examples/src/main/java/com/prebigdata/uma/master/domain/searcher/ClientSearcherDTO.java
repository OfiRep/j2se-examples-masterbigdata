package com.prebigdata.uma.master.domain.searcher;

import org.bson.types.ObjectId;

public class ClientSearcherDTO {
    
    public ObjectId idSearchCriteria;
    public String nameSearchCriteria;
    
    public ClientSearcherDTO() {
        this.idSearchCriteria = null;
        this.nameSearchCriteria = null;
    }
}
