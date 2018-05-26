package Crypto;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
   
import javax.crypto.Cipher;

public class CryptoAES { 
   static String IV = null;
   
   public CryptoAES() { 
      IV = "AAAAAAAAAAAAAAAA";
   } 
      
   public String encrypt(String textopuro, String chaveencriptacao) throws Exception { 
      Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding"); 
      SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("ISO-8859-1"), "AES"); 
      encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("ISO-8859-1"))); 
      return new String(encripta.doFinal(textopuro.getBytes("ISO-8859-1")));
   }
}