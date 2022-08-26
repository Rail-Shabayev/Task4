import java.io.IOException;
import java.util.TreeMap;

public class Frequency {
	TreeMap<Character, Integer> map;

	public void makeMap() throws IOException {
		map = new TreeMap<>();
		Data data = new Data();
		for (char ch : data.getText().toCharArray()) {
			int i = map.containsKey(ch) ? (map.get(ch) + 1) : 1;
			map.put(ch, i);
		}
	}

	public double computeFreq() throws IOException {
		System.out.println("Частоты: ");
		double freq = 0;
		for (char key : map.keySet()) {
			String much = map.get(key).toString().matches("[234]") ? " раза" : " раз";
			System.out.println(key + " - " + map.get(key) + much);
			freq += map.get(key);
		}
		double answer = freq / map.size();
		System.out.println("Среднее значение частоты " + String.format("%d", (long)freq) 
				+ "/" + map.size() + " = " + String.format("%.8f", answer));
		return answer;
	}

	public void printAverages(double answer) {
		System.out.print("Символы, которые соответствуют условию наиболее "
				+ "близкого значения частоты \nк среднему значению: ");
		for (int i = 0; i < 4; i++) {
			findClosest(answer);
		}
	}
	
	public void findClosest(double answer) {
		double curr = 0;
		char skey = 0;
		for (char key : map.keySet())
			if (Math.abs(map.get(key) - answer) <= Math.abs(curr - answer)) {
				curr = map.get(key);
				skey = key;
			}
		map.remove(skey);
		System.out.print(skey + "(" + (int) skey + ") ");
	}
}
