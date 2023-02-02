import java.util.*;

public class Lotto {

    private int lottoNum;
    private Set<Integer> lottoSet;

    public void input() {
        System.out.println("----- 로또 번호 갯수를 입력해 주세요 -----");
        System.out.print("번호 개수 : ");
        Scanner sc = new Scanner(System.in);

        // 잘못된 값이 들어갈 경우 검증
        try {
            this.lottoNum = sc.nextInt();
            if(lottoNum < 6) throw new Exception();
        } catch (Exception e) {
            System.out.println("---------- 잘못된 값을 입력하셨습니다 ----------");
            return;
        }

        // 로또 생성 -- 중복 제거를 위해 set 사용 (Hash라는 자료구조가 값 겁색에 최적화 되어있기 때문에 HashMap 사용 -> contains() 효율적)
        Random random = new Random();
        lottoSet = new HashSet<>();
        while(lottoSet.size() < 6) {
            int tmp = random.nextInt(lottoNum) + 1;
            if(lottoSet.contains(tmp)) continue;
            
            lottoSet.add(tmp);
        }
    }

    public void output() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>(this.lottoSet);
        Collections.sort(list);
        for(int x : list) {
            sb.append(x).append(" ");
        }
        System.out.println("로또 결과 : " + sb.toString());
    }
}
