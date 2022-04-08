import java.util.ArrayList;

public class solve4 {
    public static void main (String[] args) {
        In inputFile = new In("chal.c");

        ArrayList<Integer> set_mask = new ArrayList<Integer>();
        ArrayList<Integer> clr_mask = new ArrayList<Integer>();

        int current = 0;
        String flag = "";

        while (inputFile.hasNextLine()) {
            String input = inputFile.readLine();
            if (input.contains("gpio_set_mask(")) {
                int curr = Integer.parseInt(input.substring(input.indexOf("(")+1, input.indexOf(")")));
                set_mask.add(curr);
            } else if (input.contains("gpio_clr_mask")) {
                int curr = Integer.parseInt(input.substring(input.indexOf("(")+1, input.indexOf(")")));
                clr_mask.add(curr);
            }
        }

        for (int i = 0; i < set_mask.size(); i++) {
            current |= set_mask.get(i);
            current &= ~ clr_mask.get(i);
            flag += (char) current;
        }

        System.out.println(flag);
    }
}
