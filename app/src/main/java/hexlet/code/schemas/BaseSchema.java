package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private List<Predicate> conditions = new ArrayList<>();
    @Setter
    @Getter
    private boolean checking = false;

    protected final void addCondition(Predicate condition) {
        conditions.add(condition);
    }
    public final boolean isValid(Object obj) {
        if (obj == null) {
            return (!isChecking());
        }
        for (Predicate condition : conditions) {
            if (!condition.test(obj)) {
                return false;
            }
        }
        return true;
    }
}
