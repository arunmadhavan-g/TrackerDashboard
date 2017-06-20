

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import org.javatuples.Pair;

import lombok.Data;

@Data
public class Story {

	private String kind;
	private String id;
	private String created_at;
	private String updated_at;
	private String accepted_at;
	private String story_type;
	private int estimate; 
	private String name;
	private String current_state;
	private String requested_by_id;
	private List<Label> labels; 
	
	public boolean isRelease(){
		return "release".equalsIgnoreCase(story_type);
	}
	public boolean hasName(String markerName) {
		return markerName.equalsIgnoreCase(name);
	}
	public boolean isStory() {
		return "feature".equalsIgnoreCase(story_type);
	}
	public boolean isReleaseWithMarker(String marker) {
		return this.isRelease() && this.hasName(marker);
	}
	public boolean isStarted(){
		return "started".equalsIgnoreCase(current_state);
	}
	
	public boolean isAccepted(){
		return "accepted".equalsIgnoreCase(current_state);
	}
	
	public boolean isDelivered(){
		return "delivered".equalsIgnoreCase(current_state);
	}
	public boolean isFinished(){
		return "finished".equalsIgnoreCase(current_state);
	}
	
	public boolean isUnstarted(){
		return "unstarted".equalsIgnoreCase(current_state);
	}
	
	public boolean isCVPrioratized(){
		return !(labels.stream()
						.filter(Label::isCVPrioratized)
						.count() 
						== 0);
	}
	
	
	public boolean isEnrollment(){
		return !(labels.stream().filter(Label::isEnrollment).count() == 0);
	}
	
	public boolean isAccountManagement(){
		return !(labels.stream().filter(Label::isAccountManagement).count() == 0);
	}

	private static final Predicate<Story> isAStory= Story::isStory;
	
	private static final Predicate<Story> accepted = Story::isAccepted;
	public static final Predicate<Story> acceptedStories = accepted.and(isAStory);
	
	private static final Predicate<Story> delivered = Story::isDelivered;
	public static final Predicate<Story> deliveredStories = isAStory.and(delivered);
	
	public static final Function<List<Story>, Pair<List<Story> , Map<String, List<Story>>>> initiate = stories -> Pair.with(stories, new HashMap<>());
}
