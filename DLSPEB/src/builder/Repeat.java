package builder;

public class Repeat extends DancerStatementWithStatementList
{
  private int timesToRepeat;
  
  Repeat(DancerProgram dancerProgram, IDGenerator idGenerator, Object sync)
  {
    super(dancerProgram, idGenerator, sync);
  }
  
  public void setTimesToRepeat(int timesToRepeat)
  {
    this.timesToRepeat = timesToRepeat;
  }
  
  @Override
  protected void evalCode(boolean isStep)
  {
    for (int i = 0; i < timesToRepeat; i++)
    {
      for (DancerStatement statement : statements)
      {
        statement.eval(false);
      }
    }
  }
  
  public void run()
  {
    for (int i = 0; i < timesToRepeat; i++)
    {
      dancerProgram.helper(true);
      synchronized (sync)
      {
        try {
          sync.wait();
        } catch (InterruptedException e) {
        }
      }
      for (DancerStatement statement : statements)
      {
        statement.run();
      }
    }
    dancerProgram.helper(false);
    synchronized (sync)
    {
      try {
        sync.wait();
      } catch (InterruptedException e) {
      }
    }
  }
}
