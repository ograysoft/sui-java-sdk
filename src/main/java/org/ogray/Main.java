package org.ogray;

import lombok.extern.slf4j.Slf4j;
import org.ogray.sui.SuiGate;
import org.ogray.sui.compiler.SuiClassGenerator;
import org.ogray.sui.model.RpcDiscoverResponse;

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

        try {
            generateSUIClass();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}