import java.util.Objects;

public final class Person {
    private final String name;
    private final long info;

    public Person(){
        this.name = "Default";
        this.info = 1;
    }

    public Person(String name, long info) {
        this.name = name;
        this.info = info;
    }

    // how you're supposed to implement equals
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Person that = (Person) other;
        return (this.name.equals(that.name)) && (this.info == that.info);
    }

    public String toString() {
        return name + " " + info;
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, name);
    }


}