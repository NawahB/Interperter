package ByteCode;

import interpreter.VirtualMachine;
import java.util.List;

public class ReturnCode extends ByteCode {
    @Override
    public void init(List<String> args) {}

    @Override
    public void execute(VirtualMachine vm) {
        vm.returnFromCall();
    }

    @Override
    public String toString() {
        return "RETURN";
    }
}
