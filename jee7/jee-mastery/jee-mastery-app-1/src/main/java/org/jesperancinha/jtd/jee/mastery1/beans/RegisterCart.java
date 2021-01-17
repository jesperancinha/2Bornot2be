package org.jesperancinha.jtd.jee.mastery1.beans;

import org.jesperancinha.jtd.jee.mastery1.domain.StoreRecord;
import org.jesperancinha.jtd.jee.mastery1.domain.StoreRecordManagedDao;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Session scoped need always to be Serializable
 */
@Named
@SessionScoped
public class RegisterCart implements Serializable {

    @Inject
    private StoreRecordManagedDao storeRecordManagedDao;

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

    public void saveRecord(){
        final StoreRecord album = new StoreRecord();
        album.setId(UUID.randomUUID());
        album.setArtist(newRecord.getArtist());
        album.setName(newRecord.getName());
        album.setYear(newRecord.getYear());
        storeRecordManagedDao.createAlbum(album);
    }
}
