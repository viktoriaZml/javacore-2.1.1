package my.first_prj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {
  private Account account1;
  private Account account2;
  private Account account3;

  @BeforeEach
  void init(){
    account1 = new SavingsAccount(5000);
    account2 = new CreditAccount(0);
    account3 = new CheckingAccount(1000);
  }

  @Test
  void pay() {
    //when
    boolean result = account1.pay(1000);
    //then
    Assertions.assertEquals(false, result);
    //when
    result = account2.pay(1000);
    //then
    Assertions.assertEquals(true, result);
    //when
    result = account3.pay(1000);
    //then
    Assertions.assertEquals(true, result);
    //when
    result = account3.pay(1000);
    //then
    Assertions.assertEquals(false, result);
  }

  @Test
  void transfer() {
    //when
    boolean result = account1.transfer(account2, 3000);
    //then
    Assertions.assertEquals(false, result);
    //when
    result = account1.transfer(account3, 3000);
    //then
    Assertions.assertEquals(true, result);
    //when
    result = account1.transfer(account3, 3000);
    //then
    Assertions.assertEquals(false, result);
    //when
    result = account2.transfer(account1, 3000);
    //then
    Assertions.assertEquals(true, result);
    //when
    result = account3.transfer(account2, 3000);
    //then
    Assertions.assertEquals(true, result);
    //when
    result = account3.transfer(account1, 3000);
    //then
    Assertions.assertEquals(false, result);
  }

  @Test
  void addMoney() {
    //when
    boolean result = account1.addMoney(1000);
    //then
    Assertions.assertEquals(true, result);
    //when
    result = account2.addMoney(1000);
    //then
    Assertions.assertEquals(false, result);
    //when
    result = account3.addMoney(1000);
    //then
    Assertions.assertEquals(true, result);
  }
}