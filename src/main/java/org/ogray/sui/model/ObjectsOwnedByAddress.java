package org.ogray.sui.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Base64;

public class ObjectsOwnedByAddress {
    @Setter @Getter
    String objectId;

    @Setter @Getter
    Integer version;

    @Setter @Getter
    String digest;

    @Setter @Getter
    String type;


    @Setter @Getter
    String previousTransaction;

    @Setter @Getter
    AddressOwner owner;

    public String toString() {
        //byte[] transaction = Base64.getDecoder().decode(previousTransaction);
        return "/"+objectId+", type="+SuiTools.getTypeShort(this.getType() ); //+", previousTransaction="+ Utils.toHex(transaction);
    }

}
