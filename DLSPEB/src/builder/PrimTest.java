package builder;

public abstract class PrimTest
{
  protected DancerProgram dancerProgram;
  
  PrimTest(DancerProgram dancerProgram)
  {
    this.dancerProgram = dancerProgram;
  }
  
  public abstract boolean eval();
}
