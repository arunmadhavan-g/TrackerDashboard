import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class Writer {

	private OutputStream out;
	public Writer(OutputStream out) {
		this.out = out;
	}
	
	public void write(List<Story> stories){
		stories.forEach(story-> {
			try {
				out.write(story.toString().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
