package interpreter.bytecodes;

public interface JumpCode {
    void setTarget(int integer);

    String getLabel();
}
