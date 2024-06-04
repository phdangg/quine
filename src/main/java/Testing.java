public class Testing {
    public static void main(String[] args) {
        Class<?> cl = Person.class;
        System.out.println(Quine.sourceCode(Person.class));
    }
}
