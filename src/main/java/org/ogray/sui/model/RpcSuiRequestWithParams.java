package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Vector;

public class RpcSuiRequestWithParams {
    @Setter
    @Getter
    String jsonrpc;

    @Setter @Getter
    String method;

    @Setter @Getter
    Integer id;

    @Setter @Getter
    List<String> params;

    public RpcSuiRequestWithParams(String method, int id) {
        this.jsonrpc = "2.0";
        this.method = method;
        this.id = Integer.valueOf(id);
        this.params = null;
    }

    public void addParam(String value) {
        if(params==null) {
            params = new Vector<String>();
        }
        params.add(value);
    }
}
