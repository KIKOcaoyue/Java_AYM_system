import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Bank {
	 public static File dataFile=new File( "C:\\Users\\63248\\Documents\\Codes\\Java\\Sunmy_Bank_database\\bankdatabase.txt");
	public static ArrayList<Account> database = new ArrayList<Account>();
	public Bank(ArrayList<Account> database) {
        this.database = database;
    }
    public Bank(){}

    public ArrayList<Account> getDatabase() {
        return database;
    }

    public void setDatabase(ArrayList<Account> database,Account acc) {
        database.add(acc);
    }
    
    public void login(long id,String Password) throws PasswordNotRightException{
    	if(Password.equals("")){
    		throw new PasswordNotRightException(Password);
    	}
    	for(Account each : database){
    		if(each.getId()!=id){
    			if(each.getPassword().equals(Password)){
  
    				throw new PasswordNotRightException(Password);
    			}
    		}
    	}
    }
    
    public void register(long id,String Password,String name,String email,String personid,String acctype){
    	if(acctype.equals("CreditAccount")){
    		this.setDatabase(database, new CreditAccount(id,Password,name,personid,email,acctype,0,10000,0,10000));
    	}else{
    		this.setDatabase(database, new SavingAccount(id,Password,name,personid,email,acctype,0,0));
    	}
    }
    public void withdraw(long id,Double money) throws BalanceNotEnoughException{
		// TODO Auto-generated method stub
    	//ÓÐ´ý²âÊÔ
    	for(Account each : this.getDatabase()){
    		if(each.getId()==id){
    			each.withdraw(money);
    		}
    	}
	}
    public void deposit(long id,Double money) throws BalanceNotEnoughException{
		// TODO Auto-generated method stub
    	for(Account each : this.getDatabase()){
    		if(each.getId()==id){
    			each.deposit(money);
    		}
    	}
		
	}
    public void transfer(long from,long to,double money) throws BalanceNotEnoughException{
    	boolean foundfrom = false,foundto = false;
    	Account From = null;
    	Account To = null;
    	for(Account each : this.getDatabase()){
    		if(each.getId()==from){
    			foundfrom = true;
    			From = each;
    		}else if(each.getId()==to){
    			foundto = true;
    			To = each;
    		}
    	}
    	if(foundfrom==true && foundto==true){
    		From.withdraw(money);
			To.deposit(money);
    	}else{
    	}
    }
    
    public void paycredit(long nowid, Double money) throws BalanceNotEnoughException {
		// TODO Auto-generated method stub
		for(Account each : this.getDatabase()){
			if(each.getId()==nowid){
				if(each instanceof CreditAccount){
					((CreditAccount) each).paycredit(money);
				}
			}
		}
	}
    public void loanmoney(long nowid, Double money){
		// TODO Auto-generated method stub
    	for(Account each : this.getDatabase()){
    		if(each.getId()==nowid){
    			each.setLoanmoney(money);
    		}
    	}
	}
    
    public void payloan(long nowid, Double money){
		// TODO Auto-generated method stub
    	for(Account each : this.getDatabase()){
    		if(each.getId()==nowid){
    			each.setLoanmoney(each.getLoanmoney()-money);
    		}
    	}
	}
    
    public void upDate() {   //DAO
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            fos=new FileOutputStream(dataFile.toString());
            oos=new ObjectOutputStream(fos);
            oos.writeObject(this.database);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                oos.close();
                fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

   public void readData() {  //DAO
       FileInputStream fis=null;
       ObjectInputStream ois=null;
       try{
           fis=new FileInputStream(dataFile.toString());
           ois=new ObjectInputStream(fis);
           this.database=(ArrayList<Account>) ois.readObject();
//           this.accountsNum=this.accounts.size();
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           try{
               ois.close();
               fis.close();
           }catch (Exception e){
               e.printStackTrace();
           }
       }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
