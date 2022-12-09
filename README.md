# sui-java-sdk
SUI Java SDK

- SUI-Java-SDK Version: **0.0.1** (2022-12-9)

## Requirements
 * Windows, Linux or Macos 
 * Java 1.8 or greater
 

 ## Features
 * Provides JAVA API for SUI blockchain
 * automatically generates JAVA classes with Doxygen from SUI RPC calls
 * easy call SUI methods with native JAVA calls
 * sample application provided

## Quick start

 ### Windows 
 1. Clone repository 
 > git clone https://github.com/ograysoft/sui-java-sdk

 2. Open project from IntelliJ IDEA 2022
    Build Project (Ctrl + F9)

 3. Choose run configuration
    *'SUI Class Generator'* - launch **org.ogray.Main** to send request to SUI ('rpc.discover')
     and generates class ord.sui.SUI according to response
     this run will overriwrites current ord.sui.SUI sources!

    *'Wallet'* - launch sample application which uses SUI class.
     before running press 'Edit configuguration' and add command line arguments"
     **'getobjects < address >'** where <address> is SUI wallet address


 



