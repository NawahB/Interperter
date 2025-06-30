package interpreter;

import java.util.HashMap;

public class CodeTable {
    private static HashMap<String, String> codeTable = new HashMap<>();

    public static void init() {
        codeTable.put("HALT", "ByteCode.HaltCode");
        codeTable.put("POP", "ByteCode.PopCode");
        codeTable.put("LIT", "ByteCode.LitCode");
        codeTable.put("STORE", "ByteCode.StoreCode");
        codeTable.put("LOAD", "ByteCode.LoadCode");
        codeTable.put("ARGS", "ByteCode.ArgsCode");
        codeTable.put("CALL", "ByteCode.CallCode");
        codeTable.put("RETURN", "ByteCode.ReturnCode");
        codeTable.put("GOTO", "ByteCode.GotoCode");
        codeTable.put("FALSEBRANCH", "ByteCode.FalseBranchCode");
        codeTable.put("LABEL", "ByteCode.LabelCode");
        codeTable.put("VERBOSE", "ByteCode.VerboseCode");
    }

    public static String getClassName(String code) {
        return codeTable.get(code);
    }
}
