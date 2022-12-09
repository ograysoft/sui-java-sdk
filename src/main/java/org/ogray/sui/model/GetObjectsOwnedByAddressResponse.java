package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GetObjectsOwnedByAddressResponse {
    @Setter @Getter
    String jsonrpc;

    @Setter @Getter
    List<ObjectsOwnedByAddress> result;

    public String toString() {
        if(result==null || result.isEmpty())
            return "";

        String res = "";

        for(ObjectsOwnedByAddress item : result) {
            res += "[ " + item + "] ";
        }
        return res;
    }


}
