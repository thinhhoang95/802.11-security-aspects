package hu.pe.thinhhoang;

import static java.lang.System.out;

/**
 * Created by hoang on 15/04/16.
 */
public class RC4Main {

    static void main(String[] args)
    {
        IRC4 irc4 = new RC4(); // TODO: Initialize new RC4Main instance
        StringBuffer input, keypass, resultEncrypt, resultDecrypt; // Tất cả tối đa 256 ký tự
        input = new StringBuffer("Attack Paris at 11AM tomorrow");
        keypass = new StringBuffer("Hail Jew");
        resultEncrypt = new StringBuffer();
        resultDecrypt = new StringBuffer();

        int i=0;
        int j=0;

        // Đọc key vào
        for(byte x=0; x<keypass.length(); x++)
        {
            irc4.key[x]= (int) keypass.charAt(x);
        }
        irc4.N = (byte) keypass.length();

        irc4.initRC4(); // Khởi tạo không gian làm việc cho BaseRC

        // Mã hóa
        for (int x=0; x<input.length(); x++)
        {
            // Với mỗi biến trong input
            resultEncrypt.append((char)(input.charAt(x) ^ irc4.getByte()));
        }

        out.println("----------------");
        out.println("Encrypted: "+resultEncrypt.toString());
        out.println("----------------");

        irc4.initRC4();

        // Giải mã
        for (int x=0; x<resultEncrypt.length(); x++)
        {
            resultDecrypt.append((char)(resultEncrypt.charAt(x) ^ irc4.getByte()));
        }

        out.println("----------------");
        out.println("Decrypted: "+resultDecrypt.toString());
        out.println("----------------");
    }
}
