package com.steelzack.b2b2java8.predicates.withchangeinpredicate;

import com.steelzack.b2b2java8.predicates.PredicateInterface;
import com.steelzack.b2b2java8.predicates.Something;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by joao on 13-5-16.
 */
@Component
public class PredicateMain  implements PredicateInterface {
    final private SomethingService somethingService = new SomethingService();

    final private Set<String> recipients = new HashSet<>();
    final private Set<String> doneWith = new HashSet<>();

    @Override
    public void doThePredicateMethod(Iterable<Something> records) {
        somethingService.checkElementAndPlace(records, PredicateCustom.builder().doneWith(doneWith).recipients(recipients).build());
        recipients.addAll(doneWith);
    }


}
