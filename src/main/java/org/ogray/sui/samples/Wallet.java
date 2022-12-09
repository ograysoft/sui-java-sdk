package org.ogray.sui.samples;

import org.ogray.Main;
import org.ogray.sui.model.SuiJsonResponse;
import org.sui.SUI;

import java.io.IOException;
import java.security.SecureRandom;

public class Wallet {
    public Wallet() {

    }
    public static void main(String []args) {
        if(args.length<2) {
            System.out.println("Usage: wallet <command> <parameter>");
            System.out.println("   getobjects <address>");
            return;
        }
        switch(args[0]) {
            case "getobjects":
                SUI sui = new SUI();
                SuiJsonResponse resp = sui.sui_getObjectsOwnedByAddress(args[1]);
                System.out.println(resp);
                break;
            case "generate":
                try {
                    Main.generateSUIClass();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.err.println("Not recognized command: "+args[0]);
        }
    }
}
