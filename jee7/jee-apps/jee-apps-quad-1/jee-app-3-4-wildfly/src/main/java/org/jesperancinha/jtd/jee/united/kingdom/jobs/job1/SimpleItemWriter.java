package org.jesperancinha.jtd.jee.united.kingdom.jobs.job1;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
public class SimpleItemWriter extends AbstractItemWriter {

    @Override
    public void writeItems(List<Object> items) throws Exception {
        Consolerizer.printBlueGenericTitleLn("Starting Write Items");
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        Consolerizer.printBlueGenericTitleLn("Starting Open Write Item");
    }

    @Override
    public void close() throws Exception {
        Consolerizer.printBlueGenericTitleLn("Job closing");
    }
}
