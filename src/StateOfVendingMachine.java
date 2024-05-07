
public interface StateOfVendingMachine {
    void selectSnack(VendingMachine machine);
    void insertMoney(VendingMachine machine);
    void dispenseSnack(VendingMachine machine);
}
class IdleState implements StateOfVendingMachine {
    @Override
    public void selectSnack(VendingMachine machine) {
        if (machine.getSnackSelection() != null && machine.getSnack(machine.getSnackSelection()) != null) {
            System.out.println("Snack selected: " + machine.getSnackSelection());
            machine.changeState(new WaitingForMoneyState());
        } else {
            System.out.println("Please select a valid snack.");
        }
    }

    @Override
    public void insertMoney(VendingMachine machine) {
        System.out.println("Please select a snack first.");
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        System.out.println("No snack selected and money inserted.");
    }
}
class WaitingForMoneyState implements StateOfVendingMachine {
    @Override
    public void selectSnack(VendingMachine machine) {
        System.out.println("Snack already selected, please insert money.");
    }

    @Override
    public void insertMoney(VendingMachine machine) {
        Snack selectedSnack = machine.getSnack(machine.getSnackSelection());
        if (selectedSnack != null) { // Check if the selected snack is not null
            if (machine.getMoneyInserted() >= selectedSnack.getPrice()) {
                System.out.println("Money inserted: $" + machine.getMoneyInserted());
                machine.changeState(new DispensingSnackState());
            } else {
                System.out.println("Not enough money inserted. Please insert at least $" + selectedSnack.getPrice());
            }
        } else {
            System.out.println("Invalid snack selection. Please select a valid snack.");
        }
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        System.out.println("Please insert enough money to purchase the snack.");
    }
}

class DispensingSnackState implements StateOfVendingMachine {
    @Override
    public void selectSnack(VendingMachine machine) {
        System.out.println("Dispensing in progress, please wait.");
    }

    @Override
    public void insertMoney(VendingMachine machine) {
        System.out.println("Already inserted enough money.");
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        Snack selectedSnack = machine.getSnack(machine.getSnackSelection());
        if (selectedSnack != null && selectedSnack.canDispense(machine.getMoneyInserted())) {
            System.out.println("Dispensing: " + selectedSnack.getName());
            selectedSnack.setQuantity(selectedSnack.getQuantity() - 1);
            double remainingBalance = machine.getMoneyInserted() - selectedSnack.getPrice();
            System.out.println("Collect your snack. Remaining balance: $" + remainingBalance);
            // Update the machine's money tracker directly
            machine.resetMachine();  // Resets the machine state to Idle after dispensing
        } else {
            System.out.println("Error in dispensing. Please try again or contact support.");
            machine.resetMachine();
        }
    }
}

