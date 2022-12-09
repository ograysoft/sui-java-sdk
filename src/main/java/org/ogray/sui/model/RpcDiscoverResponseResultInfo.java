package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class RpcDiscoverResponseResultInfo {
    @Setter @Getter
    String title;

    @Setter @Getter
    String description;

    @Setter @Getter
    RpcDiscoverResponseResultInfoContact contact;

    @Setter @Getter
    RpcDiscoverResponseResultInfoLicense license;

    @Setter @Getter
    String version;
}
