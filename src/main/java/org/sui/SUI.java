package org.sui;

import org.springframework.web.client.RestTemplate;
import org.ogray.sui.model.RpcSuiRequestWithParams;
import org.ogray.sui.model.SuiJsonResponse;
import org.json.JSONObject;
import org.springframework.http.*;

public class SUI {
   RestTemplate restTemplate = new RestTemplate();
   final String endpoint = "https://fullnode.devnet.sui.io:443";
   HttpEntity<String> prepareRequest(String data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<String>(data, headers);
    }
   /**
   * sui_batchTransaction
   *   Create an unsigned batched transaction.
   Parameters:
      signer : the transaction signer's Sui address
      single_transaction_params : list of transaction request parameters
      gas : gas object to be used in this transaction, the gateway will pick one from the signer's possession if not provided
      gas_budget : the gas budget, the transaction will fail if the gas cost exceed the budget
   */
   public SuiJsonResponse sui_batchTransaction(String _signer,String _single_transaction_params,String _gas,String _gas_budget) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_batchTransaction", 1);
      req.addParam( _signer );
      req.addParam( _single_transaction_params );
      req.addParam( _gas );
      req.addParam( _gas_budget );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_dryRunTransaction
   Parameters:
      tx_bytes : null
   */
   public SuiJsonResponse sui_dryRunTransaction(String _tx_bytes) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_dryRunTransaction", 1);
      req.addParam( _tx_bytes );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_executeTransaction
   *   Execute the transaction and wait for results if desired. Request types: 1. ImmediateReturn: immediately returns a response to client without waiting     for any execution results.  Note the transaction may fail without being     noticed by client in this mode. After getting the response, the client     may poll the node to check the result of the transaction. 2. WaitForTxCert: waits for TransactionCertificate and then return to client. 3. WaitForEffectsCert: waits for TransactionEffectsCert and then return to client.     This mode is a proxy for transaction finality. 4. WaitForLocalExecution: waits for TransactionEffectsCert and make sure the node     executed the transaction locally before returning the client. The local execution     makes sure this node is aware of this transaction when client fires subsequent queries.     However if the node fails to execute the transaction locally in a timely manner,     a bool type in the response is set to false to indicated the case.
   Parameters:
      tx_bytes : transaction data bytes, as base-64 encoded string
      sig_scheme : Flag of the signature scheme that is used.
      signature : transaction signature, as base-64 encoded string
      pub_key : signer's public key, as base-64 encoded string
      request_type : The request type
   */
   public SuiJsonResponse sui_executeTransaction(String _tx_bytes,String _sig_scheme,String _signature,String _pub_key,String _request_type) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_executeTransaction", 1);
      req.addParam( _tx_bytes );
      req.addParam( _sig_scheme );
      req.addParam( _signature );
      req.addParam( _pub_key );
      req.addParam( _request_type );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getCoinMetadata
   *   Return metadata(e.g., symbol, decimals) for a coin
   Parameters:
      coin_type : fully qualified type names for the coin (e.g., 0x168da5bf1f48dafc111b0a488fa454aca95e0b5e::usdc::USDC)
   */
   public SuiJsonResponse sui_getCoinMetadata(String _coin_type) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getCoinMetadata", 1);
      req.addParam( _coin_type );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getCommitteeInfo
   *   Return the committee information for the asked epoch
   Parameters:
      epoch : The epoch of interest. If None, default to the latest epoch
   */
   public SuiJsonResponse sui_getCommitteeInfo(String _epoch) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getCommitteeInfo", 1);
      req.addParam( _epoch );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getEvents
   *   Return list of events for a specified query criteria.
   Parameters:
      query : the event query criteria.
      cursor : optional paging cursor
      limit : maximum number of items per page
      descending_order : query result ordering, default to false (ascending order), oldest record first.  
   */
   public SuiJsonResponse sui_getEvents(String _query,String _cursor,String _limit,String _descending_order) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getEvents", 1);
      req.addParam( _query );
      req.addParam( _cursor );
      req.addParam( _limit );
      req.addParam( _descending_order );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getMoveFunctionArgTypes
   *   Return the argument types of a Move function, based on normalized Type.
   Parameters:
      package : null
      module : null
      function : null
   */
   public SuiJsonResponse sui_getMoveFunctionArgTypes(String _package,String _module,String _function) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getMoveFunctionArgTypes", 1);
      req.addParam( _package );
      req.addParam( _module );
      req.addParam( _function );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getNormalizedMoveFunction
   *   Return a structured representation of Move function
   Parameters:
      package : null
      module_name : null
      function_name : null
   */
   public SuiJsonResponse sui_getNormalizedMoveFunction(String _package,String _module_name,String _function_name) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getNormalizedMoveFunction", 1);
      req.addParam( _package );
      req.addParam( _module_name );
      req.addParam( _function_name );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getNormalizedMoveModule
   *   Return a structured representation of Move module
   Parameters:
      package : null
      module_name : null
   */
   public SuiJsonResponse sui_getNormalizedMoveModule(String _package,String _module_name) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getNormalizedMoveModule", 1);
      req.addParam( _package );
      req.addParam( _module_name );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getNormalizedMoveModulesByPackage
   *   Return structured representations of all modules in the given package
   Parameters:
      package : null
   */
   public SuiJsonResponse sui_getNormalizedMoveModulesByPackage(String _package) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getNormalizedMoveModulesByPackage", 1);
      req.addParam( _package );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getNormalizedMoveStruct
   *   Return a structured representation of Move struct
   Parameters:
      package : null
      module_name : null
      struct_name : null
   */
   public SuiJsonResponse sui_getNormalizedMoveStruct(String _package,String _module_name,String _struct_name) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getNormalizedMoveStruct", 1);
      req.addParam( _package );
      req.addParam( _module_name );
      req.addParam( _struct_name );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getObject
   *   Return the object information for a specified object
   Parameters:
      object_id : the ID of the queried object
   */
   public SuiJsonResponse sui_getObject(String _object_id) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getObject", 1);
      req.addParam( _object_id );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getObjectsOwnedByAddress
   *   Return the list of objects owned by an address.
   Parameters:
      address : the owner's Sui address
   */
   public SuiJsonResponse sui_getObjectsOwnedByAddress(String _address) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getObjectsOwnedByAddress", 1);
      req.addParam( _address );
      String request = new JSONObject(req).toString();
    //  String response = restTemplate.postForObject(endpoint, prepareRequest(request), String.class);
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
  //    return response;
   }

   /**
   * sui_getObjectsOwnedByObject
   *   Return the list of objects owned by an object.
   Parameters:
      object_id : the ID of the owner object
   */
   public SuiJsonResponse sui_getObjectsOwnedByObject(String _object_id) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getObjectsOwnedByObject", 1);
      req.addParam( _object_id );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getRawObject
   *   Return the raw BCS serialized move object bytes for a specified object.
   Parameters:
      object_id : the id of the object
   */
   public SuiJsonResponse sui_getRawObject(String _object_id) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getRawObject", 1);
      req.addParam( _object_id );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getTotalTransactionNumber
   *   Return the total number of transactions known to the server.
   Parameters:
   */
   public SuiJsonResponse sui_getTotalTransactionNumber() {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getTotalTransactionNumber", 1);
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getTransaction
   *   Return the transaction response object.
   Parameters:
      digest : the digest of the queried transaction
   */
   public SuiJsonResponse sui_getTransaction(String _digest) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getTransaction", 1);
      req.addParam( _digest );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getTransactions
   *   Return list of transactions for a specified query criteria.
   Parameters:
      query : the transaction query criteria.
      cursor : Optional paging cursor
      limit : Maximum item returned per page
      descending_order : query result ordering, default to false (ascending order), oldest record first.  
   */
   public SuiJsonResponse sui_getTransactions(String _query,String _cursor,String _limit,String _descending_order) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getTransactions", 1);
      req.addParam( _query );
      req.addParam( _cursor );
      req.addParam( _limit );
      req.addParam( _descending_order );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_getTransactionsInRange
   *   Return list of transaction digests within the queried range.
   Parameters:
      start : the matching transactions' sequence number will be greater than or equals to the starting sequence number
      end : the matching transactions' sequence number will be less than the ending sequence number
   */
   public SuiJsonResponse sui_getTransactionsInRange(String _start,String _end) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_getTransactionsInRange", 1);
      req.addParam( _start );
      req.addParam( _end );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_mergeCoins
   *   Create an unsigned transaction to merge multiple coins into one coin.
   Parameters:
      signer : the transaction signer's Sui address
      primary_coin : the coin object to merge into, this coin will remain after the transaction
      coin_to_merge : the coin object to be merged, this coin will be destroyed, the balance will be added to `primary_coin`
      gas : gas object to be used in this transaction, the gateway will pick one from the signer's possession if not provided
      gas_budget : the gas budget, the transaction will fail if the gas cost exceed the budget
   */
   public SuiJsonResponse sui_mergeCoins(String _signer,String _primary_coin,String _coin_to_merge,String _gas,String _gas_budget) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_mergeCoins", 1);
      req.addParam( _signer );
      req.addParam( _primary_coin );
      req.addParam( _coin_to_merge );
      req.addParam( _gas );
      req.addParam( _gas_budget );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_moveCall
   *   Create an unsigned transaction to execute a Move call on the network, by calling the specified function in the module of a given package.
   Parameters:
      signer : the transaction signer's Sui address
      package_object_id : the Move package ID, e.g. `0x2`
      module : the Move module name, e.g. `devnet_nft`
      function : the move function name, e.g. `mint`
      type_arguments : the type arguments of the Move function
      arguments : the arguments to be passed into the Move function, in [SuiJson](https://docs.sui.io/build/sui-json) format
      gas : gas object to be used in this transaction, the gateway will pick one from the signer's possession if not provided
      gas_budget : the gas budget, the transaction will fail if the gas cost exceed the budget
   */
   public SuiJsonResponse sui_moveCall(String _signer,String _package_object_id,String _module,String _function,String _type_arguments,String _arguments,String _gas,String _gas_budget) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_moveCall", 1);
      req.addParam( _signer );
      req.addParam( _package_object_id );
      req.addParam( _module );
      req.addParam( _function );
      req.addParam( _type_arguments );
      req.addParam( _arguments );
      req.addParam( _gas );
      req.addParam( _gas_budget );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_pay
   *   Send Coin<T> to a list of addresses, where `T` can be any coin type, following a list of amounts, The object specified in the `gas` field will be used to pay the gas fee for the transaction. The gas object can not appear in `input_coins`. If the gas object is not specified, the RPC server will auto-select one.
   Parameters:
      signer : the transaction signer's Sui address
      input_coins : the Sui coins to be used in this transaction
      recipients : the recipients' addresses, the length of this vector must be the same as amounts.
      amounts : the amounts to be transferred to recipients, following the same order
      gas : gas object to be used in this transaction, the gateway will pick one from the signer's possession if not provided
      gas_budget : the gas budget, the transaction will fail if the gas cost exceed the budget
   */
   public SuiJsonResponse sui_pay(String _signer,String _input_coins,String _recipients,String _amounts,String _gas,String _gas_budget) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_pay", 1);
      req.addParam( _signer );
      req.addParam( _input_coins );
      req.addParam( _recipients );
      req.addParam( _amounts );
      req.addParam( _gas );
      req.addParam( _gas_budget );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_payAllSui
   *   Send all SUI coins to one recipient. This is for SUI coin only and does not require a separate gas coin object. Specifically, what pay_all_sui does are: 1. accumulate all SUI from input coins and deposit all SUI to the first input coin 2. transfer the updated first coin to the recipient and also use this first coin as gas coin object. 3. the balance of the first input coin after tx is sum(input_coins) - actual_gas_cost. 4. all other input coins other than the first are deleted.
   Parameters:
      signer : the transaction signer's Sui address
      input_coins : the Sui coins to be used in this transaction, including the coin for gas payment.
      recipient : the recipient address,
      gas_budget : the gas budget, the transaction will fail if the gas cost exceed the budget
   */
   public SuiJsonResponse sui_payAllSui(String _signer,String _input_coins,String _recipient,String _gas_budget) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_payAllSui", 1);
      req.addParam( _signer );
      req.addParam( _input_coins );
      req.addParam( _recipient );
      req.addParam( _gas_budget );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_paySui
   *   Send SUI coins to a list of addresses, following a list of amounts. This is for SUI coin only and does not require a separate gas coin object. Specifically, what pay_sui does are: 1. debit each input_coin to create new coin following the order of amounts and assign it to the corresponding recipient. 2. accumulate all residual SUI from input coins left and deposit all SUI to the first input coin, then use the first input coin as the gas coin object. 3. the balance of the first input coin after tx is sum(input_coins) - sum(amounts) - actual_gas_cost 4. all other input coints other than the first one are deleted.
   Parameters:
      signer : the transaction signer's Sui address
      input_coins : the Sui coins to be used in this transaction, including the coin for gas payment.
      recipients : the recipients' addresses, the length of this vector must be the same as amounts.
      amounts : the amounts to be transferred to recipients, following the same order
      gas_budget : the gas budget, the transaction will fail if the gas cost exceed the budget
   */
   public SuiJsonResponse sui_paySui(String _signer,String _input_coins,String _recipients,String _amounts,String _gas_budget) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_paySui", 1);
      req.addParam( _signer );
      req.addParam( _input_coins );
      req.addParam( _recipients );
      req.addParam( _amounts );
      req.addParam( _gas_budget );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_publish
   *   Create an unsigned transaction to publish Move module.
   Parameters:
      sender : the transaction signer's Sui address
      compiled_modules : the compiled bytes of a move module, the
      gas : gas object to be used in this transaction, the gateway will pick one from the signer's possession if not provided
      gas_budget : the gas budget, the transaction will fail if the gas cost exceed the budget
   */
   public SuiJsonResponse sui_publish(String _sender,String _compiled_modules,String _gas,String _gas_budget) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_publish", 1);
      req.addParam( _sender );
      req.addParam( _compiled_modules );
      req.addParam( _gas );
      req.addParam( _gas_budget );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_splitCoin
   *   Create an unsigned transaction to split a coin object into multiple coins.
   Parameters:
      signer : the transaction signer's Sui address
      coin_object_id : the coin object to be spilt
      split_amounts : the amounts to split out from the coin
      gas : gas object to be used in this transaction, the gateway will pick one from the signer's possession if not provided
      gas_budget : the gas budget, the transaction will fail if the gas cost exceed the budget
   */
   public SuiJsonResponse sui_splitCoin(String _signer,String _coin_object_id,String _split_amounts,String _gas,String _gas_budget) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_splitCoin", 1);
      req.addParam( _signer );
      req.addParam( _coin_object_id );
      req.addParam( _split_amounts );
      req.addParam( _gas );
      req.addParam( _gas_budget );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_splitCoinEqual
   *   Create an unsigned transaction to split a coin object into multiple equal-size coins.
   Parameters:
      signer : the transaction signer's Sui address
      coin_object_id : the coin object to be spilt
      split_count : the number of coins to split into
      gas : gas object to be used in this transaction, the gateway will pick one from the signer's possession if not provided
      gas_budget : the gas budget, the transaction will fail if the gas cost exceed the budget
   */
   public SuiJsonResponse sui_splitCoinEqual(String _signer,String _coin_object_id,String _split_count,String _gas,String _gas_budget) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_splitCoinEqual", 1);
      req.addParam( _signer );
      req.addParam( _coin_object_id );
      req.addParam( _split_count );
      req.addParam( _gas );
      req.addParam( _gas_budget );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_transferObject
   *   Create an unsigned transaction to transfer an object from one address to another. The object's type must allow public transfers
   Parameters:
      signer : the transaction signer's Sui address
      object_id : the ID of the object to be transferred
      gas : gas object to be used in this transaction, the gateway will pick one from the signer's possession if not provided
      gas_budget : the gas budget, the transaction will fail if the gas cost exceed the budget
      recipient : the recipient's Sui address
   */
   public SuiJsonResponse sui_transferObject(String _signer,String _object_id,String _gas,String _gas_budget,String _recipient) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_transferObject", 1);
      req.addParam( _signer );
      req.addParam( _object_id );
      req.addParam( _gas );
      req.addParam( _gas_budget );
      req.addParam( _recipient );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_transferSui
   *   Create an unsigned transaction to send SUI coin object to a Sui address. The SUI object is also used as the gas object.
   Parameters:
      signer : the transaction signer's Sui address
      sui_object_id : the Sui coin object to be used in this transaction
      gas_budget : the gas budget, the transaction will fail if the gas cost exceed the budget
      recipient : the recipient's Sui address
      amount : the amount to be split out and transferred
   */
   public SuiJsonResponse sui_transferSui(String _signer,String _sui_object_id,String _gas_budget,String _recipient,String _amount) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_transferSui", 1);
      req.addParam( _signer );
      req.addParam( _sui_object_id );
      req.addParam( _gas_budget );
      req.addParam( _recipient );
      req.addParam( _amount );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }

   /**
   * sui_tryGetPastObject
   *   Note there is no software-level guarantee/SLA that objects with past versions can be retrieved by this API, even if the object and version exists/existed. The result may vary across nodes depending on their pruning policies. Return the object information for a specified version
   Parameters:
      object_id : the ID of the queried object
      version : the version of the queried object. If None, default to the latest known version
   */
   public SuiJsonResponse sui_tryGetPastObject(String _object_id,String _version) {
      RpcSuiRequestWithParams req = new RpcSuiRequestWithParams("sui_tryGetPastObject", 1);
      req.addParam( _object_id );
      req.addParam( _version );
      String request = new JSONObject(req).toString();
      SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);
      return reply;
   }
}
