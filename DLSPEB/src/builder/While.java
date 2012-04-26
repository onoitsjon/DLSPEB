package builder;

public class While extends DancerStatementWithStatementList
{
  private PrimTest primTest;
  
  While(DancerProgram dancerProgram, IDGenerator idGenerator, Object sync)
  {
    super(dancerProgram, idGenerator, sync);
  }
  
  public void setPrimTest(PrimTest primTest)
  {
    this.primTest = primTest;
  }
  
  @Override
  protected void evalCode(boolean isStep)
  {
    while (primTest.eval())
    {
      for (DancerStatement statement : statements)
      {
        statement.eval(isStep);
      }
    }
  }
  
  public void run()
  {
    while (primTest.eval())
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
