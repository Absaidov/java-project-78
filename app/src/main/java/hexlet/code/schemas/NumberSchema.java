package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        addCondition(number -> number instanceof Integer && number != null);
        setChecking(true);
        return this;
    }
    public final NumberSchema positive() {
        addCondition(number -> number instanceof Integer && Integer.parseInt(number.toString()) > 0);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        addCondition(number -> number instanceof Integer && min <= Integer.parseInt(number.toString())
                && Integer.parseInt(number.toString()) <= max);
        return this;
    }
}
