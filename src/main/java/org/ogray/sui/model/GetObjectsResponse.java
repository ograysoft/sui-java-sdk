package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class GetObjectsResponse {
    @Setter
    @Getter
    String jsonrpc;

    @Setter
    @Getter
    Integer id;

    @Setter
    @Getter
    GetObjectsResponseResult result;

    public String toString() {
        return "result=["+result+"]";
    }
}
