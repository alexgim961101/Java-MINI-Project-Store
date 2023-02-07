/**
 * 서브쓰레드 생성 방법
 * 1. Runnable을 구현한 클래스 생성
 * 2. Run 메서드 구현
 * 3. Thread 를 통해 Runnable을 구현한 클래스를 쓰레드로 등록
 * */
public class ThreadEx01 {
    // 자바의 메인 쓰레드
    public static void main(String[] args) throws InterruptedException {
        
        SubThread sb = new SubThread();
        Thread t1 = new Thread(sb);      // 타겟 등록

        t1.start();                      // run 메서드 실행 -> 쓰레드 생성
        
        for(int i = 1; i < 11; i++) {
            Thread.sleep(1000);                 // 쓰레드를 1초간 멈춰줌 (1초 = 1000ms)
            System.out.println("메인쓰레드 : " + i);
        }
    }
}

// 서브쓰레드를 실행시키려면 쓰레드 객체가 필요
class SubThread implements Runnable{
    // 자바의 서브쓰레드
    @Override
    public void run() {
        for(int i = 1; i < 11; i++) {
            try {
                Thread.sleep(1000);                 // 쓰레드를 1초간 멈춰줌 (1초 = 1000ms)
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("서브쓰레드 : " + i);
        }
    }
}
