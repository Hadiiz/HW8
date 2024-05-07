import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<String, Snack> snacks;
    private StateOfVendingMachine currentState;
    private String snackSelection;
    private double moneyInserted;
    private SnackDispenseHandler handlerChain;

    public VendingMachine() {
        snacks = new HashMap<>();
        currentState = new IdleState();
    }

    public void addSnack(Snack snack) {
        snacks.put(snack.getName(), snack);
    }

    public Snack getSnack(String snackName) {
        return snacks.get(snackName);
    }

    public void selectSnack(String snackName) {
        this.snackSelection = snackName;
        currentState.selectSnack(this);
    }

    public void insertMoney(double amount) {
        this.moneyInserted += amount;
        currentState.insertMoney(this);
    }

    public void dispenseSnack() {
        currentState.dispenseSnack(this);
    }

    public void changeState(StateOfVendingMachine newState) {
        currentState = newState;
    }



    public String getSnackSelection() {
        return snackSelection;
    }

    public double getMoneyInserted() {
        return moneyInserted;
    }

    public void resetMachine() {
        moneyInserted = 0;
        snackSelection = null;
        currentState = new IdleState();
    }
}
