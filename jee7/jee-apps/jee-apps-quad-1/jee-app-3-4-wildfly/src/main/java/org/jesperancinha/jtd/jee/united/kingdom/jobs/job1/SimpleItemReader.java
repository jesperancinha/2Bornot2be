package org.jesperancinha.jtd.jee.united.kingdom.jobs.job1;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.api.chunk.ItemReader;
import javax.inject.Named;
import java.io.Serializable;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;

@Named
public class SimpleItemReader extends AbstractItemReader {

    @Override
    public Serializable checkpointInfo() throws Exception {
        return 2;
    }

    @Override
    public Object readItem() throws Exception {
        printBlueGenericTitleLn("Starting Read Item");
        return "Some eggs";
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        printBlueGenericTitleLn("Starting Open Read Item");
    }
}
