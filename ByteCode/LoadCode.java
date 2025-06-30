package ByteCode;

import interpreter.VirtualMachine;
import java.util.List;

public class LoadCode extends ByteCode {
    private int offset;
    private String id;

    @Override
    public void init(List<String> args) {
        offset = Integer.parseInt(args.get(0));
        if (args.size() > 1) id = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.loadRunStack(offset);
    }

    @Override
    public String toString() {
        return (id != null) ? "LOAD " + offset + " <load " + id + ">" : "LOAD " + offset;
    }
}
