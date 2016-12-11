import java.util.Vector;
import java.util.Scanner;

public class GPS {

  public static Vector<Integer> getGasStations(int tripDistance, int tankSize, Vector<Integer> gasStations) {
    gasStations.add(tripDistance);
    int numberOfGasStations = gasStations.size();
    int currentTank = tankSize;
    Vector<Integer> refills = new Vector<Integer>();
    for (int i = 0; i < numberOfGasStations; i++) {
        if (i == 0) {
            if (currentTank - gasStations.get(i) <= 0) {
                currentTank = tankSize;
                refills.add(0);
            }
            currentTank -= gasStations.get(i);
        }
        else {
            int distance = gasStations.get(i) - gasStations.get(i-1);
            if (currentTank - distance <= 0) {
                currentTank = tankSize;
                refills.add(gasStations.get(i - 1));
            }
            currentTank -= distance;
        }
    }


    return refills;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tripDistance = scanner.nextInt();
    int tankSize = scanner.nextInt();

    int gasStationsCount = scanner.nextInt();
    Vector<Integer> gasStations = new Vector<Integer>();

    for (int i = 0; i < gasStationsCount; i++) {
      gasStations.add(scanner.nextInt());
    }

    Vector<Integer> result = getGasStations(tripDistance, tankSize, gasStations);

    for (int i = 0; i < result.size(); i++) {
        System.out.println(result.get(i));
    }

  }
}
