package tw.crws.aes;

import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class TestAES {

	public static void main(String[] args) throws Exception {
		String algorithm = "AES/CBC/PKCS5PADDING";
		String input = "passw0rd";
//		SecretKey key = AES.generateKey();
		SecretKey secret = AES.getKeyFromPassword(input, "salt");
//		SecretKey secret2 = AES.getKeyFromPassword(input, "salt");
		IvParameterSpec iv1 = AES.generateIv();		
		String ivs = Base64.getEncoder().encodeToString(iv1.getIV());
		String cipherText = AES.encrypt(algorithm, input, secret, iv1);
		String plainText = AES.decrypt(algorithm, cipherText, secret, new IvParameterSpec(Base64.getDecoder().decode(ivs)));
//		String plainText2 = AES.decrypt(algorithm, cipherText, secret2, iv1);
//		System.out.println(key.getAlgorithm());
		System.out.println(ivs);
//		System.out.println(secret);
//		System.out.println(secret2);
		System.out.println(cipherText);
		System.out.println(plainText);
//		System.out.println(plainText2);
	}

}
