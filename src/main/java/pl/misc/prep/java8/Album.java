package pl.misc.prep.java8;

import java.util.LinkedList;
import java.util.List;

/**
 * <h1>FeedServiceImpl</h1>
 *
 * @author pallav
 * @version 1.0
 * @since 8/7/16
 */
public class Album {

    private String name;

    private List<Track> tracks = new LinkedList<>();

    private List<Artist> musicians = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }
}
