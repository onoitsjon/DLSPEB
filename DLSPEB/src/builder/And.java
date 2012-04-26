package builder;

public class And extends PrimTest
{
  private PrimTest right;
  private PrimTest left;
  
  public And(DancerProgram dancerProgram)
  {
    super(dancerProgram);
  }

  public void setRight(PrimTest right)
  {
    this.right = right;
  }

  public void setLeft(PrimTest left)
  {
    this.left = left;
  }

  @Override
  public boolean eval()
  {
    return right.eval() && left.eval();
  }
}
