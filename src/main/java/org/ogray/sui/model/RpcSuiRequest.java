package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class RpcSuiRequest {
    @Setter @Getter
    String jsonrpc;

    @Setter @Getter
    String method;

    @Setter @Getter
    Integer id;

    public RpcSuiRequest(String method, int id) {
        this.jsonrpc = "2.0";
        this.method = method;
        this.id = Integer.valueOf(id);
    }
}
