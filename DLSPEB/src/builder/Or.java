package builder;

public class Or extends PrimTest
{
   private PrimTest right;
   private PrimTest left;
   
   public Or(DancerProgram dancerProgram)
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

   public boolean eval()
   {
     return right.eval() || left.eval();
   }
}
