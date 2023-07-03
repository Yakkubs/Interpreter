package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public interface ByteCode {

    static ByteCode getNewInstance(String type, String[] args){
        return switch (type) {
            case "HALT" -> new HaltCode(args);
            case "POP" -> new Pop(args);
            case "FALSEBRANCH" -> new FalseBranch(args);
            case "GOTO" -> new Goto(args);
            case "STORE" -> new Store(args);
            case "LOAD" -> new Load(args);
            case "LIT" -> new LitCode(args);
            case "ARGS" -> new Args(args);
            case "CALL" -> new Call(args);
            case "RETURN" -> new Return(args);
            case "BOP" -> new Bop(args);
            case "READ" -> new Read(args);
            case "WRITE" -> new Write(args);
            case "LABEL" -> new Label(args);
            case "DUMP" -> new Dump(args);
            default -> throw new IllegalArgumentException();
        };
    }
    void execute(VirtualMachine vm);
}
