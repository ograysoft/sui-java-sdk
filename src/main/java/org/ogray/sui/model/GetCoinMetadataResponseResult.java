package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class GetCoinMetadataResponseResult {
    @Setter
    @Getter
    Integer decimals;

    @Setter
    @Getter
    String name;

    @Setter
    @Getter
    String symbol;

    @Setter
    @Getter
    String description;

    @Setter
    @Getter
    String iconUrl;

    @Setter
    @Getter
    String id;
}
