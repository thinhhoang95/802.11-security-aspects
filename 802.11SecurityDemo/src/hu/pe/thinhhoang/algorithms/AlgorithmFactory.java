package hu.pe.thinhhoang.algorithms;

/**
 * Created by hoang on 09/04/16.
 */

public class AlgorithmFactory {
    public enum ALGORITHMS {RC4, AES128, AES256, AES192};

    public static Algorithm getAlgorithm(ALGORITHMS a) throws Exception {
        if (a.equals(ALGORITHMS.RC4)) {
            // Return BaseRC object
            return null;
        } else if (a.equals(ALGORITHMS.AES128)) {
            // Return AES128 object...
            return null;
        } else {
            throw new Exception("Not a valid algorithm");
        }
    }
}
