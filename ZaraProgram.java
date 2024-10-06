public class ZaraProgram {
    public static void main(String[] args) {
        SymbolTable table = new SymbolTable();

        // Declare variables of various types
        table.addSymbol("var1", "integer", 10);
        table.addSymbol("var2", "float", 3.14);
        table.addSymbol("var3", "string", "Hello, Zara!");
table.addSymbol("var4","string","Is this a Zara programming language ?");
        // Update a variable's value
        table.updateSymbol("var1", 20);

        // Retrieve and print symbol details
        System.out.println("var1: " + table.getSymbol("var1"));
        System.out.println("var2: " + table.getSymbol("var2"));
        System.out.println("var3: " + table.getSymbol("var3"));
        System.out.println("var4: " + table.getSymbol("var2"));
    }
}

