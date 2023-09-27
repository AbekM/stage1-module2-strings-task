package com.epam.mjc;

import com.epam.mjc.MethodSignature.Argument;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        List<Argument> arguments = new ArrayList<>();
        String methodName = null;
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(signatureString, "()");
        while (st.hasMoreTokens()) {
         tokens.add(st.nextToken());
        }
        String st1 = tokens.get(0);
        List<String> list1 = List.of(st1.split(" "));
        if (tokens.size() == 2) {
            String st2 = tokens.get(1);
            List<String> list2 = List.of(st2.split(", "));
            for (String s : list2) {
                List<String> p = List.of(s.split(" "));
                arguments.add(new Argument(p.get(0), p.get(1)));
            }
            System.out.println("hi mom");
        }



        if (list1.size() == 2) {
            methodName = list1.get(1);
        } else {
            methodName = list1.get(2);
        }

        MethodSignature ms = new MethodSignature(methodName, arguments);
        if (list1.size() == 2) {
            ms.setReturnType(list1.get(0));
        } else  {
            ms.setReturnType(list1.get(1));
            ms.setAccessModifier(list1.get(0));
        }
        return ms;
    }
}
