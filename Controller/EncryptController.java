package Controller;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

public class EncryptController {
	  private SecretKey secretKey;
	  

	    public EncryptController(String secretKey) {
	        try {
	            MessageDigest md5 = MessageDigest.getInstance("MD5");
	            byte[] llavePassword = md5.digest(secretKey.getBytes("utf-8"));
	            byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
	            this.secretKey = new SecretKeySpec(BytesKey, "DESede");
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Error al inicializar EncryptController");
	        }
	    }

	    public String ecnode(String cadena) {
	        String encriptacion = "";
	        try {
	            Cipher cifrado = Cipher.getInstance("DESede");
	            cifrado.init(Cipher.ENCRYPT_MODE, secretKey);
	            byte[] plainTextBytes = cadena.getBytes("utf-8");
	            byte[] buf = cifrado.doFinal(plainTextBytes);
	            byte[] base64Bytes = Base64.encodeBase64(buf);
	            encriptacion = new String(base64Bytes);
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Error al encriptar");
	        }
	        return encriptacion;
	    }

	    public String deecnode(String cadenaEncriptada) {
	        String desencriptacion = "";
	        try {
	            Cipher decipher = Cipher.getInstance("DESede");
	            decipher.init(Cipher.DECRYPT_MODE, secretKey);
	            byte[] message = Base64.decodeBase64(cadenaEncriptada.getBytes("utf-8"));
	            byte[] plainText = decipher.doFinal(message);
	            desencriptacion = new String(plainText, "UTF-8");
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Error al desencriptar");
	        }
	        return desencriptacion;
	    }
	}

