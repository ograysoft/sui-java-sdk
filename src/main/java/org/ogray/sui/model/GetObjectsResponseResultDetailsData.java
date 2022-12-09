package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class GetObjectsResponseResultDetailsData {
    @Setter @Getter
    String dataType;

    @Setter @Getter
    String type;

    @Setter @Getter
    Boolean has_public_transfer;

    @Setter @Getter
    GetObjectsResponseResultDetailsDataFields fields;

    public String toString() {
        return "type="+type+", dataType="+dataType+", fields=["+fields+"]";
    }

    public long getBalance() {
        if(fields==null) return 0L;

        if(fields.getBalance()==null)
            return 0L;

        return fields.getBalance().longValue();
    }
}
