package Check;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 读取授权码
 * 默认读取C盘下固定路径
 * @author 11579
 *
 */
public class ReadAuthValue {
	public String auth() throws IOException {
		
		    String filePath = "C:\\HB\\auth.txt"; // 指定要读取的txt文件路径
	        
	        BufferedReader reader = new BufferedReader(new FileReader(filePath));
	        StringBuilder contentBuilder = new StringBuilder();
	        String line;
	        
	        while ((line = reader.readLine()) != null) {
	            contentBuilder.append(line);
	        }
	        
	        String content = contentBuilder.toString();
	        //System.out.println("读取到的内容为:\n" + content);
	        
	        reader.close();
		return content;
	}
	

}
