package builder;

public class IsObstacleOnLeft extends PrimTest
{
  IsObstacleOnLeft(DancerProgram dancerProgram)
  {
    super(dancerProgram);
  }
  
  @Override
  public boolean eval()
  {
    return dancerProgram.outputModule.is_obstacle_on_left();
  }
}
