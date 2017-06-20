public class SetupUtil {

	static void setProxy() {
		System.getProperties().put("http.proxyHost", "proxyvipsgh.nb.ford.com");
		System.getProperties().put("http.proxyPort", "83");
		System.getProperties().put("https.proxyHost", "proxyvipsgh.nb.ford.com");
		System.getProperties().put("https.proxyPort", "83");
	}
	
	
}
