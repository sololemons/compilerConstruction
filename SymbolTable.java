import java.util.HashMap;

class Symbol {
    String type;
    Object value;

    Symbol(String type, Object value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Value: " + value;
    }
}

public class SymbolTable {
    HashMap<String, Symbol> table;

    public SymbolTable() {
        table = new HashMap<>();
    }

    public void addSymbol(String name, String type, Object value) {
        if (!table.containsKey(name)) {
            table.put(name, new Symbol(type, value));
            System.out.println("Added symbol: " + name);
        } else {
            System.out.println("Symbol " + name + " already exists.");
        }
    }

    public void updateSymbol(String name, Object newValue) {
        if (table.containsKey(name)) {
            Symbol symbol = table.get(name);
            symbol.value = newValue;
            System.out.println("Updated symbol: " + name);
        } else {
            System.out.println("Symbol " + name + " not found.");
        }
    }

    public Symbol getSymbol(String name) {
        return table.get(name);
    }
}

