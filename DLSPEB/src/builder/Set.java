package builder;

public class Set extends DancerStatement
{
  public Set(DancerProgram dancerProgram, IDGenerator idGenerator, Object sync)
  {
    super(dancerProgram, idGenerator, sync);
  }

  @Override
  protected void evalCode(boolean isStep)
  {
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
  }
}