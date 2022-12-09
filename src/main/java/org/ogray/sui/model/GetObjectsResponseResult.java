package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class GetObjectsResponseResult {
    @Setter @Getter
    String status;

    @Setter @Getter
    GetObjectsResponseResultDetails details;

    public String toString() {
        return "status="+status+", details=["+details+"]";
    }

    public long getBalance() {
        if(this.status!=null && this.status.compareToIgnoreCase("Exists")==0) {
            if (this.details != null) {
                return this.details.getBalance();
            }
        }
        return 0L;
    }
}
