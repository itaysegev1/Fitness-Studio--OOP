package gym.customers;

import java.util.Comparator;

public class ClientComparators {

    /**
     * Comparator to sort clients by name
     */

    public static class NameComparator implements Comparator<Client> {
        @Override
        public int compare(Client c1, Client c2) {
            if (c1.getname().equalsIgnoreCase(c2.getname())) {
                return 0;
            }
            if (c1.getname().compareToIgnoreCase(c2.getname()) < 0) {
                return -1;
            }
            return 1;
        }
    }





    /**
     * Comparator to sort clients by age
     */
    public static class AgeComparator implements Comparator<Client> {
        @Override
        public int compare(Client c1, Client c2) {
            if (c1.birth.equals(c2.birth)) {
                return 0;
            }
            if (c1.birth.isAfter(c2.birth)) {  // Younger client
                return -1;
            }
            return 1;  // Older client
        }
    }

    /**
     * Comparator to sort clients by gender and then by name
     */
    public static class GenderThenNameComparator implements Comparator<Client> {
        @Override
        public int compare(Client c1, Client c2) {
            // First compare by gender
            if (c1.gender == c2.gender) {
                // If same gender, compare by name
                if (c1.getname().equalsIgnoreCase(c2.getname())) {
                    return 0;
                }
                if (c1.getname().compareToIgnoreCase(c2.getname()) < 0) {
                    return -1;
                }
                return 1;
            }
            // Different genders - order by Male first, then Female
            if (c1.gender == Gender.Male && c2.gender == Gender.Female) {
                return -1;
            }
            return 1;
        }
    }
}