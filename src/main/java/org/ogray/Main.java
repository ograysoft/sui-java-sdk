package org.ogray;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.ogray.sui.SuiGate;
import org.ogray.sui.compiler.DynamicCompiler;
import org.ogray.sui.compiler.SuiClassGenerator;
import org.ogray.sui.model.GetObjectsResponse;
import org.ogray.sui.model.RpcDiscoverResponse;
import org.ogray.sui.model.SuiJsonResponse;
import org.sui.SUI;

import java.io.IOException;

@Slf4j
public class Main {
    static void generateSUIClass() throws IOException{
        SuiGate gate = new SuiGate();
        RpcDiscoverResponse resp = gate.getListOfAvailableMethods();

        String basePackage = "org.sui";
        String className = "SUI";
        String baseSourceFolder = "src/main/java/";

        SuiClassGenerator generator = new SuiClassGenerator( baseSourceFolder, resp.getResult().getMethods() );
        generator.createSourceFile(basePackage, className);
    }
    public static void main(String[] args) {

  /*      try {
            generateSUIClass();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        SUI sui = new SUI();
        String adr = "0x05b8a952a0492191f77a942d55b2e6e19a6d4df6";
        SuiJsonResponse obj = sui.sui_getObject(adr);
        System.out.println("res1: " + obj);

      //  com.google.gson.internal.LinkedTreeMap det = (com.google.gson.internal.LinkedTreeMap)obj.getResult().getDetails();
      //  Object data = det.get("data");
       // System.out.println(data);

    //    SuiGate gate = new SuiGate();
     //   GetObjectsResponse res2 = gate.getObjectInfo(adr);
     //   System.out.println("res2: " + res2);

    }
}