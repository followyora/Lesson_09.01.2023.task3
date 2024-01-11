import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        printMethodList(new ArrayList<>());
        System.out.println("---------");
        printMethodList(new LinkedList<>());
        System.out.println("---------");
        printMethodList(List.of());
    }

    private static void printMethodList(List<String> stringList) {
        Class<List<String>> clazz = (Class<List<String>>) stringList.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            String returnType = method.getReturnType().getSimpleName();
            List<String> inputTypes = Arrays.stream(method.getParameterTypes()).map(Class::getSimpleName).toList();
            List<String> exceptionTypes = Arrays.stream(method.getExceptionTypes()).map(Class::getSimpleName).toList();
            System.out.printf("Method %s, Return %s, Params %s, Exceptions %s %n", name, returnType, inputTypes, exceptionTypes);

        }
    }
}