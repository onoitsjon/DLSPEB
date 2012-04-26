package exceptions;

public class InvalidOutputModuleException extends Exception
{
  private String message;
  
  public InvalidOutputModuleException()
  {
    super();
    message = null;
  }
  
  public InvalidOutputModuleException(String message)
  {
    super(message);
    this.message = message;
  }
  
  public String getMessage()
  {
    return message;
  }
}