

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface PivotalTrackerService {

	@GET("{project-id}/stories/")
	@Headers("X-TrackerToken:4f39020862d53a30161a3e63f48e4c46")
	Call<List<Story>> stories(@Path("project-id")String project); 
	
}
