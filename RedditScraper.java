import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RedditScraper {

	public static void main(String[] args) throws Exception {
		
		Document page = Jsoup.connect("https://www.reddit.com/r/CryptoCurrency/new/").timeout(10000).get();
		
		Elements usernames = page.select("div._3AStxql1mQsrZuUIFP9xSg.nU4Je7n-eSXStTBAPMYt8");
		ArrayList<String> users  = new ArrayList<>();
		
		for(Element u: usernames) users.add(u.text());
		for(String s: users) System.out.println(s);
		
		Elements timestamps = page.select("div.NAURX0ARMmhJ5eqxQrlQW");
		ArrayList<String> times = new ArrayList<>();
		
		for(Element t: timestamps) times.add(t.text());
		for(String s: times) System.out.println(s);
		
		Elements categories = page.select("div.lrzZ8b0L6AzLkQj5Ww7H1");
		ArrayList<String> types = new ArrayList<>();
		
		for(Element c: categories) types.add(c.text());
		for(String s: types) System.out.println(s);

		Elements headlines = page.select("div.y8HYJ-y_lTUHkQIc1mdCq._2INHSNB8V5eaWp4P0rY_mE");
		ArrayList<String> imgLinks = new ArrayList<>();
		
		for(Element p: headlines) imgLinks.add(p.text());
		for(String s: imgLinks) System.out.println(s);		
	}
}
