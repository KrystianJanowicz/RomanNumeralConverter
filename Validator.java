public class Validator {

    static char[] romanSigns = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    static int[] romanSignValues = {1, 5, 10, 50, 100, 500, 1000};
    static String rom = "IVM";
    static String rom2 = "MMCAXVIXIRI";

    public static void main(String[] args) {

//        System.out.println(calcRomanToDecimal(rom));
//        System.out.println("is incorrect?: " + containsIncorrectSigns(rom2));

        System.out.println(containsSubtraction(rom));
    }

    public static boolean validateRoman(String roman) {

        return true;
    }

    public static boolean containsIncorrectSigns(String sequence) {
        for (char sign : sequence.toCharArray()) {
            if ((sign != 'M') || (sign != 'D') || (sign != 'C') || (sign != 'X') || (sign != 'V') || (sign != 'I'))
                return true;
        }
        return false;
    }

    public static boolean containsSubtraction(String sequence) {
        char[] charSequence = sequence.toCharArray();
        for (int i = 0; i < charSequence.length; i++) {
            if ((charSequence[i] == romanSigns[i]) && (charSequence[i + 1] == romanSigns[i + 1])) {
                return true;
            }
        }
        return false;
    }


    public static int calcRomanToDecimal(String rom) {
        int decimal = 0;
        for (char romanSign : romanSigns) {
            switch (romanSign) {
                case 'M':
                    decimal = decimal + 1000 * countSignsInString(rom, romanSign);
                    break;
                case 'D':
                    decimal = decimal + 500 * countSignsInString(rom, romanSign);
                    break;
                case 'C':
                    decimal = decimal + 100 * countSignsInString(rom, romanSign);
                    break;
                case 'X':
                    decimal = decimal + 10 * countSignsInString(rom, romanSign);
                    break;
                case 'V':
                    decimal = decimal + 5 * countSignsInString(rom, romanSign);
                    break;
                case 'I':
                    decimal = decimal + 1 * countSignsInString(rom, romanSign);
                    break;
            }
        }
        return decimal;
    }

    public static int countSignsInString(String line, char sign) {
        int outcome = line.length() - line.replace(String.valueOf(sign), "").length();
        System.out.println("Number of letter " + sign + " in that sequence is " + outcome);
        return outcome;
    }
}
