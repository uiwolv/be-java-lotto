package kr.codesquad.exception;

public class ColumnOverflowException extends LottoException{
    private static final String MESSAGE = "로또는 반드시 한 줄에 6개를 입력해야 합니다.";
    public ColumnOverflowException() {
        super(MESSAGE);
    }
}
