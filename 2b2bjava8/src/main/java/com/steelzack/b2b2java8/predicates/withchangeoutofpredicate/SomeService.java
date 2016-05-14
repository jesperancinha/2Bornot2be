package com.steelzack.b2b2java8.predicates.withchangeoutofpredicate;

import com.steelzack.b2b2java8.predicates.SomeServiceInterface;
import com.steelzack.b2b2java8.predicates.Something;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by joao on 13-5-16.
 */
@Component
public class SomeService implements SomeServiceInterface {

    @Autowired
    final Set<String> doneWith = new HashSet<>();

    @Override
    public void checkElementAndPlace(Iterable<Something> records, Predicate<Something> shouldNotify) {
        records.forEach(r -> {
            if (shouldNotify.test(r)) {
                doneWith.add(r.getName());
            }
        });
    }
}
