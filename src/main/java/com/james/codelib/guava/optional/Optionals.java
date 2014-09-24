package com.james.codelib.guava.optional;

import com.google.common.base.Function;
import com.google.common.base.Optional;

/**
 * Created by james on 9/22/14.
 */
public class Optionals {
    public static <T, U> Optional<U> bind(Optional<T> value,
                                          Function<T, Optional<U>> function) {
        if (value.isPresent()) {
            return function.apply(value.get());
        }

        return Optional.absent();
    }

    private Optionals() {}
}
