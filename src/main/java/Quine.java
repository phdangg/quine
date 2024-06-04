import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Quine {
    public static void showSourceCode(String className){
        try {
            Class<?> cl = Class.forName(className);
            while (cl != null) {
                for (Method m : cl.getDeclaredMethods()) {
                    System.out.println(
                            Modifier.toString(m.getModifiers()) + " " +
                                    m.getReturnType().getCanonicalName() + " " +
                                    m.getName() +
                                    Arrays.toString(m.getParameters()));
                }
                cl = cl.getSuperclass();
            }

        }
        catch (ClassNotFoundException e){
            System.out.println(e);
        }
    }
}
