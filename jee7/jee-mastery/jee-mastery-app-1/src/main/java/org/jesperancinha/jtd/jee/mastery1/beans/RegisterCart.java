package org.jesperancinha.jtd.jee.mastery1.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Session scoped need always to be Serializable
 */
@Named
@SessionScoped
public class RegisterCart implements Serializable {


    private List<Record> allRecords;

    private Record newRecord;

    RegisterCart(){
        this.allRecords = new ArrayList<>();
        this.newRecord = new Record();
    }

    public void setNewRecord(Record newRecord) {
        this.newRecord = newRecord;
    }

    public Record getNewRecord() {
        return newRecord;
    }
}
