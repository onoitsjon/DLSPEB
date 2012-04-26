package builder;

import java.util.LinkedList;
import java.util.List;

public class Perform extends DancerStatement
{
  private List<String> colors;
  
  public Perform(DancerProgram dancerProgram, IDGenerator idGenerator, Object sync)
  {
    super(dancerProgram, idGenerator, sync);
    colors = new LinkedList<String>();
  }
  
  public List<String> getColors()
  {
    return colors;
  }
  
  @Override
  protected void evalCode(boolean isStep)
  {
    for (String color : colors)
    {
      dancerProgram.colors.get(color).eval(false);
    }
  }
  
  @Override
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
    for (String color : colors)
    {
      dancerProgram.colors.get(color).eval(false);
    }
  }
}
