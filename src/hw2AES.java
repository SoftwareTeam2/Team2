import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class hw2AES {
	// k와 C1을 Decrypt한 후 IV와 XOR을 진행하면 plaintext가 나올 것이다.
	// String으로 제시된 것들을 byte화 시킨 후 plaintext를 String으로 출력한다.
	// cipher를 decode하기위해 조사를 해본 결과, secretkey와 dofinal를 이용해야 한다는 것을
	// 알게되었다.
	byte[] decodeByteKey;
	byte[] decodeByteIv;
	
	public String decodeCipher(String str, byte[] key) throws Exception {
		SecretKeySpec secretKey = new SecretKeySpec(decodeByteKey, "AES");// 비밀키를 지정함

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // 과제조건인 PKC5 사용
		cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(decodeByteIv));
		// 자바에선 secretkey를 지원하며 init메소드를 사용하기 위해선 secretkey가 필요하다는 것을 알게되었다.
		byte[] decodeCipher = cipher.doFinal(Base64.getDecoder().decode(str.getBytes()));
		return new String(decodeCipher);
	}

	public static void main(String[] args) throws Exception {
		// Base64로 Encoding되어있는 키와 IV, C를 먼저 decoding하는 코드를 찾아 보았다.
		String key = "8iE3bf1se6N76HGPP8S0Xw==";
		String iv = "cHml3oX848/0uBwDJtChOA==";
		String Cipher = "QDr9NZNG9Bgc3TTnfRuqjjzf/kVSYwbP7F9mR4GQZ/IneIh7HTc/xnwzEeVBcH3pPlIbLFySKZruedJc9X87CGNDJ1f2Dat8BR3Ypbei5Q42xc306/AkSuGsjfqbX9/ELxmdKn7MyvY/Jbc0v0AJHV6odgNzygKRRrFJcUIF/50=";

		// Base64를 조사해 본 결과 바이트 단위로 진행이되는걸 알수있었다. 그리고 key iv c를 바이트로 나타내주어야 한다는것도
		// 알게되었다.
		byte[] byteKey = key.getBytes(); // getBytes라는 메소드를 사용하면 바이트로 나타낼 수 있다
		byte[] byteIv = iv.getBytes(); // String array이므로 byte array로 나타내준다.

		// 자바는 Base64 인코딩 및 디코딩을 제공한다는 것을 알게되었다.
		hw2AES aes = new hw2AES();
		aes.decodeByteKey = Base64.getDecoder().decode(byteKey);
		aes.decodeByteIv = Base64.getDecoder().decode(byteIv);

		System.out.println(aes.decodeByteKey);
		System.out.println(aes.decodeByteIv);
		System.out.println(aes.decodeCipher(Cipher, byteKey));
	}
}
