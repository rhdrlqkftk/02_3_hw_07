package HWHW;

public class DuplicateException extends Exception {

	public DuplicateException() {
		super("이미 존재하는 상품입니다.");
	}

	public DuplicateException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DuplicateException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DuplicateException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DuplicateException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
