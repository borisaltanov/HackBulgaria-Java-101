package com.parser;

import com.listify.Listify;

class Parser {
    public static void main(String[] args) {
/*        String[] content = Listify.readToArray("com/parser/test.ini");

        for (String line: content) {
            System.out.println(line);
        }*/
        System.out.println(parseContent("com/parser/test.ini"));
    }

    public static String[] parseContent(String path) {
        String[] content = Listify.readToArray(path);
        String[] result = new String[content.length + 3];
        int row = 0;
        result[row] = "{";

        for (int i = 0; i < content.length; i++) {
            String line = content[i];
            if (line.startsWith("[") && line.endsWith("]")) {
                row++;
                line = line.substring(1, line.length() - 1);
                result[row] = "  \"" + line + "\" {";
            } else if (!line.isEmpty()) {
                row++;
                line = line.trim();
                line = line.replaceAll("\\s*=\\s*", "\": \"");
                if (content[i+1].isEmpty()) {
                    result[row] = "    \"" + line + "\"\n  }";
                } else {
                    result[row] = "    \"" + line + "\",";
                }
            }
        }
        row++;
        result[row] = "}";

        for (String line: result) {
            System.out.println(line);
        }

        return new String[] {"asd", "dsf"};
    }
}


//TODO stack
