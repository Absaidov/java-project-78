package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema {

    private List<Predicate> conditions = new ArrayList<>();
    private boolean checking;

    public final StringSchema required() {
        conditions.add(s -> s instanceof String && !"".equals(s) && s != null);
        checking = true;
        return this;
    }

    public final StringSchema minLength(int num) {
        conditions.add(s -> s.toString().length() >= num);
        return this;
    }

    public final StringSchema contains(String substring) {
        conditions.add(s -> s.toString().contains(substring));
        return this;
    }
    public final boolean isValid(Object obj){
        if (obj == null){
            return !checking;
        }
        for (Predicate condition : conditions){
            if (!condition.test(obj)){
                return !checking;
            }
        }
        return true;
    }
}
