package tasks_week_1;

public class Caesar {
    private final int ALPHABET_SIZE = 26;
    public String generateCipher(String plainText, int offset){

        StringBuilder result = new StringBuilder();
        for(char symbol : plainText.toCharArray()){
            if(Character.isAlphabetic(symbol)){
                result.append(moveChar(symbol,offset));
            } else {
                result.append(symbol);
            }
        }

        return result.toString();
    }

    private char moveChar(char symbol, int offset){
        int alphabetPosition = symbol - (Character.isUpperCase(symbol) ? 'A' : 'a');
        int cipherPosition = (alphabetPosition + offset) % ALPHABET_SIZE;
        return (char) ((Character.isUpperCase(symbol) ? 'A' : 'a') + cipherPosition);

    }
    public static void main(String[] args) {
        Caesar caesar = new Caesar();
        System.out.println(caesar.generateCipher("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG", 23));
    }
}
