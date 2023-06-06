package decathlon.decathlonadminproject;

import java.security.SecureRandom;

public class OTPUtils {
    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int OTP_LENGTH = 6;

    private static SecureRandom random = new SecureRandom();

    public static String generateOTP() {
        StringBuilder sb = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static boolean validateEmailOTP(String enteredOTP, String generatedOTP) {
        return enteredOTP.equals(generatedOTP);
    }

    public static boolean validatePhoneOTP(String enteredOTP, String generatedOTP) {
        return enteredOTP.equals(generatedOTP);
    }
}
