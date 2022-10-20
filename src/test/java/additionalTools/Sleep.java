package additionalTools;

public class Sleep {

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Sleep - Something went wrong");
        }
    }

}
