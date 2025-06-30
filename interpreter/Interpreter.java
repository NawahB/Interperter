package interpreter;

public class Interpreter {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java interpreter.Interpreter <x.cod file>");
            System.exit(1);
        }

        String byteCodeFile = args[0];
        try {
            ByteCodeLoader loader = new ByteCodeLoader(byteCodeFile);
            Program program = loader.loadCodes();
            VirtualMachine vm = new VirtualMachine(program);
            vm.executeProgram();
        } catch (Exception e) {
            System.out.println("Error running interpreter: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
