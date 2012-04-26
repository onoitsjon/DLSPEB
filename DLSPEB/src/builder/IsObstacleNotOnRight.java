package builder;

public class IsObstacleNotOnRight extends PrimTest
{
  IsObstacleNotOnRight(DancerProgram dancerProgram)
  {
    super(dancerProgram);
  }
  
  @Override
  public boolean eval()
  {
    return !dancerProgram.outputModule.is_obstacle_on_right();
  }
}
