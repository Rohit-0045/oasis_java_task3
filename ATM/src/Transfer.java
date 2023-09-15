public class Transfer {
    public boolean transferAmount(int transferAmount){
        UserDb userDb = new UserDb();
        User user = userDb.getUser();
        boolean isAmountTransfer = false;

        if (user.getBalance() >= transferAmount){
            int totalAmount = user.getBalance() - transferAmount;
            user.setBalance(totalAmount);
            user.setTransaction(transferAmount + " amount is transfer.");
            isAmountTransfer = userDb.setUser(user);
            return isAmountTransfer;
        }else {
            return isAmountTransfer;
        }
    }
}