package pl.misc.design.patterns.creational.factory;

/**
 * @author Pallav Jha
 * @since 20/5/18
 */
public class Software {

    private String name;

    private String category;

    private boolean free;

    private Software(SoftwareBuilder softwareBuilder) {
        this.name = softwareBuilder.name;
        this.category = softwareBuilder.category;
        this.free = softwareBuilder.free;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isFree() {
        return free;
    }

    static class SoftwareBuilder {
        private String name;

        private String category;

        private boolean free;

        public SoftwareBuilder(String name, String category) {
            this.name = name;
            this.category = category;
        }

        public SoftwareBuilder setFree(boolean free) {
            this.free = free;
            return this;
        }

        public Software build() {
            return new Software(this);
        }
    }
}
