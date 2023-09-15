public class Withdrawal {

    public boolean withdrawalAmount(int amount){
        UserDb userDb = new UserDb();
        boolean isAmountWithdrawal = false;
        User user = userDb.getUser();

        if (user.getBalance() >= amount){
            int totalAmount = user.getBalance() - amount;
            user.setBalance(totalAmount);
            user.setTransaction(amount + " amount is withdrawal.");
            isAmountWithdrawal = userDb.setUser(user);
            return isAmountWithdrawal;
        }else {
            return isAmountWithdrawal;
        }
    }
}
