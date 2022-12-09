package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class AddressOwner {
    @Setter @Getter
    String owner;

    public String toString() {
        return this.owner;
    }
}
