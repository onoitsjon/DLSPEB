package builder;

import java.util.Iterator;
import java.util.LinkedList;

public class DancerStatementList extends DancerStatement implements Iterable<DancerStatement>
{
  private LinkedList<DancerStatement> statements;

  public DancerStatementList(DancerProgram dancerProgram, IDGenerator idGenerator, Object sync)
  {
    super(dancerProgram, idGenerator, sync);
    statements = new LinkedList<DancerStatement>();
  }

  public void appendStatement(DancerStatement statement)
  {
    statements.addLast(statement);
  }

  public void insertStatement(int index, DancerStatement statement)
  {
    statements.add(index, statement);
  }
  
  /**
   * Returns the index of the first statement in the List with the given statement_id.
   * @param statement_id The ID of the statement we're looking for
   * @return the index or -1 if the statement isn't in the list
   */
  public int indexOf(long statement_id)
  {
    for (int i = 0; i < statements.size(); i++)
    {
      if (statements.get(i).getID() == statement_id)
        return i;
    }
    return -1;
  }
  
  public DancerStatement delete(int index)
  {
    return statements.remove(index);
  }
  
  @Override
  protected void evalCode(boolean isStep)
  {
    
  }
  
  public Iterator<DancerStatement> iterator()
  {
    return statements.iterator();
  }
}