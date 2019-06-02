package ElevatorProblem;

import java.sql.SQLOutput;
import java.util.*;

public class Elevator
{
    private static int DOOR_OPEN_TIME = 10_000;
    private SwitchPanel m_switchPanel;

    private Map<Integer, String> buttonLayout;
    private int floor;
    private String status = "";
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    @Override
    public String toString()
    {
        return "Elevator " + status + " currently on floor " + floor;
    }

    public String floorDisplay()
    {
        return "Floor : " + floor;
    }

    public Elevator(SwitchPanel switchPanel, ButtonLayout buttonLayout)
    {
        this.buttonLayout = new ButtonLayout(){
            @Override
            public Map<Integer, String> getButtonLayout()
            {
                Map<Integer, String> buttons = new HashMap<>();
                buttons.put(0, "Basement");
                buttons.put(1, "Garage");
                buttons.put(2, "First Floor");
                return buttons;
            }
        }.getButtonLayout();
        this.m_switchPanel = switchPanel;
        this.floor = 0;
        this.status = "off";
    }

    public void pushButton(Integer floorNumber)
    {
        queue.add(floorNumber);
    }

    public void changeFloors()
    {
        while (!queue.isEmpty())
        {
             Integer nextFloor = queue.poll();
             int floorDifference = Math.abs(floor - nextFloor);
             int timeToTravel = nextFloor * (5 * floorDifference);

             try
             {
                 Thread.sleep(timeToTravel * 1000);
                 floor = nextFloor;
                 System.out.println(floorDisplay());
                 System.out.println("Opening doors for new passengers");
                 Thread.sleep(DOOR_OPEN_TIME);
                 System.out.println("Closing doors and travelling to next destination");
             }
             catch (InterruptedException e)
             {
                 System.out.println("FATAL ERROR");
             }

        }
    }

    public void run()
    {
        this.status = "running";
        new Thread(() -> {
           while (!status.equals("off")) {
               if (!queue.isEmpty())
                   changeFloors();
           }
        }).start();
    }

    public void stop()
    {
        this.status = "off";
    }

}
