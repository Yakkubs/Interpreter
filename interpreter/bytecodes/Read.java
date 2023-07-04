package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.Scanner;

public class Read implements ByteCode {
    public Read(String[] args) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        while(!valid){
            try {
                System.out.println("Please enter an integer: ");
                int userInput = scanner.nextInt();
                vm.push(userInput);
                valid = true;
            } catch (Exception e) {
                System.out.println("Invaid input!");
                scanner.nextLine();
            }
        }
    }

    @Override
    public String toString() {
        return "READ";
    }
}
