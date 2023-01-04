package kr.codesquad;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Row;
import kr.codesquad.domain.Statistic;
import kr.codesquad.domain.WinningNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoViewer {

    private final LottoController lottoController;

    public LottoViewer() {
        this.lottoController = new LottoController();
    }

    public Lotto home() throws IOException {
        System.out.println("구입 금액을 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputMoney = Integer.parseInt(br.readLine());
        int num = Statistic.getRowCountICanBuy(inputMoney);
        System.out.println(num + "개를 구매했습니다.");
        Lotto lotto = lottoController.createLotto(inputMoney);
        printRows(lotto.getTotalLotto());
        return lotto;
    }
    public void printRows(List<Row> rows) {
        for (Row row : rows) {
            List<Integer> values = row.getValues();
            System.out.println(values);
        }
    }
    public void inputResult(Lotto lotto) throws IOException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < Row.COLUMN; i++) {
            answerList.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(br.readLine());
        WinningNumbers winningNumbers = new WinningNumbers(Row.createRow(answerList), bonusNumber);
        printResults(lotto, winningNumbers);
    }

    private void printResults(Lotto lotto, WinningNumbers winningNumbers) {
        Statistic statistic = lottoController.result(lotto, winningNumbers);
        statistic.printStatistics();
    }

}
