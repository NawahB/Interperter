package ByteCode;

import java.util.List;
import interpreter.VirtualMachine;

public abstract class ByteCode {
    public abstract void init(List<String> args);
    public abstract void execute(VirtualMachine vm);
    public abstract String toString(); // For VERBOSE mode
}
