# sui-java-sdk
SUI Java SDK

- SUI-Java-SDK Version: **0.0.1** (2022-12-9)

  Documentation is [here](https://github.com/ograysoft/sui-java-sdk/wiki)

## Requirements
 * Windows, Linux or Macos 
 * Java 1.8 or greater
 

 ## Features
 * Provides JAVA API for SUI blockchain
 * automatically generates JAVA classes with Doxygen from SUI RPC calls
 * easy call SUI methods with native JAVA calls
 * sample application provided

## Quick start

 ### Windows / Linux / WSL

  Prerequisites : JDK 11+, Maven

 Toc check that you're ready type
 > mvn -version

You should get something similar to it 
> Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: /mnt/c/pub/maven
Java version: 11.0.16, vendor: Ubuntu, runtime: /usr/lib/jvm/java-11-openjdk-amd64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.10.102.1-microsoft-standard-wsl2", arch: "amd64", family: "unix"


 1. Clone repository
 > git clone https://github.com/ograysoft/sui-java-sdk
 
> cd sui-java-sdk
 2. Build project
 > mvn package

 3. To get objects owned by SUI address run
 > cd target

 > java -jar SuiSDK-1.0-SNAPSHOT-exec.jar getobjects 0xc8617b3df5511e5789bf4991ac2ecef137f51505

 4. To generate Java sources from SUI RPC run
 > java -jar SuiSDK-1.0-SNAPSHOT-exec.jar generate

 5. To generate Doxygen on SUI sources, install **doxygen** and run
> doxygen

  Generated Javadoc is [here](https://ograysoft.github.io/sui-java-sdk/classorg_1_1sui_1_1_s_u_i.html)
