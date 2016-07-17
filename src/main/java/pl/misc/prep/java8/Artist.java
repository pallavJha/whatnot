package pl.misc.prep.java8;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pallav
 * @version 1.0
 * @since 8/7/16
 */

public class Artist {

    private String name;

    private String origin;

    private int age;

    private Set<Artist> members = new HashSet<>();

    public Artist() {

    }

    public Artist(String name, String origin, int age){
        this.name = name;
        this.origin = origin;
        this.age = age;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Artist> getMembers() {
        return members;
    }

    public void setMembers(Set<Artist> members) {
        this.members = members;
    }
}

