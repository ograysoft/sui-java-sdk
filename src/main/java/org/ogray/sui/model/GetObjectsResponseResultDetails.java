package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class GetObjectsResponseResultDetails {
    @Setter @Getter
    GetObjectsResponseResultDetailsData data;

    @Setter @Getter
    GetObjectsResponseResultDetailsOwner owner;

    @Setter @Getter
    String previousTransaction;

    @Setter @Getter
    Integer storageRebate;

    @Setter @Getter
    GetObjectsResponseResultDetailsReference reference;

    public long getBalance() {
        if(this.data!=null) {
            return this.data.getBalance();
        }
        return 0L;
    }

    public String toString() {
        return "data=["+data+"]";
    }
}
