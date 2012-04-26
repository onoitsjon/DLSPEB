package exceptions;

public class InvalidIDException extends Exception
{
  private String message;
  
  public InvalidIDException()
  {
    super();
    message = null;
  }
  
  public InvalidIDException(String message)
  {
    super(message);
    this.message = message;
  }
  
  public String getMessage()
  {
    return message;
  }
}