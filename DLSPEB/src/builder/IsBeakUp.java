package builder;

public class IsBeakUp extends PrimTest
{
  IsBeakUp(DancerProgram dancerProgram)
  {
    super(dancerProgram);
  }
  
  @Override
  public boolean eval()
  {
    return dancerProgram.outputModule.is_beak_up();
  }
}
