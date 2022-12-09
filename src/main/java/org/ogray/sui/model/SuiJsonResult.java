package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class SuiJsonResult {
    @Setter @Getter
    String status;

    @Setter @Getter
    Object details;

    public String toString() {
        return "status="+status+", details='"+details +"' "+details.getClass().getCanonicalName();
    }
}
