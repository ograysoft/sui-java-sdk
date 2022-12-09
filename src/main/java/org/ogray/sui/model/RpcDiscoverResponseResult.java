package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class RpcDiscoverResponseResult {

    @Setter @Getter
    String openrpc;

    @Setter @Getter
    RpcDiscoverResponseResultInfo info;

    @Setter
    @Getter
    List<RpcDiscoverResponseMethod> methods;

    @Setter @Getter
    RpcDiscoverResponseResultComponents components;

    @Setter @Getter
    Integer id;
}
