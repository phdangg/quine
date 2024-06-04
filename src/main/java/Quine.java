import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Quine {
    public static String sourceCode(Class<?> cl){
        String sourceCode = cl.toGenericString() + "{\n" +
                "}";
        return sourceCode;

//        for (Field f : cl.getDeclaredFields()){
//            System.out.println(f);
//        }
//        while (cl != null) {
//            for (Method m : cl.getDeclaredMethods()) {
//                System.out.println(
//                    Modifier.toString(m.getModifiers()) + " " +
//                            m.getReturnType().getCanonicalName() + " " +
//                            m.getName() +
//                            Arrays.toString(m.getParameters()));
//            }
//            cl = cl.getSuperclass();
//        }

    }
}
