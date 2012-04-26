package builder;

public class IsObstacleOnRight extends PrimTest
{
  IsObstacleOnRight(DancerProgram dancerProgram)
  {
    super(dancerProgram);
  }
  
  @Override
  public boolean eval()
  {
    return dancerProgram.outputModule.is_obstacle_on_right();
  }
}
