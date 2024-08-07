package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> fields = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                try {
                    field.setAccessible(true);
                    var value = field.get(address);
                    if (value == null) {
                        fields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return fields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> fields = new HashMap<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            MinLength minLength = field.getAnnotation(MinLength.class);
            List<String> messages = new ArrayList<>();
            try {
                field.setAccessible(true);
                var value = field.get(address);
                if (notNull != null && value == null) {
                    messages.add("can not be null");
                }
                if (minLength != null && (value == null || value.toString().length() < minLength.minLength())) {
                    messages.add("length less than 4");
                }
                if(messages.size() != 0) {
                    fields.put(field.getName(), messages);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return fields;
    }
}
// END
