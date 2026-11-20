package warungtujuhberadik.util;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public final class PasswordUtil {
    private static final String ALGORITMA = "PBKDF2WithHmacSHA256";
    private static final int ITERASI = 120_000, PANJANG_KUNCI = 256, PANJANG_SALT = 16;
    private PasswordUtil() {}
    public static String hash(char[] password) {
        byte[] salt = new byte[PANJANG_SALT];
        new SecureRandom().nextBytes(salt);
        return ITERASI + ":" + Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(derive(password, salt, ITERASI));
    }
    public static boolean verifikasi(char[] password, String tersimpan) {
        try {
            String[] bagian = tersimpan.split(":", -1);
            if (bagian.length != 3) return false;
            int iterasi = Integer.parseInt(bagian[0]);
            byte[] salt = Base64.getDecoder().decode(bagian[1]);
            byte[] aktual = derive(password, salt, iterasi);
            return MessageDigest.isEqual(aktual, Base64.getDecoder().decode(bagian[2]));
        } catch (RuntimeException e) { return false; }
    }
    private static byte[] derive(char[] password, byte[] salt, int iterasi) {
        try {
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterasi, PANJANG_KUNCI);
            try { return SecretKeyFactory.getInstance(ALGORITMA).generateSecret(spec).getEncoded(); }
            finally { spec.clearPassword(); }
        } catch (GeneralSecurityException e) { throw new IllegalStateException("Algoritma hash password tidak tersedia.", e); }
    }
}
