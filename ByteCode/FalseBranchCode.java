package ByteCode;

import interpreter.VirtualMachine;
import java.util.List;

public class FalseBranchCode extends ByteCode {
    private String label;
    private int targetAddress;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    public void setTargetAddress(int address) {
        this.targetAddress = address;
    }

    @Override
    public void execute(VirtualMachine vm) {
        int condition = vm.popRunStack();
        if (condition == 0) {
            vm.setProgramCounter(targetAddress);
        }
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + label;
    }

    public String getLabel() {
        return label;
    }
}
