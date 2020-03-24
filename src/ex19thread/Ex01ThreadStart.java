package ex19thread;

/*
Thread(쓰레드)
 - 쓰레드의 생성은 Thread 클래스를 상속받는것부터 시작한다.
 - 해당 방법은 쓰레드로 생성할 클래스가 다른 클래스를
  	상속받지 않아도 될때 사용한는 방식이다.
 - 만약 다른 클래스를 상속받아야 한다면 JAVA는 다중 상속이 불가능하므로
 	Runnable 인터페이스를 구현하는 방법을 사용해야한다.
 */

class ShowThread extends Thread{
	String threadName;

	public ShowThread(String threadName) {
		super();
		this.threadName = threadName;
	}
	/*
	run()메소드는 쓰레드의 main()메소드에 해당한다.
	Thread 클래스의 run()을 오버라이딩 한 것으로, 
	해당 메소드는 직접 호출하면 안되고, start()를 통해
	간접적으로 호출해야한다.
	만약 직접 run()을 호출하면 단순한 실핼만 될 뿐 
	쓰레드가 생성되지 않는다.
	 */
	
	
	@Override
	public void run() {
		for(int i = 1; i<= 100 ; i++) {
			System.out.println("안녕하세요.["+threadName+"]입니다.");
			try {
				/*
				Thread 클래스의 static메소드로 실행의 흐름을 주어진 시간만큼
				Block상태로 전환시켜 준다.
				1000밀리초 = 1초 이므로 아래는 0.02초 만큼 Block시킨다.
				 */
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}

public class Ex01ThreadStart {

	
	public static void main(String[] args) {
		
		ShowThread st1 = new ShowThread("쓰레드1st");
		ShowThread st2 = new ShowThread("Tread2nd");

		//쓰레드 객체를 통한 쓰레드 생성(실행)
		st1.start();
		st2.start();
		
		/*
		run()을 통한 호출은 가능하나 쓰레드가 생성되지 않아 
		동시에 실행되지 않는다..
		그냥 일반적인 클래스를 실행한것과 동일
		 */
//		st1.run();
//		st2.run();
		
		
		
	}
}






























