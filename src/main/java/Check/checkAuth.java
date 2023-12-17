package Check;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

import Untils.LocalMACUtil;

/**
 * 校验授权码是否正确
 * @author 11579
 * authvalue 本地授权文件
 * newauth 正确授权码
 *
 */
public class checkAuth {
	public boolean checkResult() throws IOException, NoSuchAlgorithmException {
		ReadAuthValue readAuthValue = new ReadAuthValue();
		LocalMACUtil localMACUtil = new LocalMACUtil();
		String authvalue = readAuthValue.auth();
		
		String Mac = localMACUtil.getLocalMac();
		
		String encryptedText = DigestUtils.md5Hex(Mac).toUpperCase(); 
        if (authvalue.compareTo(encryptedText)==0){
        	return true;
        }else {
        	return false;
        }
		
		
	}
	
	  public static void main(String[] args) throws IOException,
	  NoSuchAlgorithmException { checkAuth chek = new checkAuth();
	  chek.checkResult();
	  System.out.println(chek.checkResult());
	  
	 }
	 

}
