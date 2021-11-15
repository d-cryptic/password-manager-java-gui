import javax.swing.UIManager;

// Main method 

public class Main {
	public static void main(String[] args) {
		// loading screen class  
		new SplashScreen();
		new PasswordManager();
		try{
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
