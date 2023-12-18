package com.example.rsqldemo.business;

import java.util.Objects;
import java.util.Optional;

class Bic {

    private String value;

    private Bic(String value) {
        this.value = value;
    }

    public static Bic of(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException();
        }
        return new Bic(value);
    }

    public static Optional<Bic> ofFailSafe(String value) {
        if (!isValid(value)) {
            return Optional.empty();
        }
        return Optional.of(new Bic(value));
    }

    private static boolean isValid(String val) {
        return val.startsWith("A");
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bic bic = (Bic) o;
        return Objects.equals(value, bic.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }

    //some business methods...
}
