package pl.misc.prep.java8.chap03;

import pl.misc.prep.java8.Artist;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author pallav
 * @version 1.0
 * @since 8/7/16
 */
public class Q02 {

    private static List<Artist> artists = null;

    public static void main(String... args) {
        artists = getArtists();
        System.out.print(getMembersCount(artists));
    }

    public static List<Artist> getArtists() {
        Artist a1 = new Artist("one", "two", 12);
        a1.setMembers(getMembers(5));

        Artist a2 = new Artist("three", "four", 25);
        a2.setMembers(getMembers(2));

        Artist a3 = new Artist("five", "six", 14);
        a3.setMembers(getMembers(10));

        Artist a4 = new Artist("seven", "eight", 22);
        a4.setMembers(getMembers(3));

        artists = new LinkedList<>();
        artists.add(a1);
        artists.add(a2);
        artists.add(a3);
        artists.add(a4);
        return artists;
    }

    public static Set<Artist> getMembers(int membersCount) {
        Set<Artist> members = new HashSet<>();
        for (int i = 0; i < membersCount; i++) {
            Artist a = new Artist("Name" + i, "Origin" + i, 45 - i);
            members.add(a);
        }
        return members;
    }

    public static long getMembersCount(List<Artist> artists){
        return artists.stream()
                .map(artist -> artist.getMembers().size())
                .reduce(0, (sum, memberCount) -> sum + memberCount);
    }
}