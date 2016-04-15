package hu.pe.thinhhoang.algorithms;

import static java.lang.System.out;

/**
 * Created by hoang on 15/04/16.
 * Email: hoangdinhthinh@live.com
 */

public class BaseRC {
    public static int[] S = new int[256]; // chứa các hoán vị từ 0..255
    public static int[] key = new int[256]; // chứa khóa
    public static int[] K = new int[256]; // chứa 256 byte khóa
    public static int N; // key có 10 ký tự
    public static int in = 0;
    public static int ij = 0;

    public static void initRC4() // KSA
    {
        in=0; ij=0; // Reset lại các chỉ số permutation
        for (int i = 0; i < 256; i++) {
            S[i] = i; // 1 hoán vị của 0..255
            K[i] = key[i % N]; // lặp đi lặp lại key
        }

        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (int) ((j + S[i] + K[i]) % 256);
            // Hoán vị S[j] và S[i]
            int temp = S[j];
            S[j] = S[i];
            S[i] = temp;
        }
    }

    public static int getByte() // PRGA
    {
        in = (in + 1) % 256;
        ij = (ij + S[in]) % 256;
        int temp = S[ij];
        S[ij] = S[in];
        S[in] = temp;
        int k = ((S[in] + S[ij]) % 256);
        out.println("+ Working with byte "+in+" and "+ij+": "+k);
        return S[k];
    }

    public static void main(String[] args) {
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
            key[x]= (int) keypass.charAt(x);
        }
        N = (byte) keypass.length();

        initRC4(); // Khởi tạo không gian làm việc cho BaseRC

        // Mã hóa
        for (int x=0; x<input.length(); x++)
        {
            // Với mỗi biến trong input
            resultEncrypt.append((char)(input.charAt(x) ^ getByte()));
        }

        out.println("----------------");
        out.println("Encrypted: "+resultEncrypt.toString());
        out.println("----------------");

        initRC4();

        // Giải mã
        for (int x=0; x<resultEncrypt.length(); x++)
        {
            resultDecrypt.append((char)(resultEncrypt.charAt(x) ^ getByte()));
        }

        out.println("----------------");
        out.println("Decrypted: "+resultDecrypt.toString());
        out.println("----------------");
    }

}
