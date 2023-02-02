/**
 * 로또 번호 생성기 Point
 * 1. Random 객체 사용법
 * - random.nextInt(값 범위) + 시작할 범위
 * 2. input 값 검증
 * 3. 로또 번호 중복 검사
 * - HashSet을 이용한 중복 제거 및 검사 // HashMap을 사용하지 않은 이유 : 좀 더 중복 제거의 의미를 두고 싶어서, 사용해도 문제는 없을 듯
 * 4. 오름 차순 정렬 후 출력
 * - HashSet -> List -> Collections.sort() 이용
 * */
public class Main {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.input();
        lotto.output();
    }
}