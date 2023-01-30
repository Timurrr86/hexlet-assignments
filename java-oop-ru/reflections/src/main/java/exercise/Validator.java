package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> nullFields = new ArrayList<>();
        try {
            for (Field field : address.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(address);
                if (value == null && !(field.getAnnotation(NotNull.class) == null)) {
                    nullFields.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return nullFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> notValidFields = new HashMap<>();
        List<Field> fields = List.of(address.getClass().getDeclaredFields());
            fields.stream()
                .forEach(field -> {
                        field.setAccessible(true);
                        Object value;
                        try {
                            value = field.get(address);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                        if (field.isAnnotationPresent(MinLength.class) && String.valueOf(value).length() < field.getAnnotation(MinLength.class).minLength()) {
                            notValidFields.put(field.getName(), List.of("length less than 4"));
                        }
                        if (value == null && !(field.getAnnotation(NotNull.class) == null)) {
                            notValidFields.put(field.getName(), List.of("can not be null"));
                        }

                    });
        return notValidFields;
    }
}
// END
