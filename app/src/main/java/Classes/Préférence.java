package Classes;

/**
 * Created by AspireV on 2018-03-09.
 */

public class Préférence {
    private OuiNon music ;
    private OuiNon cigarette ;
    private OuiNon discussion ;

    public Préférence(OuiNon music ,OuiNon cigarette , OuiNon discussion) {
        this.music = music; this.cigarette=cigarette ; this.discussion=discussion ;
    }

    public OuiNon getMusic() {
        return music;
    }
    public void setMusic(OuiNon music ) {
        this.music=music;
    }

    public OuiNon getCigarette() {
        return cigarette;
    }
    public void setCigarette(OuiNon cigarette ) {
        this.cigarette=cigarette ;
    }

    public OuiNon getDiscussion() {
        return discussion;
    }
    public void setDiscussion(OuiNon discussion ) {
        this.discussion=discussion ;
    }
}
