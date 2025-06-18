import java.util.Random;

// This is the backend Or the logical part
public class PasswordGenerator {

    //character pools
    // these strings will hold the password to generate using random picks
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_+={}[];:,./?<>";

    //the random class allows us to generate a random number which will be used to randomly choose

    private final Random random;

    //constructor
    public PasswordGenerator() {
        random = new Random();
    }

    // length -- length of the password to be generated (Taken from user)
    //includeUppercase and etc.. consider if the password should include uppercase,lowercase,etc..(take from user)
    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers,
                                   boolean includeSpecialSymbols) {

        StringBuilder passwordBuilder = new StringBuilder();

        // store valid characters (toggle states)

        String validCharacters = "";
        if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if(includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        // build password
        for(int i=0;i< length ;i++){
            // generate a random index
            int randomIndex = random.nextInt(validCharacters.length());

            // get the char bbased on random index

            char randomChar = validCharacters.charAt(randomIndex);

            //store char into password builder
            passwordBuilder.append(randomChar);

            // do this until we have reached the length of the user has provided

        }
        //return the result
        return passwordBuilder.toString();
    }
}
