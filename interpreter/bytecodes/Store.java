package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class Store implements ByteCode {
    private int offset;
    private String id;
    private int valStored;
    public Store(String[] args) {
        this.offset = Integer.parseInt(args[1]);
        if(args.length > 2){
            this.id = args[2];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        this.valStored = vm.store(this.offset);
    }

    @Override
    public String toString() {
        String base = "STORE " + this.offset;
        if(this.id != null){
            base += " " + this.id + "\t" + this.id +"=" + this.valStored;
        }
        return base;
    }
}
