import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Quine {
    public static String getDeclaredFields(Class<?> cl){
        StringBuilder fields = new StringBuilder();
        for (Field f : cl.getDeclaredFields()) {
            String field = f.toString().replaceAll("java.lang.","").replaceAll(cl.getName() + ".","");
            fields.append("\t").append(field).append("\n");
        }
        return fields.toString();
    }
    public static String sourceCode(Class<?> cl){
        String sourceCode = cl.toGenericString() + " {\n" +
                getDeclaredFields(cl) +
                "\n}";
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
