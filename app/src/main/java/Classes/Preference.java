package Classes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

/**
 * Created by AspireV on 2018-03-09.
 */

@Entity(tableName = "preference")
public class Preference {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_preference")
    private int id_preference;

    @NonNull
    @ColumnInfo(name = "music")
    private String music ;

    @NonNull
    @ColumnInfo(name = "cigarette")
    private String cigarette ;

    @NonNull
    @ColumnInfo(name = "discussion")
    private String discussion ;

    @Ignore
    public Preference(String music, String cigarette, String discussion) {
        this.music = music;
        this.cigarette = cigarette;
        this.discussion = discussion;
    }

    public Preference() {
    }


    public void setId_preference(int id_preference) {
        this.id_preference = id_preference;
    }

    public int getId_preference() {
        return id_preference;
    }

    public String getMusic() {
        return music;
    }

    public String getCigarette() {
        return cigarette;
    }

    public String getDiscussion() {
        return discussion;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public void setCigarette(String cigarette) {
        this.cigarette = cigarette;
    }

    public void setDiscussion(String discussion) {
        this.discussion = discussion;
    }
}
