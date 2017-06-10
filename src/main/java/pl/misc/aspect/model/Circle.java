package pl.misc.aspect.model;

import pl.misc.aspect.aspects.annotations.Rollable;

public class Circle {

    private String name;

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        System.out.println("Circle#setName has been called.");
        return "Lalala";
    }


    @Rollable
    public void rollCircleRoll() {
        System.out.println(this + "is rolling");
    }
}
