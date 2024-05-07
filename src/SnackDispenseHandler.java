public abstract class SnackDispenseHandler {
    protected SnackDispenseHandler next;

    public SnackDispenseHandler(SnackDispenseHandler next) {
        this.next = next;
    }

    public  void handleRequest(VendingMachine machine, String requestType, double moneyInserted){
        if(next!=null){
            next.handleRequest(machine, requestType, moneyInserted);
        }
        else{
            System.out.println("Invalid snack selection. Please select a valid snack.");
        }
    };
}
//COKE HANDLER
class CokeDispenseHandler extends SnackDispenseHandler {
    public CokeDispenseHandler(SnackDispenseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(VendingMachine machine, String snackName, double moneyInserted) {
        if ("Coke".equals(snackName)) {
            if (machine.getSnack(snackName).canDispense(moneyInserted)) {
                machine.selectSnack(snackName);
                machine.insertMoney(moneyInserted);
                machine.dispenseSnack();
            } else {
                System.out.println("Not enough money inserted or out of stock for Coke.");
            }
        } else {
            super.handleRequest(machine, snackName, moneyInserted);
        }
    }
}

//PEPSI HANDLER
class PepsiDispenseHandler extends SnackDispenseHandler {
    public PepsiDispenseHandler(SnackDispenseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(VendingMachine machine, String snackName, double moneyInserted) {
        if ("Pepsi".equals(snackName)) {
            if (machine.getSnack(snackName).canDispense(moneyInserted)) {
                machine.selectSnack(snackName);
                machine.insertMoney(moneyInserted);
                machine.dispenseSnack();
            } else {
                System.out.println("Not enough money inserted or out of stock for Pepsi.");
            }
        } else {
            super.handleRequest(machine, snackName, moneyInserted);
        }
    }
}

//CHEETOS HANDLER
class CheetosDispenseHandler extends SnackDispenseHandler {
    public CheetosDispenseHandler(SnackDispenseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(VendingMachine machine, String snackName, double moneyInserted) {
        if ("Cheetos".equals(snackName)) {
            if (machine.getSnack(snackName).canDispense(moneyInserted)) {
                machine.selectSnack(snackName);
                machine.insertMoney(moneyInserted);
                machine.dispenseSnack();
            } else {
                System.out.println("Not enough money inserted or out of stock for Cheetos.");
            }
        } else {
            super.handleRequest(machine, snackName, moneyInserted);
        }
    }
}
//DORITOS HANDLER
class DoritosDispenseHandler extends SnackDispenseHandler {
    public DoritosDispenseHandler(SnackDispenseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(VendingMachine machine, String snackName, double moneyInserted) {
        if ("Doritos".equals(snackName)) {
            if (machine.getSnack(snackName).canDispense(moneyInserted)) {
                machine.selectSnack(snackName);
                machine.insertMoney(moneyInserted);
                machine.dispenseSnack();
            } else {
                System.out.println("Not enough money inserted or out of stock for Doritos.");
            }
        } else {
            super.handleRequest(machine, snackName, moneyInserted);
        }
    }
}
//KITKAT HANDLER
class KitkatDispenseHandler extends SnackDispenseHandler {
    public KitkatDispenseHandler(SnackDispenseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(VendingMachine machine, String snackName, double moneyInserted) {
        if ("Kitkat".equals(snackName)) {
            if (machine.getSnack(snackName).canDispense(moneyInserted)) {
                machine.selectSnack(snackName);
                machine.insertMoney(moneyInserted);
                machine.dispenseSnack();
            } else {
                System.out.println("Not enough money inserted or out of stock for Kitkat.");
            }
        } else {
            super.handleRequest(machine, snackName, moneyInserted);
        }
    }
}
//SNICKERS HANDLER
class SnickersDispenseHandler extends SnackDispenseHandler {
    public SnickersDispenseHandler(SnackDispenseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(VendingMachine machine, String snackName, double moneyInserted) {
        if ("Snickers".equals(snackName)) {
            if (machine.getSnack(snackName).canDispense(moneyInserted)) {
                machine.selectSnack(snackName);
                machine.insertMoney(moneyInserted);
                machine.dispenseSnack();
            } else {
                System.out.println("Not enough money inserted or out of stock for Snickers.");
            }
        } else {
            super.handleRequest(machine, snackName, moneyInserted);
        }
    }
}