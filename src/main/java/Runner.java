import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		//Set proxy
		SetupUtil.setProxy();
		
		//Read
		TrackerReader reader = new TrackerReader();
		List<Story> stories = reader.readStories("2008623");
		
		//analyze
		Analyzer deliveredStoryAnalyzer = new DeliveredStoryAnalyzer();
		List<Story> deliveredStories = deliveredStoryAnalyzer.filter(stories);
		
		Analyzer inProgressAnalyzer = new InProgressAnalyzer();
		List<Story> inprogressStories = inProgressAnalyzer.filter(stories);
		
		System.out.println(inprogressStories);
		//Side Effect
		Writer fileWriter = new Writer(new FileOutputStream(new File("C:\\Arun\\some.txt")));
		fileWriter.write(deliveredStories);
		
		Writer sysWriter = new Writer(System.out);
		sysWriter.write(deliveredStories);
	}

}
