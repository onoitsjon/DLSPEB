package builder;

public class Macro extends DancerStatementWithStatementList
{
  public Macro(DancerProgram dancerProgram, IDGenerator idGenerator, Object sync)
  {
    super(dancerProgram, idGenerator, sync);
  }

  @Override
  protected void evalCode(boolean isStep)
  {
    for (DancerStatement statement : statements)
    {
      statement.eval(isStep);
    }
  }
  
  public DancerStatementList getStatementList()
  {
    return statements;
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
    for (DancerStatement statement : statements)
    {
      statement.run();
    }
  }
}
