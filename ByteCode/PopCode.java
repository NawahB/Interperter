package ByteCode;

import interpreter.VirtualMachine;
import java.util.List;

public class PopCode extends ByteCode {
    private int times;

    @Override
    public void init(List<String> args) {
        this.times = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        for (int i = 0; i < times; i++) {
            vm.popRunStack(); // must handle frame boundary internally
        }
    }

    @Override
    public String toString() {
        return "POP " + times;
    }
}
