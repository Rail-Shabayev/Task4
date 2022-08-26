import java.io.*;

public class Task {
	public static void main(String[] args) throws IOException {
		Frequency freq = new Frequency();
		freq.makeMap();
		freq.printAverages(freq.computeFreq());
	}
}
