package builder;

public class DancerStepper implements Runnable
{
  private DancerStatementList program;
  
  public DancerStepper(DancerStatementList program)
  {
    this.program = program;
  }
  
  @Override
  public void run()
  {
    for (DancerStatement statement : program)
    {
      statement.run();
    }
  }
}