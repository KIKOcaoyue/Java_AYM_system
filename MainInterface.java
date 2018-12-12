import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainInterface {

	public static long nowid;
	public static String nametext;
	public static double balancetext;
	public static String acctype;
	public MainInterface(long nowid){
		this.nowid = nowid;
	}
	public void getAcc(long id){
		Bank bank = new Bank();
		for(Account each : bank.getDatabase()){
			if(each.getId()==id){
				nametext = each.getName();
				balancetext = each.getBalance();
				acctype = each.getAccountType();
			}
		}
	}
	protected Shell MainInterface;
	private Text NameText;
	private Text AccTypeText;
	private Text BalanceText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainInterface window = new MainInterface(nowid);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		MainInterface.open();
		MainInterface.layout();
		while (!MainInterface.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		MainInterface = new Shell();
		MainInterface.setSize(450, 375);
		MainInterface.setText("SWT Application");
		
		Label lblSunmyBank = new Label(MainInterface, SWT.NONE);
		lblSunmyBank.setBounds(167, 10, 88, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Label label = new Label(MainInterface, SWT.NONE);
		label.setBounds(53, 41, 48, 20);
		label.setText("\u59D3\u540D\uFF1A");
		
		NameText = new Text(MainInterface, SWT.BORDER);
		NameText.setBounds(114, 38, 201, 26);
		NameText.setText(nametext);
		
		Label label_1 = new Label(MainInterface, SWT.NONE);
		label_1.setBounds(41, 79, 70, 20);
		label_1.setText("\u8D26\u6237\u7C7B\u578B\uFF1A");
		
		AccTypeText = new Text(MainInterface, SWT.BORDER);
		AccTypeText.setBounds(114, 76, 201, 26);
		AccTypeText.setText(acctype);
		
		Label label_2 = new Label(MainInterface, SWT.NONE);
		label_2.setBounds(53, 124, 48, 20);
		label_2.setText("\u4F59\u989D\uFF1A");
		
		BalanceText = new Text(MainInterface, SWT.BORDER);
		BalanceText.setBounds(114, 121, 201, 26);
		BalanceText.setText(String.valueOf(balancetext));
		
		Button withdrawbtn = new Button(MainInterface, SWT.NONE);
		withdrawbtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainInterface.close();
				WithdrawGUI withdrawgui = new WithdrawGUI(nowid);
				withdrawgui.open();
			}
		});
		withdrawbtn.setBounds(114, 165, 90, 30);
		withdrawbtn.setText("\u53D6\u6B3E");
		
		Button transferbtn = new Button(MainInterface, SWT.NONE);
		transferbtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainInterface.close();
				TransferGUI tranfergui = new TransferGUI(nowid);
				tranfergui.open();
			}
		});
		transferbtn.setBounds(114, 201, 90, 30);
		transferbtn.setText("\u8F6C\u8D26");
		
		Button payloadbtn = new Button(MainInterface, SWT.NONE);
		payloadbtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainInterface.close();
				CreditpayGUI creditpaygui = new CreditpayGUI(nowid);
				creditpaygui.open();
			}
		});
		payloadbtn.setBounds(210, 201, 90, 30);
		payloadbtn.setText("\u8FD8\u6B3E");
		
		Button depositbtn = new Button(MainInterface, SWT.NONE);
		depositbtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainInterface.close();
				DepositGUI depositgui = new DepositGUI(nowid);
				depositgui.open();
			}
		});
		depositbtn.setBounds(210, 165, 90, 30);
		depositbtn.setText("\u5B58\u6B3E");
		
		Button quitbtn = new Button(MainInterface, SWT.NONE);
		quitbtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainInterface.close();
			}
		});
		quitbtn.setBounds(167, 289, 90, 30);
		quitbtn.setText("\u9000\u51FA");
		
		Button button = new Button(MainInterface, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LoanmoneyGUI loanmoneygui = new LoanmoneyGUI(nowid);
				loanmoneygui.open();
			}
		});
		button.setBounds(114, 237, 90, 30);
		button.setText("\u8D37\u6B3E");
		
		Button btnNewButton = new Button(MainInterface, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainInterface.close();
				PayloanGUI payloangui = new PayloanGUI(nowid);
				payloangui.open();
			}
		});
		btnNewButton.setBounds(210, 237, 90, 30);
		btnNewButton.setText("\u8FD8\u8D37\u6B3E");

	}
}
