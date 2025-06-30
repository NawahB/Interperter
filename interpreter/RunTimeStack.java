package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {
    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        framePointer.push(0); // main frame starts at 0
    }

    public int peek() {
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    public int push(int value) {
        runTimeStack.add(value);
        return value;
    }

    public int pop() {
        if (runTimeStack.size() <= framePointer.peek()) {
            throw new RuntimeException("Cannot pop beyond current frame.");
        }
        return runTimeStack.remove(runTimeStack.size() - 1);
    }

    public int store(int offset) {
        int top = pop();
        int index = framePointer.peek() + offset;
        runTimeStack.set(index, top);
        return top;
    }

    public int load(int offset) {
        int value = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(value);
        return value;
    }

    public void newFrameAt(int offsetFromTop) {
        int startIndex = runTimeStack.size() - offsetFromTop;
        framePointer.push(startIndex);
    }

    public void popFrame() {
        int returnValue = pop();
        int frameStart = framePointer.pop();
        while (runTimeStack.size() > frameStart) {
            runTimeStack.remove(runTimeStack.size() - 1);
        }
        runTimeStack.add(returnValue); // push return value
    }

    public String verboseDisplay() {
        StringBuilder sb = new StringBuilder();
        int current = 0;
        for (int i = 0; i < framePointer.size(); i++) {
            int next = (i + 1 < framePointer.size()) ? framePointer.get(i + 1) : runTimeStack.size();
            sb.append("[");
            for (int j = framePointer.get(i); j < next; j++) {
                sb.append(runTimeStack.get(j));
                if (j < next - 1) sb.append(",");
            }
            sb.append("] ");
        }
        return sb.toString().trim();
    }
}
