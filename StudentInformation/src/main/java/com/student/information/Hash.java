package com.student.information;
public class Hash{
    private static final int FNV_PRIME = 16777619;
    public static final int FNV_OFFSET_BASIS = 0x811c9dc5;
    public static <Tkey> int Hash32(Tkey key) {
        byte[] data = String.valueOf(key).getBytes();
        int hash = FNV_OFFSET_BASIS;
        for (int i=0;i<data.length;i++) {
            hash ^= data[i];
            hash *= FNV_PRIME;
        }
        return hash;
    }
}
