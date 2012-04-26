package exceptions;

public class IdentifierAlreadyInUseException extends Exception
{
  private String message;
  
  public IdentifierAlreadyInUseException()
  {
    super();
    message = null;
  }
  
  public IdentifierAlreadyInUseException(String message)
  {
    super(message);
    this.message = message;
  }
  
  public String getMessage()
  {
    return message;
  }
}
