package ByteCode;

import interpreter.VirtualMachine;
import java.util.List;

public class HaltCode extends ByteCode {
    @Override
    public void init(List<String> args) {
        // No arguments needed
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.halt();
    }

    @Override
    public String toString() {
        return ""; // Not shown in VERBOSE mode
    }
}
