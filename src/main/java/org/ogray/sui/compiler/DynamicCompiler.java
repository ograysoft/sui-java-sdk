package org.ogray.sui.compiler;

import org.ogray.Tools;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.lang.reflect.*;


public class DynamicCompiler {
  String baseSourceFolder = "src/main/java/";
  String baseBinaryFolder = "target/classes";

  String srcPackage;

  Date today = new Date();
  String todayMillis = Long.toString(today.getTime());
  String todayClass = "z_" + todayMillis;

  public DynamicCompiler(String packageName) {
      this.srcPackage = packageName;
  }

  String getSourceFolder() {
        return baseSourceFolder + Tools.convertPackageToFolder(srcPackage);
  }


  String getTodaySourceFileName() {
    return getSourceFolder() + todayClass + ".java";
  }

  public static void main (String args[]) {
      DynamicCompiler mtc = new DynamicCompiler("org.custom");
    mtc.createIt();
    if (mtc.compileIt()) {
       System.out.println("Running " + mtc.todayClass + ":\n\n");
       mtc.runIt();
       }
    else
       System.err.println(mtc.getTodaySourceFileName() + " compilation failed.");

    }

  public void createIt() {
    try {
        Tools.createFolderIfNotExist(getSourceFolder());
        FileWriter aWriter = new FileWriter(getTodaySourceFileName(), true);
        aWriter.write("package "+srcPackage+";\npublic class "+ todayClass + "{\n");
        aWriter.write(" public void doit() {");
        aWriter.write(" System.out.println(\""+todayMillis+"\");");
        aWriter.write(" }}\n");
        aWriter.flush();
        aWriter.close();
      }
    catch(Exception e){
        e.printStackTrace();
      }
    }



    public boolean compileIt() {
        String str = new String(getTodaySourceFileName());
        String [] source = { "-d", this.baseBinaryFolder, str };
        int ret = com.sun.tools.javac.Main.compile(source) ;

        return (ret==0);
  }

  public void runIt() {
    try {
          Class params[] = {};
          Object paramsObj[] = {};

          File f = new File(baseBinaryFolder);
          URL[] cp = { f.toURI().toURL() };
          URLClassLoader urlcl = new URLClassLoader(cp);
          Class thisClass = urlcl.loadClass(srcPackage+"."+todayClass);

          Object iClass = thisClass.newInstance();
          Method thisMethod = thisClass.getDeclaredMethod("doit", params);
          thisMethod.invoke(iClass, paramsObj);
      } catch (Exception e) {
            e.printStackTrace();
      }
    }
}