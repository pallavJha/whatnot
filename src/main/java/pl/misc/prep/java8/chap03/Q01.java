package pl.misc.prep.java8.chap03;

import pl.misc.prep.java8.Album;
import pl.misc.prep.java8.Artist;
import pl.misc.prep.java8.Track;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author pallav
 * @version 1.0
 * @since 8/7/16
 */

public class Q01 {

    private static final PrintStream out = System.out;
    private static List<Artist> artists = new LinkedList<>();
    private static List<Album> albums = new LinkedList<>();

    private Q01() {
    }


    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        out.println(addUp(numbers.stream()));

        putInArtists(new Artist("ScareCrow", "China", 25));
        putInArtists(new Artist("Pigeon", "India", 25));
        putInArtists(new Artist("Kira", "Japan", 25));
        putInArtists(new Artist("Cat", "India", 25));
        putInArtists(new Artist("Dog", "Myanmar", 25));
        out.println(getNameAndOrigin(getArtists()));

        createAlbumList();
        out.print(getAlbumsWithAtMost3Tracks(getAlbums()));

    }

    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (sum, number) -> sum + number);
    }

    public static List<Artist> getArtists() {
        return artists;
    }

    public static void putInArtists(Artist artist) {
        getArtists().add(artist);
    }

    public static List<Album> getAlbums() {
        return albums;
    }

    public static void createAlbumList() {
        Album album1 = new Album();
        album1.setName("Dark Side Of the Moon");
        album1.getTracks().add(new Track());
        album1.getTracks().add(new Track());
        album1.getTracks().add(new Track());


        Album album2 = new Album();
        album2.setName("The Wall");
        album2.getTracks().add(new Track());
        album2.getTracks().add(new Track());
        album2.getTracks().add(new Track());
        album2.getTracks().add(new Track());


        Album album3 = new Album();
        album3.setName("Animals");
        album3.getTracks().add(new Track());

        putInAlbums(album1);
        putInAlbums(album2);
        putInAlbums(album3);
    }

    public static void putInAlbums(Album album) {
        getAlbums().add(album);
    }

    public static List<String> getNameAndOrigin(List<Artist> artists) {
        return artists.stream()
                .map(artist -> "*" + artist.getName() + " " + artist.getOrigin() + "*")
                .collect(Collectors.toList());
    }

    public static List<Album> getAlbumsWithAtMost3Tracks(List<Album> albumList) {
        return albumList.stream()
                .filter(album -> album.getTracks().size() <= 3)
                .collect(Collectors.toList());
    }
}
