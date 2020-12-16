package org.jesperancinha.ocp11.crums.crum33;

public enum CashContainer {
    ATM,
    WALLET,
    PURSE,
    BANK,
    BANKACCOUNT,
    LIONACCOUNT;

    public CashContainer tryToClone() throws CloneNotSupportedException{
        return (CashContainer)clone();
    }
}
