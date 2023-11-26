import java.util.*;

interface TextCharacter {
    void display();
}

class Character implements TextCharacter {
    private char symbol;

    public Character(char symbol) {
        this.symbol = symbol;
    }

    public void display() {
        System.out.print(symbol);
    }
}

class CharacterFactory {
    private Map<java.lang.Character, TextCharacter> characterCache = new HashMap<>();

    public TextCharacter getCharacter(char symbol) {
        if (!characterCache.containsKey(symbol)) {
            characterCache.put(symbol, new Character(symbol));
        }
        return characterCache.get(symbol);
    }
}

class WordProcessor {
    private CharacterFactory characterFactory = new CharacterFactory();
    private List<TextCharacter> characters = new ArrayList<>();

    public void addCharacter(char symbol) {
        characters.add(characterFactory.getCharacter(symbol));
    }

    public void displayText() {
        for (TextCharacter character : characters) {
            character.display();
        }
        System.out.println();
    }
}

public class Flyweight {
    public static void main(String args[]) {
        WordProcessor wordProcessor = new WordProcessor();
        wordProcessor.addCharacter('H');
        wordProcessor.addCharacter('E');
        wordProcessor.addCharacter('L');
        wordProcessor.addCharacter('L');
        wordProcessor.addCharacter('O');
        wordProcessor.displayText();
    }
}
