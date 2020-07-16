import java.util.ArrayList;
import java.util.Collection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RedditScraper {

	public static void main(String[] args) throws Exception {
				
		String pageUrl = "https://www.reddit.com/r/CryptoCurrency/new/";
		String browserInfo = "GoogleChrome/83.0.4103.116";
		Document page = Jsoup.connect(pageUrl).userAgent(browserInfo).get();
		
		Elements usernames = page.select("div._2mHuuvyV9doV3zwbZPtIPG");
		ArrayList<String> users  = new ArrayList<>();
		
		for(Element u: usernames) users.add(u.text());
		for(String s: users) System.out.println(s);
		
		Elements timestamps = page.select("div._3jOxDPIQ0KaOWpzvSQo-1s");
		ArrayList<String> times = new ArrayList<>();
		
		for(Element t: timestamps) times.add(t.text());
		for(String s: times) System.out.println(s);
		
		Elements categories = page.select("div.lrzZ8b0L6AzLkQj5Ww7H1");
		ArrayList<String> types = new ArrayList<>();
		
		for(Element c: categories) types.add(c.text());
		for(String s: types) System.out.println(s);

		Elements postUrls = page.select("div._2SdHzo12ISmrC8H86TgSCp_3wqmjmv3tb_k-PROt7qFZe");
		ArrayList<String> postLinks = new ArrayList<>();
		
		for(Element p: postUrls) postLinks.add(p.text());
		for(String s: postLinks) System.out.println(s);

	}
}
