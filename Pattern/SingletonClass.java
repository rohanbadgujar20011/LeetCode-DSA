package Pattern;
//Singleton class is class having the only one instance


class Bank{
    private   static  Bank bankInstance;
    private Bank() {

    }
    public static  Bank getBankInstance(){
        if (bankInstance == null){
            bankInstance = new Bank();
        }
        return bankInstance;
    }
}
public class SingletonClass {

    public static void main(String[] args) {

        Bank bank = Bank.getBankInstance();
        Bank bank1 = Bank.getBankInstance();
        System.out.println(bank1==bank);

    }

}
