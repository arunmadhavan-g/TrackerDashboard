import java.util.List;
import java.util.stream.Collectors;

public class InProgressAnalyzer implements Analyzer {

	@Override
	public List<Story> filter(List<Story> stories) {
		return stories.stream()
						.filter(Story::isStarted)
						.collect(Collectors.toList());
	}

}
