package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class RpcDiscoverResponseMethodParam {
    @Setter @Getter
    String name;

    @Setter @Getter
    String description;

    @Setter @Getter
    Boolean required;

    @Setter @Getter
    RpcDiscoverResponseMethodParamSchema schema;

    public String toString() {
        return name;
    }
}
