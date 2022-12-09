package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class RpcDiscoverResponse {
    @Setter @Getter
    String jsonrpc;

    @Setter @Getter
    Integer id;

    @Setter @Getter
    RpcDiscoverResponseResult result;

    public String getListOfMethods() {
        if(result==null || result.getMethods()==null) {
            return "";
        }

        String res = "";
        for( RpcDiscoverResponseMethod item : result.getMethods() ) {
            res += item +",\n";
        }
        return res;
    }
}
