package interpreter;

import ByteCode.*;
import java.util.Stack;

public class VirtualMachine {
    private RunTimeStack runStack = new RunTimeStack();
    private Stack<Integer> returnAddress = new Stack<>();
    private Program program;
    private int programCounter = 0;
    private boolean isRunning = true;
    private boolean isVerbose = false;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            if (isVerbose) {
                System.out.println(code);
                System.out.println(runStack.verboseDisplay());
            }
            programCounter++;
        }
    }

    public void halt() {
        isRunning = false;
    }

    public int popRunStack() {
        return runStack.pop();
    }

    public int pushRunStack(int i) {
        return runStack.push(i);
    }

    public int storeRunStack(int offset) {
        return runStack.store(offset);
    }

    public int loadRunStack(int offset) {
        return runStack.load(offset);
    }

    public void newFrame(int numArgs) {
        runStack.newFrameAt(numArgs);
    }

    public void setProgramCounter(int pc) {
        programCounter = pc - 1;
    }

    public void saveReturnAddress() {
        returnAddress.push(programCounter);
    }

    public void returnFromCall() {
        programCounter = returnAddress.pop();
        runStack.popFrame();
    }

    public void setVerbose(boolean flag) {
        isVerbose = flag;
    }
}
