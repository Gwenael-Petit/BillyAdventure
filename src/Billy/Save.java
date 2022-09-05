package Billy;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;

public class Save {
	public static void save(int score) {
		try(FileWriter file = new FileWriter("./csv/save.csv")) {
			file.write("" + score);
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int load() {
		File file = new File("./csv/save.csv");
		try {
			String content = Files.readString(file.toPath());
			int score = Integer.parseInt(content);
			return score;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		save(12);
		int result = load();
		System.out.println(result);
	}
}
