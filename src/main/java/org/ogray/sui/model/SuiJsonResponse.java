package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class SuiJsonResponse {
    @Setter @Getter
    String jsonrpc;

    @Setter @Getter
    Long id;

    @Setter @Getter
    Object result;

    public String toString() {
        return "jsonrpc="+jsonrpc+", id="+id+", result=[" + result + "]";
    }
}
