public class PasswordValidator {

    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_SYMBOLS = "~!@#$%^&*()-=_+";

    public static boolean validatePassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialSymbol = false;

        for (char c : password.toCharArray()) {
            if (LOWER_CASE.indexOf(c) != -1) {
                hasLowerCase = true;
            } else if (UPPER_CASE.indexOf(c) != -1) {
                hasUpperCase = true;
            } else if (NUMBERS.indexOf(c) != -1) {
                hasNumber = true;
            } else if (SPECIAL_SYMBOLS.indexOf(c) != -1) {
                hasSpecialSymbol = true;
            }
        }

        int categoryCount = (hasLowerCase ? 1 : 0) + (hasUpperCase ? 1 : 0) + (hasNumber ? 1 : 0) + (hasSpecialSymbol ? 1 : 0);

        return categoryCount >= 3;
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("Password123!"));  // true
        System.out.println(validatePassword("password123"));  // false
        System.out.println(validatePassword("P@ssw0rd"));  // true
        System.out.println(validatePassword("short"));  // false
    }
}