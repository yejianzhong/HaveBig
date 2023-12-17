package POST;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import Check.checkAuth;
 
@SpringBootApplication()
public class Application extends  SpringBootServletInitializer  {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
    	//启动时校验授权码是否有效
    	checkAuth check =new checkAuth();
    	boolean result = check.checkResult();
    	if(result) {
        SpringApplication.run(Application.class, args);
        }else {
        	System.out.println("授权失败，请联系销售人员");
        	SpringApplication.exit(null, null);
        }
    }
    
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

}