package org.example.prepaidCard;

public class TravelCard extends PrepaidCard implements Rewardable{
    private int rewardPoints;
    public TravelCard(int cardNo, double availableBalance, double swipeLimit, int rewardPoints) {
        super(cardNo, availableBalance, swipeLimit);
        this.rewardPoints=rewardPoints;
    }

    @Override
    public boolean swipeCard(int amount) {
        int amountInINR=amount*60;
        if(amountInINR>=getSwipeLimit() && amountInINR >= getAvailableBalance()){
            double balanceAfterSwiping = getAvailableBalance()-amountInINR;
            double swipingInterest = balanceAfterSwiping*5/100;
            setAvailableBalance(balanceAfterSwiping - swipingInterest);
            System.out.println("Amount has been deducted "+" available balance "+getAvailableBalance());
            return true;
        }
        System.out.println("Fund is insufficient");
        return false;
    }

    @Override
    public int calculateRewardPoint(int amount) {
        if(amount > 100) return 10;
        return 0;
    }
}
