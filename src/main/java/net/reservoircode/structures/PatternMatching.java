package net.reservoircode.structures;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@FunctionalInterface
public interface PatternMatching<T, R> {

    Optional<R> matches(T value);

    static <T, R> PatternMatching<T, R> when(
            Predicate<T> predicate,
            Function<T, R> action) {

        return value -> predicate.test(value) ? of(action.apply(value)) : empty();
    }

    default PatternMatching<T, R> orWhen(
            Predicate<T> predicate,
            Function<T, R> action) {

        return value -> {
            final Optional<R> result = matches(value);

            if (result.isPresent()) {
                return result;
            }
            return (predicate.test(value)) ?
                    of(action.apply(value)) : empty();
        };
    }
}