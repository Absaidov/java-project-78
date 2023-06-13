### Hexlet tests and linter status:
[![Actions Status](https://github.com/Absaidov/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/Absaidov/java-project-78/actions) [![Actions Status](https://github.com/Absaidov/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/Absaidov/java-project-78/actions/workflows/main.yml)

[![Maintainability](https://api.codeclimate.com/v1/badges/50518c88003ac86aae61/maintainability)](https://codeclimate.com/github/Absaidov/java-project-78/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/50518c88003ac86aae61/test_coverage)](https://codeclimate.com/github/Absaidov/java-project-78/test_coverage)


# Валидатор данных
Валидатор данных – библиотека, с помощью которой можно проверять корректность данных. На данный момент реализована возможность проверять строки, числа и объекты типа Map по валидаторам.

## Примеры использования:

### Валидация строк
```
import hexlet.code.Validator; 
import hexlet.code.schemas.StringSchema;

Validator v = new Validator();

StringSchema schema = v.string();

schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true
schema.isValid(null); // false
schema.isValid(""); // false

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
// уже false, так как добавлена ещё одна проверка contains("whatthe")
```

[//]: # (### Валидация чисел)

[//]: # (```)

[//]: # (import hexlet.code.Validator;)

[//]: # (import hexlet.code.schemas.NumberSchema;)

[//]: # ()
[//]: # (Validator v = new Validator&#40;&#41;;)

[//]: # ()
[//]: # (NumberSchema schema = v.number&#40;&#41;;)

[//]: # ()
[//]: # (schema.isValid&#40;null&#41;; // true)

[//]: # ()
[//]: # (schema.required&#40;&#41;;)

[//]: # ()
[//]: # (schema.isValid&#40;null&#41;; // false)

[//]: # (schema.isValid&#40;10&#41; // true)

[//]: # (schema.isValid&#40;"5"&#41;; // false)

[//]: # ()
[//]: # (schema.positive&#40;&#41;.isValid&#40;10&#41;; // true)

[//]: # (schema.isValid&#40;-10&#41;; // false)

[//]: # ()
[//]: # (schema.range&#40;5, 10&#41;;)

[//]: # ()
[//]: # (schema.isValid&#40;5&#41;; // true)

[//]: # (schema.isValid&#40;10&#41;; // true)

[//]: # (schema.isValid&#40;4&#41;; // false)

[//]: # (schema.isValid&#40;11&#41;; // false)

[//]: # (```)

[//]: # (### Валидация объектов типа Map)

[//]: # (```)

[//]: # (import hexlet.code.Validator;)

[//]: # (import hexlet.code.schemas.MapSchema;)

[//]: # ()
[//]: # (Validator v = new Validator&#40;&#41;;)

[//]: # ()
[//]: # (MapSchema schema = v.map&#40;&#41;;)

[//]: # ()
[//]: # (schema.isValid&#40;null&#41;; // true)

[//]: # ()
[//]: # (schema.required&#40;&#41;;)

[//]: # ()
[//]: # (schema.isValid&#40;null&#41; // false)

[//]: # (schema.isValid&#40;new HashMap&#40;&#41;&#41;; // true)

[//]: # (Map<String, String> data = new HashMap<>&#40;&#41;;)

[//]: # (data.put&#40;"key1", "value1"&#41;;)

[//]: # (schema.isValid&#40;data&#41;; // true)

[//]: # ()
[//]: # (schema.sizeof&#40;2&#41;;)

[//]: # ()
[//]: # (schema.isValid&#40;data&#41;;  // false)

[//]: # (data.put&#40;"key2", "value2"&#41;;)

[//]: # (schema.isValid&#40;data&#41;; // true)

[//]: # (```)

[//]: # (### Вложенная валидация)

[//]: # (```)

[//]: # (import hexlet.code.Validator;)

[//]: # (import hexlet.code.schemas.MapSchema;)

[//]: # (import hexlet.code.schemas.BaseSchema;)

[//]: # ()
[//]: # (Validator v = new Validator&#40;&#41;;)

[//]: # ()
[//]: # (MapSchema schema = v.map&#40;&#41;;)

[//]: # ()
[//]: # (// shape - позволяет описывать валидацию для значений объекта Map по ключам.)

[//]: # (Map<String, BaseSchema> schemas = new HashMap<>&#40;&#41;;)

[//]: # (schemas.put&#40;"name", v.string&#40;&#41;.required&#40;&#41;&#41;;)

[//]: # (schemas.put&#40;"age", v.number&#40;&#41;.positive&#40;&#41;&#41;;)

[//]: # (schema.shape&#40;schemas&#41;;)

[//]: # ()
[//]: # (Map<String, Object> human1 = new HashMap<>&#40;&#41;;)

[//]: # (human1.put&#40;"name", "Kolya"&#41;;)

[//]: # (human1.put&#40;"age", 100&#41;;)

[//]: # (schema.isValid&#40;human1&#41;; // true)

[//]: # ()
[//]: # (Map<String, Object> human2 = new HashMap<>&#40;&#41;;)

[//]: # (human2.put&#40;"name", "Maya"&#41;;)

[//]: # (human2.put&#40;"age", null&#41;;)

[//]: # (schema.isValid&#40;human2&#41;; // true)

[//]: # ()
[//]: # (Map<String, Object> human3 = new HashMap<>&#40;&#41;;)

[//]: # (human3.put&#40;"name", ""&#41;;)

[//]: # (human3.put&#40;"age", null&#41;;)

[//]: # (schema.isValid&#40;human3&#41;; // false)

[//]: # ()
[//]: # (Map<String, Object> human4 = new HashMap<>&#40;&#41;;)

[//]: # (human4.put&#40;"name", "Valya"&#41;;)

[//]: # (human4.put&#40;"age", -5&#41;;)

[//]: # (schema.isValid&#40;human4&#41;; // false)
[//]: # (```)
