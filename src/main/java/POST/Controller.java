package POST;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Check.checkAuth;
 
@RestController
public class Controller {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }
    @PostMapping("/PostApi")
    public String post() throws NoSuchAlgorithmException, IOException {
    	//每次调用接口都校验授权码是否有效
    	checkAuth check =new checkAuth();
    	boolean resule = check.checkResult();
    	if(resule) {
    		return "{\r\n"
    				+ "    \"Response\": {\r\n"
    				+ "        \"return\": {\r\n"
    				+ "            \"returnCode\": \"OK\",\r\n"
    				+ "            \"returnDesc\": \"授权通过\",\r\n"
    				+ "            \"returnFlag\": \"1\"\r\n"
    				+ "        }\r\n"
    				+ "    }\r\n"
    				+ "}";
    		
    	}else {
			return "{\r\n"
					+ "    \"Response\": {\r\n"
					+ "        \"return\": {\r\n"
					+ "            \"returnCode\": \"ERROR\",\r\n"
					+ "            \"returnDesc\": \"NODATA\",\r\n"
					+ "            \"returnFlag\": \"0\"\r\n"
					+ "        }\r\n"
					+ "    }\r\n"
					+ "}";
    	}
    	
    }
   
}