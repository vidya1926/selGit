package newLearnings;

public class UseStatic extends LearnStatic {
	
	
	public void launchBrowser() {		
		System.out.println("Launching Browser");
    }	
	
	public static void loadUrl() {
	String url= "https://www.google.com";
		System.out.println("Loading URL"+url);
	}
	
		
	public static void main(String[] args) {
		UseStatic obj = new UseStatic();
		obj.launchBrowser();
		LearnStatic.loadUrl();
		UseStatic.loadUrl();
	}

}
