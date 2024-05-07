public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addSnack(new Snack("Coke", 1.50, 5));
        vendingMachine.addSnack(new Snack("Pepsi", 1.50, 5));
        vendingMachine.addSnack(new Snack("Cheetos", 1.00, 3));
        vendingMachine.addSnack(new Snack("Doritos", 1.00, 4));
        vendingMachine.addSnack(new Snack("KitKat", 0.75, 10));
        vendingMachine.addSnack(new Snack("Snickers", 0.75, 3)); // Initially with 3 Snickers

        // Setting up the chain of responsibility
        SnackDispenseHandler handlerChain = new CokeDispenseHandler(
                new PepsiDispenseHandler(
                        new CheetosDispenseHandler(
                                new DoritosDispenseHandler(
                                        new KitkatDispenseHandler(
                                                new SnickersDispenseHandler(null))))));

        System.out.println("************ SCENARIO 1: Successfully purchasing a Coke ************");
        vendingMachine.resetMachine();
        handlerChain.handleRequest(vendingMachine, "Coke", 2.00);

        System.out.println("\n************ SCENARIO 2: Insufficient funds for Doritos ************");
        vendingMachine.resetMachine();
        handlerChain.handleRequest(vendingMachine, "Doritos", 0.50);

        System.out.println("\n************ SCENARIO 3: Invalid snack selection ************");
        vendingMachine.resetMachine();
        handlerChain.handleRequest(vendingMachine, "Sour Patch Kids", 1.00);

        System.out.println("\n************ SCENARIO 4: Purchasing all available Snickers ************");
        vendingMachine.resetMachine();
        for (int i = 0; i < 3; i++) {
            handlerChain.handleRequest(vendingMachine, "Snickers", 0.75);
        }

        System.out.println("\n************ SCENARIO 5: Attempting to purchase Snickers when out of stock ************");
        vendingMachine.resetMachine();
        vendingMachine.addSnack(new Snack("Snickers", 0.75, 0));
        handlerChain.handleRequest(vendingMachine, "Snickers", 0.75);
    }
}
