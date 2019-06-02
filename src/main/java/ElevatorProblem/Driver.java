package ElevatorProblem;

public class Driver
{
    public static void main(String[] args)
    {
        Elevator elevator = new Elevator(null, null);
        elevator.run();

        elevator.pushButton(1);
        elevator.pushButton(2);
        elevator.pushButton(0);

    }

}
