public class Deposit {
    public boolean depositAmount(int amount){
        UserDb userDb = new UserDb();
        boolean isAmountDeposited = false;
        User user = userDb.getUser();

        if (amount > 0) {
            int totalAmount = user.getBalance() + amount;
            user.setBalance(totalAmount);
            user.setTransaction(amount + " amount is deposited.");
            isAmountDeposited = userDb.setUser(user);
            return isAmountDeposited;
        }else {
            return isAmountDeposited;
        }
    }
}