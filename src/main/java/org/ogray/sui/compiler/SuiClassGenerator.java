package org.ogray.sui.compiler;

import lombok.extern.slf4j.Slf4j;
import org.ogray.Tools;
import org.ogray.sui.model.RpcDiscoverResponseMethod;
import org.ogray.sui.model.RpcDiscoverResponseMethodParam;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Slf4j
public class SuiClassGenerator {
    private List<RpcDiscoverResponseMethod> methods;
    final String methodTab = "   ";

    String baseSourceFolder;

    public String getSourceFolder(String pkg) {
        return baseSourceFolder + Tools.convertPackageToFolder(pkg);
    }
    public SuiClassGenerator(String baseSourceFolder, List<RpcDiscoverResponseMethod> methods) {
        this.methods = methods;
        this.baseSourceFolder = baseSourceFolder;
    }

    public String generateSource(String pkg, String className) {
        String src = "package " + pkg + ";\n\n";

        src += "import org.springframework.web.client.RestTemplate;\n";
        src += "import org.ogray.sui.model.RpcSuiRequestWithParams;\n";
        src += "import org.ogray.sui.model.SuiJsonResponse;\n";
        src += "import org.json.JSONObject;\n";
        src += "import org.springframework.http.*;\n";

        src += "\npublic class " + className + " {\n";

        src += methodTab + "RestTemplate restTemplate = new RestTemplate();\n";
        src += methodTab + "final String endpoint = \"https://fullnode.devnet.sui.io:443\";\n";

        src += methodTab + "HttpEntity<String> prepareRequest(String data) {\n" +
                "        HttpHeaders headers = new HttpHeaders();\n" +
                "        headers.setContentType(MediaType.APPLICATION_JSON);\n" +
                "        return new HttpEntity<String>(data, headers);\n" +
                "    }";

        for(RpcDiscoverResponseMethod item : methods) {
            String docs = generateMethodDocs(item);
            src += "\n" + docs + "\n";

            String methodName = item.getName().trim();
            String methodHeader = methodTab + "public SuiJsonResponse " + methodName +"(";
            src += methodHeader;

            String params = getParametersString(item.getParams());
            src += params;

            if(params.length()>1) {
                // remove last ','
                src = src.substring(0, src.length() - 1);
            }

            src += ") {\n";
            src += methodTab +  methodTab + "RpcSuiRequestWithParams req = new RpcSuiRequestWithParams(\""+methodName+"\", 1);\n";

            for(RpcDiscoverResponseMethodParam p : item.getParams()) {
                src+= methodTab + methodTab +"req.addParam( _"+ p.getName()+" );\n";
            }

            src += methodTab +  methodTab + "String request = new JSONObject(req).toString();\n";

            src += methodTab + methodTab + "SuiJsonResponse reply = restTemplate.postForObject(endpoint, prepareRequest(request), SuiJsonResponse.class);\n";
            src +=  methodTab + methodTab + "return reply;\n";
            src+= methodTab + "}\n";
        } // for methods

        src += "}\n";
        return src;
    }

    private String generateMethodDocs(RpcDiscoverResponseMethod item) {
        String src = methodTab + "/**\n";
        src += methodTab +"* " + item.getName() + "\n";
        if(item.getDescription()!=null)
            src += methodTab +"*   " + item.getDescription() +"\n";

        src += methodTab +"Parameters:\n";

        for( RpcDiscoverResponseMethodParam param : item.getParams()) {
            src+= methodTab + "   " + param.getName() +" : "+ param.getDescription() +"\n";
        }

        src += methodTab +"*/";
        return src;
    }

    private String getParametersString(List<RpcDiscoverResponseMethodParam> params) {
        String src = "";
        for(RpcDiscoverResponseMethodParam param : params) {
            src += "String _"+param.getName() +",";
        } // for
        return src;
    }

    String getFullSourceFileName(String pkg, String fileName) {
        return getSourceFolder(pkg) + fileName;
    }

    public void createSourceFile(String pkg, String className) throws IOException {
        String src = generateSource(pkg, className);
        String fileName = className + ".java";

        Tools.createFolderIfNotExist(getSourceFolder(pkg));
        String fullFileName = getFullSourceFileName(pkg, fileName);

        FileWriter aWriter = new FileWriter(fullFileName, false);
        aWriter.write(src);

        aWriter.flush();
        aWriter.close();
    }
}
