class Locker {
    private String combinationCode;
    private final int lockerNumber;

    public Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (combinationCode.equals(currentCode)) {
            combinationCode = newCode;
            System.out.println("Code changed successfully");
            return true;
        }
        System.out.println("Code change rejected: incorrect current code");
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class Problem4_TheLockerCode {
    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        locker.changeCode("1234", "5678");
        locker.changeCode("0000", "9999");
    }
}