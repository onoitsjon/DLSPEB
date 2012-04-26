package builder;

public class MovementCommand extends DancerStatement
{
   private String command;
   
   public MovementCommand(DancerProgram dancerProgram, IDGenerator idGenerator, Object sync)
   {
     super(dancerProgram, idGenerator, sync);
   }

   /**
    * @assumes command is either go_forward, go_backward, rotate_left,
    *  or rotate_right
    */
   public void setCommand(String command)
   {
     this.command = command;
   }

   @Override
   protected void evalCode(boolean isStep)
   {
     //Use Finch or Virtual functions .go_forward(), .go_backward(), .rotate_left(), or .rotate_right().
     if (command.equals("go_forward"))
       dancerProgram.getOutputModule().go_forward();
     else if (command.equals("go_backward"))
       dancerProgram.getOutputModule().go_backward();
     else if (command.equals("rotate_left"))
       dancerProgram.getOutputModule().rotate_left();
     else //if (command.equals(rotate_right))
       dancerProgram.getOutputModule().rotate_right();
   }
   
   public void run()
   {
     dancerProgram.helper(true);
     synchronized (sync)
     {
       try {
         sync.wait();
       } catch (InterruptedException e) {
       }
     }
     System.out.println("About to move.");
     evalCode(true);
   }
}
