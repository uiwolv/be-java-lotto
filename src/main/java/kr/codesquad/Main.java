package kr.codesquad;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 돈 들어오면 -> 서비스 레벨에서 금액만큼의 랜덤 로또를 발급해서 return
         */
        LottoController lottoController = new LottoController();
        lottoController.receiveInput();
        /**
         * 당첨번호 입력 -> 서비스 레벨에서 compare해서 각 Row마다 match 갯수 저장
         * 통계 결과를 출력
         */
        lottoController.inputAnswers();
    }
}