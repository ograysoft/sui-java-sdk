package org.ogray.sui;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.ogray.sui.model.*;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


@Slf4j
public class SuiGate {
    final String mainNetEndpoint = "https://fullnode.devnet.sui.io:443";
    Gson gson = new Gson();
    RestTemplate restTemplate = new RestTemplate();


    public SuiGate() {
    }

    HttpEntity<String> prepareRequest(String data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<String>(data, headers);
    }

    public GetObjectsResponse getObjectInfo(String address) {
        RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getObject", 1);
        req.addParam(address);
        String request = new JSONObject(req).toString();

        RestTemplate restTemplate = new RestTemplate();

    //    return restTemplate.postForObject(mainNetEndpoint, prepareRequest(request), GetObjectsResponse.class);
        String reply = restTemplate.postForObject(mainNetEndpoint, prepareRequest(request), String.class);
        log.info(reply);

        GetObjectsResponse obj = gson.fromJson(reply, GetObjectsResponse.class);
        return obj;
    }

    public GetObjectsOwnedByAddressResponse getObjectsOwndedByAddress(String address) {
        RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getObjectsOwnedByAddress", 1);
        req.addParam(address);
        String request = new JSONObject(req).toString();
        log.info("request: [" + request + "]");

        RestTemplate restTemplate = new RestTemplate();
        String reply = restTemplate.postForObject(mainNetEndpoint, prepareRequest(request), String.class);
        log.info("response: ["+reply+"]");
        GetObjectsOwnedByAddressResponse obj = gson.fromJson(reply, GetObjectsOwnedByAddressResponse.class);
        return obj;

       // return  restTemplate.postForObject(mainNetEndpoint, prepareRequest(request), GetObjectsOwnedByAddressResponse.class);
    }

    public RpcDiscoverResponse getListOfAvailableMethods() {
        RpcSuiRequest req = new RpcSuiRequest("rpc.discover", 1);
        String request = new JSONObject(req).toString();

        String reply = restTemplate.postForObject(mainNetEndpoint, prepareRequest(request), String.class);
        log.info("response: ["+reply+"]");

        RpcDiscoverResponse obj = gson.fromJson(reply, RpcDiscoverResponse.class);
        return obj;
       // return restTemplate.postForObject(mainNetEndpoint, prepareRequest(request), RpcDiscoverResponse.class);
    }

    public GetCoinMetadataResponse getCoinInfo(String type) {
        RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getCoinMetadata", 1);
        req.addParam(type);
        String request = new JSONObject(req).toString();

        RestTemplate restTemplate = new RestTemplate();

        //    return restTemplate.postForObject(mainNetEndpoint, prepareRequest(request), GetObjectsResponse.class);
        String reply = restTemplate.postForObject(mainNetEndpoint, prepareRequest(request), String.class);
        log.info(reply);

        GetCoinMetadataResponse obj = gson.fromJson(reply, GetCoinMetadataResponse.class);
        return obj;
    }
}
