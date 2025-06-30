package ByteCode;

import interpreter.VirtualMachine;
import java.util.List;

public class StoreCode extends ByteCode {
    private int offset;
    private String id;
    private int storedValue;

    @Override
    public void init(List<String> args) {
        offset = Integer.parseInt(args.get(0));
        if (args.size() > 1) id = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
        storedValue = vm.storeRunStack(offset);
    }

    @Override
    public String toString() {
        return (id != null) ? "STORE " + offset + " " + id + " " + id + "=" + storedValue : "STORE " + offset;
    }
}