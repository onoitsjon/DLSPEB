package builder;

import java.util.Iterator;

public class DancerStatementWithStatementList extends DancerStatement
{
  protected DancerStatementList statements;

  public DancerStatementWithStatementList(DancerProgram dancerProgram, IDGenerator idGenerator, Object sync)
  {
    super(dancerProgram, idGenerator, sync);
    statements = new DancerStatementList(dancerProgram, idGenerator, sync);
  }

  public void appendStatement(DancerStatement statement)
  {
    statements.appendStatement(statement);
  }

  public void insertStatement(int index, DancerStatement statement)
  {
    statements.insertStatement(index, statement);
  }
}