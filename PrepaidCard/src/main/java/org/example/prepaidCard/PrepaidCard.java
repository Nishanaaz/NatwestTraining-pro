package org.example.prepaidCard;

public abstract class PrepaidCard {
    private int CardNo;
    private double availableBalance ;
    private double swipeLimit;

    public PrepaidCard(int cardNo, double availableBalance, double swipeLimit) {
        CardNo = cardNo;
        this.availableBalance = availableBalance;
        this.swipeLimit = swipeLimit;
    }

    public int getCardNo() {
        return CardNo;
    }

    public void setCardNo(int cardNo) {
        CardNo = cardNo;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public double getSwipeLimit() {
        return swipeLimit;
    }

    public void setSwipeLimit(double swipeLimit) {
        this.swipeLimit = swipeLimit;
    }

    public abstract boolean swipeCard(int amount);
    public void rechargeCard(int amount){
        availableBalance+=amount;
        System.out.println("Amount has been added");
    }

    @Override
    public String toString() {
        return "PrepaidCard{" +
                "CardNo=" + CardNo +
                ", availableBalance=" + availableBalance +
                ", swipeLimit=" + swipeLimit +
                '}';
    }
}
