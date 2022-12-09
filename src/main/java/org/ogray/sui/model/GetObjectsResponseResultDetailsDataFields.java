package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class GetObjectsResponseResultDetailsDataFields {
    @Setter @Getter
    Long balance;

    @Setter @Getter
    GetObjectsResponseResultDetailsDataFieldsId id;

    public String toString() {
        return "balance="+balance+", fieldId=["+id+"]";
    }
}
