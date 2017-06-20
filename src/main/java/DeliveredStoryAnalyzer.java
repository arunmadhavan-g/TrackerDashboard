import java.util.List;
import java.util.stream.Collectors;

public class DeliveredStoryAnalyzer implements Analyzer{

	@Override
	public List<Story> filter(List<Story> stories) {
		return  stories.stream()
				.filter(Story::isDelivered)
				.collect(Collectors.toList());
	}

}
