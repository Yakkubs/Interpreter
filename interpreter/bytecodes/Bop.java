package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class Bop implements ByteCode {
    private String operator;
    public Bop(String[] args) {
        this.operator = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        int rightOperand = vm.pop();
        int leftOperand = vm.pop();
        switch (this.operator) {
            case "+" -> vm.push(leftOperand + rightOperand);
            case "-" -> vm.push(leftOperand - rightOperand);
            case "/" -> vm.push(leftOperand / rightOperand);
            case "*" -> vm.push(leftOperand * rightOperand);
            case "==" -> vm.push((leftOperand == rightOperand) ? 1 : 0);
            case "!=" -> vm.push((leftOperand != rightOperand) ? 1 : 0);
            case "<=" -> vm.push((leftOperand <= rightOperand) ? 1 : 0);
            case "<" -> vm.push((leftOperand < rightOperand) ? 1 : 0);
            case ">=" -> vm.push((leftOperand >= rightOperand) ? 1 : 0);
            case ">" -> vm.push((leftOperand > rightOperand) ? 1 : 0);
            case "&" -> vm.push((leftOperand == 1) && (rightOperand == 1) ? 1 : 0);
            case "|" -> vm.push((leftOperand == 1) || (rightOperand == 1) ? 1 : 0);
            //push 0 in to the stack if operator is not valid
            default -> vm.push(0);
        }

    }
    @Override
    public String toString() {
        return "BOP " + operator;
    }
}
