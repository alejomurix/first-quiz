package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {

  private double quarter;
  private Drink drink;
  private String[] drinks = new String[] {"Cola" , "Tea"};

  public static VendingMachine getInstance() {
    // Fix me!
    
    return new VendingMachineImpl();
  }

  @Override
  public void insertQuarter() {
    this.quarter += 0.25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if (this.quarter == 0) 
      throw new NotEnoughMoneyException();
    if (!existDrink(name))
      throw new UnknownDrinkException();
    if (name.contains("Tea") && quarter < 1) 
      throw new NotEnoughMoneyException();
    this.drink = new DrinkImpl(name);
    this.quarter = 0.0;
    return this.drink;
  }

  private boolean existDrink(String name) {
    boolean exist = false;
    for (String _drinks : this.drinks) {
      if (name.contains(_drinks)) exist = true;
    }
    return exist;
  }

}