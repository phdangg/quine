import java.lang.reflect.*;
import java.util.*;

public class Quine {
    private static String getDefault(String s, Class<?> cl){
        String className = "";
        if (cl != null){
            className = cl.getName();
            s = s.replaceAll(className + ".","");
        }
        return s.replaceAll("java.lang.","");
    }
    private static String getDefault(String s){
        return getDefault(s,null);
    }

    public static String getDeclaredFields(Class<?> cl){
        StringBuilder fields = new StringBuilder();
        for (Field f : cl.getDeclaredFields()) {
            String field = getDefault(f.toString(),cl);
            fields.append("\t").append(field).append("\n");
        }
        return fields.toString();
    }

    private static List<Map<String,String>> getArgNameAndType(String parameters){
        StringBuilder stringBuilder = new StringBuilder(parameters);
        stringBuilder.deleteCharAt(0).deleteCharAt(stringBuilder.length()-1);
        List<Map<String,String>> result = new ArrayList<>();
        String[] parameterAndType = stringBuilder.toString().split(" ");
        for (int i = 0; i < parameterAndType.length - 2; i += 2){
            String type = parameterAndType[i];
            String argName = parameterAndType[i+1];
            result.add(Collections.singletonMap(argName,type));
        }
        return result;
    }
    public static String getConstructor(Class<?> cl){
        StringBuilder constructors = new StringBuilder();
        for (Constructor c : cl.getConstructors()){
            String constructor = c.toString();
            getArgNameAndType(Arrays.toString(c.getParameters()));

            StringBuilder parameters = new StringBuilder();
            for (Parameter p : c.getParameters()){
                parameters.append(p.getType()).append("\n");
            }
            constructors.append("\t").append(constructor).append("\n").append(parameters);
        }
        return constructors.toString();
    }
    public static String sourceCode(Class<?> cl){
        String sourceCode = cl.toGenericString() + " {\n" +
                getDeclaredFields(cl) +
                getConstructor(cl) +
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
