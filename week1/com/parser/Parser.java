package com.parser;

import com.listify.Listify;

class Parser {
    public static void main(String[] args) {
        String path = "com/parser/test.ini";
        String [] content = Listify.readToArray(path);

        Boolean isInObject = false;
        Boolean isLastKV = false;

        System.out.println("{");
        for(String line: content) {
            if (isEmpty(line)) {
                if (isInObject) {
                    System.out.println("\n  },");
                    isInObject = false;
                }
                isLastKV = false;
            }
            else if (isObject(line)) {
                if (isInObject) {
                    System.out.println("\n  },");
                }
                System.out.println(getObject(line));
                isInObject = true;
                isLastKV = false;
            }
            else if (isKV(line)) {
                if (isLastKV) {
                    System.out.println(",");
                }
                System.out.print(getKV(line));
                isLastKV = true;
            }
        }
        System.out.println("\n  }\n}");

    }

    public static Boolean isObject(String line) {
        return line.startsWith("[") && line.endsWith("]");
    }

    public static Boolean isKV(String line) {
        return line.contains("=");
    }

    public static Boolean isEmpty(String line) {
        return line.isEmpty();
    }

    public static String getObject(String line) {
        line = line.substring(1, line.length() - 1);
        line = line.trim();
        return "  \"" + line + "\" {";
    }

    public static String getKV(String line) {
        int equalSign = line.indexOf("=");
        String key = line.substring(0, equalSign);
        String value = line.substring(equalSign + 1, line.length());
        key = key.trim();
        value = value.trim();
        return "    \"" + key + "\": \"" + value + "\"";
    }


}
