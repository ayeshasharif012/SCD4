package LAB4;
class PrintRollNumbers extends Thread {
    @Override
    public void run() {
        String[] rollNumbers = {"2019-SE-092", "2019-SE-093", "2019-SE-094", "2019-SE-095"};
        System.out.println("Roll Numbers Table:");
        for (String rollNo : rollNumbers) {
            System.out.println(rollNo);
        }
    }
}
class PrintDatesOfBirth extends Thread {
    @Override
    public void run() {
        String[] datesOfBirth = {"5th April", "10th March", "20th May", "15th July"};
        System.out.println("Dates of Birth Table:");
        for (String dob : datesOfBirth) {
            System.out.println(dob);
        }
    }
}
public class Main1 {
    public static void main(String[] args) {
        PrintRollNumbers rollNumbersThread = new PrintRollNumbers();
        PrintDatesOfBirth datesOfBirthThread = new PrintDatesOfBirth();
        rollNumbersThread.start();
        datesOfBirthThread.start();
    }
}