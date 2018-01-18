package recognizer;


public class Recognizer {
// Relevant states

    public static final int INITIAL = 0;
    public static final int FINAL1 = 1;
    public static final int ERROR = 3;
    public static final int FINAL2 = 6;
    public static final int FINAL3 = 7;
// Symbol constants
    public static final int DIGIT = 0;
    public static final int SIGNAL = 1;
    public static final int PONTO = 2;
    public static final int EXP = 3;
    public static final int OTHER = 4;
    private int[][] table = {{1, 2, 3, 3, 3}, {1, 3, 7, 4, 3},
    {1, 3, 3, 3, 3}, {3, 3, 3, 3, 3},{6, 5, 3, 3, 3}, {6, 3, 3, 3, 3},
    {6, 3, 3, 3, 3}, {7, 3, 3, 4, 3}};
    private int currentState;
// Constructor (empty)

    public Recognizer() {
    }
// Recognize (or not) if the string is a number
// returns the number or throws an NumberFormatException, otherwise

    public String  recognize(String s) throws  NumberFormatException {
        int pos = 0;
        int number[] = {0, 0, 0};
        char sinais[] = {' ', ' '};
        int signal = 1;
        int casa = 0;
        currentState = INITIAL;
        while (pos < s.length()) {
            char c = s.charAt(pos);
            int symbol = getSymbol(c);
            currentState = table[currentState][symbol];
            if (currentState == ERROR) {
                throw new NumberFormatException(s + 
                        " is not a real number!");
            }
            if (symbol == DIGIT) {
                number[casa] = number[casa] * 10 + c - '0';
            }
            if (symbol == SIGNAL) {
                signal = (c=='+')? 1 : -1;
            }
            if(symbol == PONTO){
                number[0] = signal* number[0];
                sinais[0] = '.';
                signal = 1;
                casa += 1;
            }
            if(symbol == EXP){
                number[casa] = signal * number[casa];
                signal = 1;
                if(sinais[0] == ' '){
                    sinais[0] = 'e';
                }
                else{
                    sinais[1] = 'e';
                }
                casa += 1;
            }
            pos++;
        }
        if (currentState != FINAL1 && currentState != FINAL2 && currentState != FINAL3) {
            throw new NumberFormatException(s + " is not a real number!");
        }
        number[casa] = signal* number[casa];
        String numero;
        if(casa == 0){
            numero = "" + number[0] + sinais[0];
        }
        else if(casa == 1){
            numero = "" + number[0] + sinais[0] + number[1];
        }
        else{
            numero = "" + number[0] + sinais[0] + number[1] + sinais[1] + number[2];
        }
        return numero;
    }

    private int getSymbol(char c) {
        if (Character.isDigit(c)) {
            return DIGIT;
        } else if (c == '-' || c == '+') {
            return SIGNAL;
        } else if (c == '.') {
            return PONTO;
        } else if (c == 'e' || c == 'E') {
            return EXP;
        } else {
            return OTHER;
        }
    }
}
