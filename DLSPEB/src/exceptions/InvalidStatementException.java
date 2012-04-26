package exceptions;

public class InvalidStatementException extends Exception
{
  private String message;
  
  public InvalidStatementException()
  {
    super();
    message = null;
  }
  
  public InvalidStatementException(String message)
  {
    super(message);
    this.message = message;
  }
  
  public String getMessage()
  {
    return message;
  }
}
