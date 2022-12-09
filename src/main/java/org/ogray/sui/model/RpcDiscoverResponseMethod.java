package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class RpcDiscoverResponseMethod {
    @Setter @Getter
    String name;

    @Setter @Getter
    List<RpcDiscoverResponseMethodTag> tags;

    @Setter @Getter
    String description;

    @Setter @Getter
    List<RpcDiscoverResponseMethodParam> params;

    @Setter @Getter
    RpcDiscoverResponseMethodResult result;

    public String toString() {
        String res = this.name + "(";

        for(RpcDiscoverResponseMethodParam item : params) {
            res+= item +",";
        }
        if(!res.isEmpty()) res = res.substring(0, res.length()-1);
        res+= ")";
        return res;
    }
}
