package com.steelzack.b2b2java8.predicates.withchangeoutofpredicate;

import com.steelzack.b2b2java8.predicates.PredicateInterface;
import com.steelzack.b2b2java8.predicates.Something;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by joao on 13-5-16.
 */
@Component
public class PredicateMain implements PredicateInterface {
    final private SomeService someService = new SomeService();

    final private Set<String> recipients = new HashSet<>();
    final private Set<String> doneWith = new HashSet<>();

    @Override
    public void doThePredicateMethod(Iterable<Something> records) {
        someService.checkElementAndPlace(records,
                PredicateCustom.builder().listToFind(recipients).build()
                        .and(PredicateCustom.builder().listToFind(doneWith).build())
        );
        recipients.addAll(doneWith);
    }

}
