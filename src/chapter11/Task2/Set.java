package chapter11.Task2;

public class Set {

    public int[] binary;

    public Set(int number) {
        binary = new int[(int) Math.sqrt(number) + 1];
        for(int i = 0; i < binary.length && number > 0; i++) {
			if(number % 2 == 1) binary[i] = 1;	
			number = number / 2;
        }
    }

    public Set setBit(int index, boolean state) {
        binary[index] = state ? 1 : 0;
        return this;
    }

    public Set intersect(Set set) {
        for(int i = 0; i < set.binary.length; i++) {
            if(set.binary[i] == 1 && binary[i] == 1) binary[i] = 1;
            else binary[i] = 0;
        }
        return this;
    }

    public Set merge(Set set) {
        for(int i = 0; i < set.binary.length; i++) {
            if(binary[i] == 1 || set.binary[i] == 1) binary[i] = 1;
            else binary[i] = 0;
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;

        for(int i = 0; i < binary.length; i++) {
            if(binary[i] == 1) {
                if(first) first = false;
                else sb.append(",");
                sb.append(i);
            }
        }

        return sb.append("}").toString();
    }
}