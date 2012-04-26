package builder;

public class DancerStatement implements Runnable
{
  protected long id;
  protected DancerProgram dancerProgram;
  protected Object sync;

  public DancerStatement(DancerProgram dancerProgram, IDGenerator idGenerator, Object sync)
  {
    id = idGenerator.getID();
    this.dancerProgram = dancerProgram;
    this.sync = sync;
  }

  public long getID()
  {
    return id;
  }

  public void eval(boolean isStep)
  {
    if (isStep)
    {
      //Give this.id to DancerProgram
      //Thread.sleep() until interrupted by DancerProgram
    }
    evalCode(isStep);
  }
  
  protected void evalCode(boolean isStep)
  {
  }
  
  @Override
  public void run()
  {
  }
}