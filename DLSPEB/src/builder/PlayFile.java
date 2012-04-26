package builder;

import java.io.File;

public class PlayFile extends DancerStatement
{
  private String filename;

  public PlayFile(DancerProgram dancerProgram, IDGenerator idGenerator, Object sync)
  {
    super(dancerProgram, idGenerator, sync);
  }

  public String getFilename()
  {
    return filename;
  }

  /**
   * Sets the filename to given filename.
   */
  public void setFilename(String filename)
  {
    this.filename = filename;
  }

  @Override
  protected void evalCode(boolean isStep)
  {
    dancerProgram.getOutputModule().play_file(filename);
  }
  
  @Override
  public void run()
  {
    dancerProgram.getOutputModule().play_file(filename);
  }
}
