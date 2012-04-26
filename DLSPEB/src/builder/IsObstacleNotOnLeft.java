package builder;

public class IsObstacleNotOnLeft extends PrimTest
{
  IsObstacleNotOnLeft(DancerProgram dancerProgram)
  {
    super(dancerProgram);
  }
  
  @Override
  public boolean eval()
  {
    return !dancerProgram.outputModule.is_obstacle_on_left();
  }
}