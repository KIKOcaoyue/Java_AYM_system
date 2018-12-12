
public class SavingAccount extends Account{
	
	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(double balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(long id, String password, String name, String personid, String email,String accountType, double balance,double loanmoney) {
		super(id, password, name, personid, email,accountType, balance,loanmoney);
		// TODO Auto-generated constructor stub
	}

	public SavingAccount withdraw(double money) throws BalanceNotEnoughException{
		if(money>this.getBalance()){
			double needs = money-this.getBalance();
			throw new BalanceNotEnoughException(needs);
		}else{
			this.setBalance(this.getBalance()-money);
			return this;
		}
	}

	public SavingAccount deposit(double money) throws BalanceNotEnoughException{
		if(money<0){
			throw new BalanceNotEnoughException(money);
		}else{
			this.setBalance(this.getBalance()+money);
			return this;
		}
	}
	
	@Override
	public boolean withdraw() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deposit() {
		// TODO Auto-generated method stub
		return false;
	}

}
