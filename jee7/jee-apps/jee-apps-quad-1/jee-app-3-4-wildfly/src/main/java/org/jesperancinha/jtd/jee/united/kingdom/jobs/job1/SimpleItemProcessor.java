package org.jesperancinha.jtd.jee.united.kingdom.jobs.job1;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class SimpleItemProcessor implements ItemProcessor {
    @Override
    public Object processItem(Object item) throws Exception {
        Consolerizer.printBlueGenericTitleLn("Starting Process Item");

        return item;
    }

}
