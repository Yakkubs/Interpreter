package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class Write implements ByteCode {
    public Write(String[] args) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek());
    }
    @Override
    public String toString() {
        return "WRITE";
    }
}
