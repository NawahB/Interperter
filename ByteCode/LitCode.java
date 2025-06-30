package ByteCode;

import interpreter.VirtualMachine;
import java.util.List;

public class LitCode extends ByteCode {
    private int value;
    private String id;

    @Override
    public void init(List<String> args) {
        value = Integer.parseInt(args.get(0));
        if (args.size() > 1) id = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushRunStack(value);
    }

    @Override
    public String toString() {
        return (id != null) ? "LIT " + value + " int " + id : "LIT " + value;
    }
}