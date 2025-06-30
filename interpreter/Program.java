package interpreter;

import ByteCode.*;
import java.util.*;

public class Program {
    private ArrayList<ByteCode> program = new ArrayList<>();
    private HashMap<String, Integer> labelMap = new HashMap<>();

    public void addCode(ByteCode code) {
        program.add(code);
    }

    public ByteCode getCode(int pc) {
        return program.get(pc);
    }

    public void resolveAddresses() {
        for (int i = 0; i < program.size(); i++) {
            if (program.get(i) instanceof LabelCode) {
                LabelCode labelCode = (LabelCode) program.get(i);
                labelMap.put(labelCode.getLabel(), i);
            }
        }
        for (ByteCode code : program) {
            if (code instanceof GotoCode) {
                ((GotoCode) code).setTargetAddress(labelMap.get(((GotoCode) code).getLabel()));
            } else if (code instanceof CallCode) {
                ((CallCode) code).setTargetAddress(labelMap.get(((CallCode) code).getLabel()));
            } else if (code instanceof FalseBranchCode) {
                ((FalseBranchCode) code).setTargetAddress(labelMap.get(((FalseBranchCode) code).getLabel()));
            }
        }
    }
}

// interpreter/CodeTable.java
package interpreter;