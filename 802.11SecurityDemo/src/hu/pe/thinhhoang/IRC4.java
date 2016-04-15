package hu.pe.thinhhoang;

/**
 * Created by hoang on 15/04/16.
 */
public abstract class IRC4 {
    public int[] S = new int[256]; // chứa các hoán vị từ 0..255
    public int[] key = new int[256]; // chứa khóa
    public int[] K = new int[256]; // chứa 256 byte khóa
    public int N; // key có 10 ký tự
    public int in = 0;
    public int ij = 0;

    public abstract void initRC4();
    public abstract int getByte();

}
