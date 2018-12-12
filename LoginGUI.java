import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class LoginGUI {

	
	protected Shell Login;
	private Text InputAccountText;
	private Text InputPasswordText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginGUI window = new LoginGUI();
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
		Login.open();
		Login.layout();
		while (!Login.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		Login = new Shell();
		Login.setSize(450, 300);
		Login.setText("SWT Application");
		
		Label label = new Label(Login, SWT.NONE);
		label.setBounds(49, 46, 70, 20);
		label.setText("\u8D26\u53F7\uFF1A");
		
		InputAccountText = new Text(Login, SWT.BORDER);
		InputAccountText.setText("");
		InputAccountText.setBounds(125, 43, 205, 26);
		
		Label lblSunmyBank = new Label(Login, SWT.NONE);
		lblSunmyBank.setBounds(166, 10, 88, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Label lblNewLabel = new Label(Login, SWT.NONE);
		lblNewLabel.setBounds(49, 107, 70, 20);
		lblNewLabel.setText("\u5BC6\u7801\uFF1A");
		
		InputPasswordText = new Text(Login, SWT.BORDER);
		InputPasswordText.setBounds(125, 107, 205, 26);
		
		Button button = new Button(Login, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Bank bank = new Bank();
				try{
					bank.login(Long.valueOf(InputAccountText.getText()),InputPasswordText.getText());
					MainInterface maininterface = new MainInterface(Long.valueOf(InputAccountText.getText()));
					maininterface.getAcc(Long.valueOf(InputAccountText.getText()));
					maininterface.open();
				}catch(PasswordNotRightException passwordexp){  //不输东西不会跳进异常界面
					PasswordError passworderror = new PasswordError();
					passworderror.open();
					passwordexp.printStackTrace();
				}
				
			}
		});
		button.setBounds(166, 160, 90, 30);
		button.setText("\u767B\u9646");
		
		Button button_1 = new Button(Login, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Login.close();
			}
		});
		button_1.setBounds(166, 196, 90, 30);
		button_1.setText("\u9000\u51FA");

	}
}
