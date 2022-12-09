package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class GetObjectsResponseResultDetailsReference {
    @Setter @Getter
    String objectId;

    @Setter @Getter
    Integer version;

    @Setter @Getter
    String digest;
}
