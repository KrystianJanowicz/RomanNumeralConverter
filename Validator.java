import java.util.Arrays;

public class Validator {

    static char[] romanSigns = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    static String rom = "MMMIDI";

    public static void main(String[] args) {

        char[] tablica = rom.toCharArray();
        int i = markSubtraction(rom);
        tablica[i + 1] = 'O';
        tablica[i] = 'O';

        System.out.println(calcAdditivePartToDecimal(Arrays.toString(tablica)));
        System.out.println("roznica: " + calcSubtractionPartToDecimal(rom));
    }

    public static boolean validateRoman(String roman) {

        return true;
    }

    public static int calcSubtractionPartToDecimal(String sequence) {
        char array[] = sequence.toCharArray();
        return calcAdditivePartToDecimal(array[markSubtraction(sequence) + 1]) - calcAdditivePartToDecimal(array[markSubtraction(sequence)]);
    }

    public static boolean containsIncorrectSigns(String sequence) {
        for (char sign : sequence.toCharArray()) {
            if ((sign != 'M') && (sign != 'D') && (sign != 'C') && (sign != 'X') && (sign != 'V') && (sign != 'I'))
                return true;
        }
        return false;
    }

    public static int markSubtraction(String sequence) {
        char[] charSequence = sequence.toCharArray();
        for (int i = 0; i < charSequence.length; i++) {
            for (int j = 0; i <= romanSigns.length; j++) {
                try {
                    if ((charSequence[i] == romanSigns[j]) &&
                            ((charSequence[i + 1] == romanSigns[j + 1]) ||
                                    (charSequence[i + 1] == romanSigns[j + 2]) ||
                                    (charSequence[i + 1] == romanSigns[j + 3]) ||
                                    (charSequence[i + 1] == romanSigns[j + 4]) ||
                                    (charSequence[i + 1] == romanSigns[j + 5]) ||
                                    (charSequence[i + 1] == romanSigns[j + 6]))) {
                        return i;
                    }
                } catch (ArrayIndexOutOfBoundsException n) {
                    break;
                }
            }
        }
        return -1;
    }

    public static int calcAdditivePartToDecimal(char rom) {
        int decimal = 0;
        switch (rom) {
            case 'M':
                decimal = decimal + 1000;
                break;
            case 'D':
                decimal = decimal + 500;
                break;
            case 'C':
                decimal = decimal + 100;
                break;
            case 'L':
                decimal = decimal + 50;
                break;
            case 'X':
                decimal = decimal + 10;
                break;
            case 'V':
                decimal = decimal + 5;
                break;
            case 'I':
                decimal = decimal + 1;
                break;
        }
        return decimal;
    }

    public static int calcAdditivePartToDecimal(String rom) {
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
                case 'L':
                    decimal = decimal + 50 * countSignsInString(rom, romanSign);
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
        return outcome;
    }
}