package ByteCode;

import interpreter.VirtualMachine;
import java.util.List;

public class VerboseCode extends ByteCode {
    private String mode;

    @Override
    public void init(List<String> args) {
        mode = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setVerbose("ON".equals(mode));
    }

    @Override
    public String toString() {
        return "VERBOSE " + mode;
    }
}
