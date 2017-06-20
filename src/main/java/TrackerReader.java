import java.io.IOException;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrackerReader {

	private Retrofit retrofit;

	public TrackerReader() {
		setup();
	}
	
	public List<Story> readStories(String projectID) throws IOException {
		return  this.retrofit.create(PivotalTrackerService.class)
										.stories(projectID)
										.execute()
										.body();
	}

	private void setup() {
		this.retrofit = new Retrofit.Builder()
									.baseUrl("https://www.pivotaltracker.com/services/v5/projects/")
									.addConverterFactory(GsonConverterFactory.create())
									.build();
	}

}
