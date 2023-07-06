package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.Arrays;

public class Return implements ByteCode {
    private String label;
    private int returnVal;

    public Return(String[] args) {
        //in case of no arguments
        if(args.length == 2){
            this.label = args[1];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        returnVal = vm.pop();
        vm.popFrame();
        vm.push(returnVal);
        vm.setProgramCounter(vm.popReturnAddress());
    }

    @Override
    public String toString() {
        String base = "RETURN";
        if(label != null){
            base += " " + label + " EXIT ";
            String[] split = label.split("<");
            base += split[0] + " : " + returnVal;
        }
        return base;
    }
}
