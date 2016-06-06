package fr.wd.kata.business.domain.type;

public enum FooBarQixEnum {
    FOO("Foo", 3, '3'),
    BAR("Bar", 5, '5'),
    QIX("Qix", 7, '7');

    private String value;

    private Integer multiple;

    private char position;

    FooBarQixEnum(String value, Integer multiple, char position) {
        this.value = value;
        this.multiple = multiple;
        this.position = position;
    }

    public String getValue() {
        return value;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public char getPosition() {
        return position;
    }
}
