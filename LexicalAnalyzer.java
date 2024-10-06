import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

class Token {
    String type;
    String value;

    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token [type=" + type + ", value=" + value + "]";
    }
}

public class LexicalAnalyzer {
    private static final String KEYWORDS = "\\b(if|else|do|while)\\b";
    private static final String DATATYPES = "\\b(int|float|string|array|stack)\\b";
    private static final String OPERATORS = "[+\\-*/=<>!]+";
    private static final String IDENTIFIERS = "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b";
    private static final String LITERALS = "\\b\\d+(\\.\\d+)?\\b|\"[^\"]*\""; // Matches numbers and strings in quotes

    private static final Pattern TOKEN_PATTERN = Pattern.compile(
            KEYWORDS + "|" + DATATYPES + "|" + OPERATORS + "|" + IDENTIFIERS + "|" + LITERALS
    );

    public List<Token> tokenize(String code) {
        List<Token> tokens = new ArrayList<>();
        Matcher matcher = TOKEN_PATTERN.matcher(code);

        while (matcher.find()) {
            if (matcher.group().matches(KEYWORDS)) {
                tokens.add(new Token("KEYWORD", matcher.group()));
            } else if (matcher.group().matches(DATATYPES)) {
                tokens.add(new Token("DATATYPE", matcher.group()));
            } else if (matcher.group().matches(OPERATORS)) {
                tokens.add(new Token("OPERATOR", matcher.group()));
            } else if (matcher.group().matches(IDENTIFIERS)) {
                tokens.add(new Token("IDENTIFIER", matcher.group()));
            } else if (matcher.group().matches(LITERALS)) {
                tokens.add(new Token("LITERAL", matcher.group()));
            }
        }

        return tokens;
    }

    public static void main(String[] args) {
        LexicalAnalyzer lexer = new LexicalAnalyzer();

        // Sample Zara code
        String code = "int x = 10; float y = 3.14; string msg = \"Hello Zara\"; if (x > y) { x = x + 1; }";

        // Tokenize the code
        List<Token> tokens = lexer.tokenize(code);

        // Print the tokens
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
