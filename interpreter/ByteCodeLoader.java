package interpreter;

import ByteCode.*;
import java.io.*;
import java.util.*;

public class ByteCodeLoader {
    private BufferedReader reader;

    public ByteCodeLoader(String fileName) throws IOException {
        reader = new BufferedReader(new FileReader(fileName));
    }

    public Program loadCodes() throws Exception {
        CodeTable.init();
        Program program = new Program();
        String line;
        while ((line = reader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            String code = st.nextToken();
            String className = CodeTable.getClassName(code);
            Class<?> byteCodeClass = Class.forName(className);
            ByteCode byteCode = (ByteCode) byteCodeClass.getDeclaredConstructor().newInstance();
            List<String> args = new ArrayList<>();
            while (st.hasMoreTokens()) {
                args.add(st.nextToken());
            }
            byteCode.init(args);
            program.addCode(byteCode);
        }
        program.resolveAddresses();
        return program;
    }
}
