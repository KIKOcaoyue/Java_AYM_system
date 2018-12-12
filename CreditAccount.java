
public class CreditAccount extends Account{

	private double creditamount;
	private double totalcreditamount;
	public CreditAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditAccount(double balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}
	
	public CreditAccount(long id, String password, String name, String personid, String email,String accountType, double balance,double loanmoney,double creditamount,double totalcreditamount) {
		super(id, password, name, personid, email,accountType, balance,loanmoney);
		this.creditamount = creditamount;
		this.totalcreditamount = totalcreditamount;
		// TODO Auto-generated constructor stub
	}

	public double getCreditamount() {
		return creditamount;
	}

	public double getTotalcreditamount(){
		return this.totalcreditamount;
	}
	public void setCreditamount(double creditamount) {
		this.creditamount = creditamount;
	}
	
	@Override
	public boolean withdraw() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public CreditAccount withdraw(double money) throws BalanceNotEnoughException{
		if(money>this.getBalance()){
			double needs = money-this.getBalance();
			throw new BalanceNotEnoughException(needs);
		}else if(money>this.getBalance()+this.getCreditamount()){
			double needs = money-this.getBalance()-this.getCreditamount();
			throw new BalanceNotEnoughException(needs);
		}else if(money<=this.getBalance()){
			this.setBalance(this.getBalance()-money);
			return this;
		}else if(money>this.getBalance() && money<=this.getBalance()+this.getCreditamount()){
			this.setBalance(0);
			this.setCreditamount(this.getCreditamount()-money+this.getBalance());
			return this;
		}
		return null;
	}
	@Override
	public boolean deposit() {
		// TODO Auto-generated method stub
		return false;
	}

	public CreditAccount deposit(double money) throws BalanceNotEnoughException{
		if(money<0){
			throw new BalanceNotEnoughException(money);
		}else{
			this.setBalance(this.getBalance()+money);
			return this;
		}
	}
	public CreditAccount paycredit(double money) throws BalanceNotEnoughException{
		if(money<0){
			throw new BalanceNotEnoughException(money);
		}else{
			this.setCreditamount(this.getCreditamount()-money);
			return this;
		}
	}
	
}
