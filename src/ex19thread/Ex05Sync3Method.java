package ex19thread;

/*
동기화 메소드
	: 여러쓰레드에 의해 호출되는 공유 메소드를 동기화하여
	여거 쓰레드가 동시에 접근되지 못하도록 Lock을 거는 것을 말함.
	synchronized에 의해 쓰레드1이 메소드를 호출하게 되면 
	쓰레드2는 접근이 불가능하다. 호출시 자물쇠로 잠그게되고,
	 실행종료시 열쇠를 통해 열게되는 개념이다. 이를 ‘동기화’라고 한다.
	형식] 접근지정자 synchronized 반환타입 메소드명(){
			실행문장...
			}
 */
class MethodSyncClass{
	
	
	//공유메소드를 동기화 처리함
	synchronized void increase(int seed, int inc) {
		for(int i=1; i<=10; i++) {
			seed += inc;
			System.out.println(
					String.format("쓰레드명:%s, 씨드값:%d",
					Thread.currentThread().getName(), seed));
			/*
			메소드 자체가 동기화 처리 되어 있으므로 쓰레드 실행중에 
			sleep()을 만나더라도 그 사이 다른 쓰레드는 접근이 불가능하다.
			 */
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {	}
		}
	}
}

class MethodSyncThread extends Thread{
	
	MethodSyncClass msc;//공유객체
	int seed, inc;
	public MethodSyncThread(String threadName, 
			MethodSyncClass msc, int seed, int inc) {
		
		super(threadName);//쓰레드 이름을 지정함
		this.msc = msc;
		this.seed = seed;
		this.inc = inc;
	}
	@Override
	public void run() {
		msc.increase(seed, inc);
	}
}

public class Ex05Sync3Method {

	public static void main(String[] args) {
		
		//공유메소드를 가진 클래스를 인스턴스화
		MethodSyncClass msc = new MethodSyncClass();
		
		MethodSyncThread t1 = new MethodSyncThread("1st쓰레드", msc, 10, 2);
		MethodSyncThread t2 = new MethodSyncThread("2nd쓰레드", msc, 10, 5);
				
		t1.start();
		t2.start();
	}
}
