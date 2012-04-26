package builder;

public class IsBeakNotUp extends PrimTest
{
  IsBeakNotUp(DancerProgram dancerProgram)
  {
    super(dancerProgram);
  }
  
  @Override
  public boolean eval()
  {
    return !dancerProgram.outputModule.is_beak_up();
  }
}