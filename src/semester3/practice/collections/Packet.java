package semester3.practice.collections;

import java.util.ArrayList;
import java.util.Collections;

public class Packet implements Comparable<Packet> {
    private double weight;

    public static void main(String[] args) {
        ArrayList<Packet> packets = new ArrayList<>();

        packets.add(new Packet(100.9));
        packets.add(new Packet(104.3));
        packets.add(new Packet(12.03));
        packets.add(new Packet(82.12));

        Collections.sort(packets);

        for(int i = 0; i < packets.size(); i++) {
            System.out.println( i + " : " + packets.get(i).getWeight());
        }
    }

    public Packet(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int compareTo(Packet pkt) {
        return Double.compare(this.weight, pkt.weight);
    }
}