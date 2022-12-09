package org.ogray.sui.model;

import lombok.Getter;
import lombok.Setter;

public class GetCoinMetadataResponse {
    @Setter @Getter
    String jsonrpc;

    @Setter @Getter
    GetCoinMetadataResponseResult result;

    @Setter @Getter
    Long id;

    public String toString() {
        if(this.getResult()!=null)
            return this.getResult().getSymbol();

        return "";
    }
}
