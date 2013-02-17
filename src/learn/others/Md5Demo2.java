package learn.others;

import java.security.*;

import sun.misc.BASE64Encoder;

public class Md5Demo2
{
    /**
     * This method uses SHA1 to hash the input string and then output the base
     * 64 encoded string of the hashed string.
     * @param dataToHash the string to be hashed
     * @return the base 64 hashed string or null if SHA1 is not available.
     */
    public static String hashSHA1String(String dataToHash)
    {
        String tmp = null;

        try
        {
            //One-way hash
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] byteTmpe = md.digest(dataToHash.getBytes());

            //base 64 encoding, using sun's internal lib
            BASE64Encoder b64encoder = new BASE64Encoder();
            tmp = b64encoder.encode(byteTmpe);
        }
        catch (java.security.NoSuchAlgorithmException e)
        {
            //silence and return null
        }
        
        return tmp;
    }

    public static void main(String[] args)
    {
        String a = "abcdefg";
        String b = "abcdefghijk";
        String c = "4220282as";

        String aa = hashSHA1String(a);
        String bb = hashSHA1String(b);
        String cc = hashSHA1String(c);

        System.out.println("aa==" + aa);
        System.out.println("bb==" + bb);
        System.out.println("cc==" + cc);
        System.out.println("check a==c: " + aa.equals(cc));
    }
}