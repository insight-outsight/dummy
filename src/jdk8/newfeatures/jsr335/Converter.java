package jdk8.newfeatures.jsr335;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}