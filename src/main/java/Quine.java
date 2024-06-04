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

    private static String constructorWithArgName(String c, String parameters){
        parameters = parameters.replace(",","");
        StringBuilder stringBuilder = new StringBuilder(parameters);
        stringBuilder.deleteCharAt(0).deleteCharAt(stringBuilder.length()-1);

        String[] parameterAndType = stringBuilder.toString().split(" ");
        for (int i = 0; i < parameterAndType.length - 1; i += 2){
            String type = parameterAndType[i];
            String argName = parameterAndType[i+1];
            c = c.replaceAll(type, type + " " +  argName);
        }
        return getDefault(c);
    }
    public static String getConstructor(Class<?> cl){
        StringBuilder constructors = new StringBuilder();
        for (Constructor c : cl.getConstructors()){
            String constructor = constructorWithArgName(c.toString(),Arrays.toString(c.getParameters()));
            constructors.append("\t").append(constructor).append("\n");
        }
        return constructors.toString();
    }
    public static String sourceCode(Class<?> cl){
        String sourceCode = cl.toGenericString() + " {\n" +
                getDeclaredFields(cl) +
                getConstructor(cl) +
                "\n}";
        return sourceCode;

    }
}
