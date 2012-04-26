package builder;

public class IDGenerator
{
  private long nextID;
  
  public IDGenerator()
  {
    nextID = 0;
  }
  
  public long getID()
  {
    nextID++;
    return nextID - 1;
  }
}