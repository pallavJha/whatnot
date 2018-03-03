package pl.misc.pi;

import java.util.*;

/**
 * @author pallav
 * @version 1.0
 * @since 15/6/17
 */
public class Test2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            int inputRows = sc.nextInt();
            List<Telecast> telecastList = new ArrayList<>(inputRows);
            for (int j = 0; j < inputRows; j++) {
                Telecast telecast = new Telecast();
                telecast.startTime = sc.nextInt();
                telecast.endTime = sc.nextInt();
                telecast.bw = sc.nextInt();
                if (telecastList.contains(telecast)) {
                    Telecast other = telecastList.stream()
                            .filter(t -> t.equals(telecast))
                            .findFirst()
                            .orElse(null);
                    other.bw += telecast.bw;

                }
                else {
                    telecastList.add(telecast);
                }
            }
            for (int p = 0 ; p < telecastList.size(); p++) {
                find(p, telecastList);
            }
            Collections.sort(telecastList, Comparator.reverseOrder());
            System.out.println(telecastList.get(0).bw);
        }
    }

    private static void find(int index, List<Telecast> telecastList) {
        Telecast telecast = telecastList.get(index);
        for (Telecast temp : telecastList) {
            if (!telecast.equals(temp)) {
                if (telecast.startTime < temp.startTime && telecast.endTime <= temp.startTime) {

                } else if (temp.startTime < telecast.startTime && temp.endTime <= telecast.startTime) {

                } else if (telecast.endTime - telecast.startTime > temp.endTime - temp.startTime) {
                    telecast.startTime = telecast.startTime < temp.startTime ? telecast.startTime : temp.startTime;
                    telecast.endTime = telecast.endTime > temp.endTime ? telecast.endTime : temp.endTime;
                    telecast.bw += temp.bw;
                }
            }
        }
    }

    private static class Telecast implements Comparable<Telecast> {
        int startTime;
        int endTime;
        int bw;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Telecast telecast = (Telecast) o;

            if (startTime != telecast.startTime) return false;
            if (endTime != telecast.endTime) return false;
            return bw == telecast.bw;

        }

        @Override
        public int hashCode() {
            int result = startTime;
            result = 31 * result + endTime;
            result = 31 * result + bw;
            return result;
        }

        @Override
        public int compareTo(Telecast o) {
            return Integer.compare(bw, o.bw);
        }
    }
}
