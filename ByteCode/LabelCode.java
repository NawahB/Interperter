package ByteCode;

import interpreter.VirtualMachine;
import java.util.List;

public class LabelCode extends ByteCode {
    private String label;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        // No operation needed
    }

    @Override
    public String toString() {
        return "LABEL " + label;
    }

    public String getLabel() {
        return label;
    }
}
